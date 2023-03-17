package training;

import MaXx.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaXxGraph {
    ArrayList<MaXxNodeWrapper> nodes;
    ArrayList<MaXxDirectedWeightedEdge> edges;
    MaXxAdjazenzmatrix adjazenzmatrix;
    public MaXxGraph(){
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.adjazenzmatrix  = null;
    }
    public MaXxGraph addEdge(MaXxNodeWrapper src, MaXxNodeWrapper dst, double costs){
        this.edges.add(new MaXxDirectedWeightedEdge(src, dst, costs));
        return this;
    }

    public MaXxGraph addNode(MaXxNodeWrapper node){
        this.nodes.add(node);
        return this;
    }

    public DijkstraTable Dijkstra(MaXxNodeWrapper source) {
        int matrixVectorScope;
        double currentCosts = 1d;
        MaXxNodeWrapper scope = source;
        Set<MaXxDijkstraTupel> reachable = new HashSet<>();
        Set<MaXxNodeWrapper> visited = new HashSet<>();
        //Init
        for (MaXxNodeWrapper e :
                this.nodes) {
            if (!e.equals(source)) {
                reachable.add(new MaXxDijkstraTupel(e, null, 0d));
            }
            visited.add(e);
        }
        //Iterative Algorithm
        boolean help = false;
        for (int j = 0; j < reachable.size(); j++) {
            matrixVectorScope = getVector(scope);
            for (MaXxDijkstraTupel e : reachable) {
                int matrixVectorTarget = getVector(e.destination);
                if (this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] != 0) {
                    if ((this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] + currentCosts) > e.costs) {
                        e.costs = this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] + currentCosts;
                        e.destination = this.adjazenzmatrix.nodes[matrixVectorTarget];
                        e.predecessor = scope;
                        e.step = j+1;
                        if (e.costs >= 53d) {
                            help = true;
                            break;
                        }
                    }if(help) break;
                } if (help) break;
            } if (help) break;
            currentCosts = 1d;
            visited.remove(scope);
            for (MaXxDijkstraTupel e : reachable) {
                if (visited.contains(e.destination) && e.costs > currentCosts) {
                    scope = e.destination;
                    currentCosts = e.costs;
                }
            }
        }
        reachable.forEach(e -> {
            if(e.predecessor!=null) System.out.println(e);
        });
        return null;
    }
    public int getVector(MaXxNodeWrapper source) {
        int i = 0;
        for (MaXxNodeWrapper e : this.adjazenzmatrix.nodes) {
            if (source.equals(e)) break;
            i++;
        }
        return i;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MaXxGraph graph = new MaXxGraph();
        Spielfigur[] p = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(p);
        System.out.println(spielfeld);
        int i = 0;
        Fraction[][] fm = spielfeld.getFeld();
        for (Fraction[] fa:
             fm) {
            for (Fraction f:
                 fa) {
                graph.addNode((new MaXxNodeWrapper(new Node(f.toString()), f, i)));
                i++;
            }
        }
        i = 0;
        for(MaXxNodeWrapper n : graph.nodes){
            int columnIndex = i%8;
                double srcValue = n.value.getNumerator().equals(BigInteger.ZERO) ? 0.0 : n.value.doubleValue();
                double dstValue;
            if (i>7) {
                //Nördliche Kanten
                dstValue = graph.nodes.get((i-8)).value.getNumerator().equals(BigInteger.ZERO) ? 0.0 : graph.nodes.get((i-8)).value.doubleValue();
                graph.addEdge(n, graph.nodes.get((i-8)), dstValue);
                graph.addEdge(graph.nodes.get((i-8)), n, srcValue);
            }
            if (i<56){
                //Südliche Kanten
                dstValue = graph.nodes.get((i+8)).value.getNumerator().equals(BigInteger.ZERO) ? 0.0 : graph.nodes.get((i+8)).value.doubleValue();
                graph.addEdge(n, graph.nodes.get((i+8)), dstValue);
                graph.addEdge(graph.nodes.get((i+8)), n, srcValue);
            }
            if (columnIndex!=7){
                //Östliche Kanten
                dstValue = graph.nodes.get((i+1)).value.getNumerator().equals(BigInteger.ZERO) ? 0.0 : graph.nodes.get((i+1)).value.doubleValue();
                graph.addEdge(n, graph.nodes.get((i+1)), dstValue);
                graph.addEdge(graph.nodes.get((i+1)), n, srcValue);
            }
            if (columnIndex!=0){
                //Westliche Kanten
                dstValue = graph.nodes.get((i-1)).value.getNumerator().equals(BigInteger.ZERO) ? 0.0 : graph.nodes.get((i-1)).value.doubleValue();
                graph.addEdge(n, graph.nodes.get((i-1)), dstValue);
                graph.addEdge(graph.nodes.get((i-1)), n, srcValue);
            }
                //Nordösliche Kante
                //graph.addEdge(n, graph.nodes.get((i-7)), graph.nodes.get((i-7)).srcValue.doubleValue());
                //Südwestliche Kante
                //graph.addEdge(n, graph.nodes.get((i+7)), graph.nodes.get((i+7)).srcValue.doubleValue());

            i++;
        }

        /*
        for (int k = 0; k <= i; k++){
            for (int l = 0; l <= j; l++){
                if (l>0&&l<j){

                }
            }
        }

         */

        graph.adjazenzmatrix = new MaXxAdjazenzmatrix(graph.nodes, graph.edges);
        //System.out.println(graph.adjazenzmatrix);
        DijkstraTable table1 = graph.Dijkstra(graph.nodes.get(44));
        System.out.println();
        DijkstraTable table2 = graph.Dijkstra(graph.nodes.get(19));
    }
}

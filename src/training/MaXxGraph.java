package training;

import MaXx.*;

import java.io.IOException;
import java.util.ArrayList;

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MaXxGraph graph = new MaXxGraph();
        Spielfigur[] p = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(p);
        System.out.println(spielfeld);
        int i = 0;
        int j = 0;
        Fraction[][] fm = spielfeld.getFeld();
        for (Fraction[] fa:
             fm) {
            for (Fraction f:
                 fa) {
                graph.addNode((new MaXxNodeWrapper(new Node(f.toString()), f, i, j)));
                j++;
            }
            i++;
        }
        i = 0;
        for(MaXxNodeWrapper n : graph.nodes){
            int rowIndex = i%8;
            if(rowIndex>0 && rowIndex<7 && i>7 && i<56){
                graph.addEdge(n, graph.nodes.get((i-8)), graph.nodes.get((i-8)).value.doubleValue());
                graph.addEdge(graph.nodes.get((i-8)), n, n.value.doubleValue());
            }
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

        graph.nodes.forEach(System.out::println);
        graph.adjazenzmatrix = new MaXxAdjazenzmatrix(graph.nodes, graph.edges);
        System.out.println(graph.adjazenzmatrix);
    }
}
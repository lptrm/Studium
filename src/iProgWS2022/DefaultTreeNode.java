package iProgWS2022;
/**
 * @version 1, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
/**
 * Basisklasse für Standardimplemntierung für das SimpleTreeNode Interface
 */
public class DefaultTreeNode implements SimpleTreeNode{
    private int CAPACITY;
    private String name;
    private SimpleTreeNode[] childs;
    private int childcnt;
    /**
     * Standardkonstruktor
     * @param name
     * @return DefaultTreeNode
     */
    public DefaultTreeNode(String name){
        this.name = name;
        this.CAPACITY = 1;
        this.childs = new SimpleTreeNode[1];
        this.childcnt = 0;
    }
    /**
     * Fügt einem Knoten einen anderen Knoten als "Kind" hinzu
     * @param child
     */
    public void addChild(SimpleTreeNode child) {
        if (this.childcnt >= this.CAPACITY){
            //Kapazitätsverdopplung ist sinnvoll, wird später noch erläutert
            //Hierdurch ist der Durchschnittliche Aufwand für das Element einfach errechenbar(?)
            this.CAPACITY *= 2;
            SimpleTreeNode[] newchild =  new SimpleTreeNode[this.CAPACITY];
            if (this.childcnt >= 0) System.arraycopy(this.childs, 0, newchild, 0, this.childcnt);
            this.childs = newchild;
        }
        this.childs[this.childcnt++] = child;
    }
    /**
     * Gibt die Anzahl der Kinder eines Knotens zurück
     * @return Integer-Zahl, entsprechend der Anahl der Kinder des Knotens
     */
    @Override
    public int getChildCnt() {
        return this.childcnt;
    }
    /**
     * add many items into the sorted list
     * @param pos
     * @return gibt eine Referenz auf einen Knoten zurück
     */
    @Override
    public SimpleTreeNode getChild(int pos) {
        return this.childs[pos];
    }
}

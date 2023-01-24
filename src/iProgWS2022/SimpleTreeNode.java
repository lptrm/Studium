package iProgWS2022;
/**
 * @version 0.58, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
public interface SimpleTreeNode{

    public void addChild(SimpleTreeNode child);
    public int getChildCnt();
    public SimpleTreeNode getChild(int pos);
}

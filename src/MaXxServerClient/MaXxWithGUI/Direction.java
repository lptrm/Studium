package MaXxServerClient.MaXxWithGUI;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public enum Direction {
    NORTH(-1,0), EAST(0,1), SOUTH(1,0),
    WEST(0,-1), NORTH_EAST(-1,1), SOUTH_WEST(1,-1);

    private final int row, column;

    Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
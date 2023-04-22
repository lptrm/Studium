package MaXxWithGUI;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public enum Characters {
    BLACK("B"), WHITE("W");
    private final String sign;
    private Direction[] direction;

    Characters(String sign) {
        this.sign = sign;
        if (this.sign.equals("B")) {
            this.direction = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.SOUTH_WEST};
        }
        if (this.sign.equals("W")) {
            this.direction = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH_EAST};
        }
    }
    public String getSign() {
        return this.sign;
    }

    public Direction[] getDirection() {
        return direction;
    }
}
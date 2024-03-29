package MaXxServerClient.MaXxWithGUI;

/**
 * @author Jan Obernberger
 * @version X, 11.01.2023
 **/

public class GameCharacter {
    private final Characters characters;
    private int row;
    private int column;
    private Fraction points = new Fraction(0,0);


    public GameCharacter(Characters characters) {
        this.characters = characters;
        row = this.characters == Characters.WHITE ? 2 : 5;
        column = this.characters == Characters.WHITE ? 3 : 4;
    }
    @Override
    public String toString() {
        return characters.toString().substring(0,1);
    }

    public Fraction getPoints() {
        return points;
    }

    public void setPoints(Fraction f) {
        this.points = this.points.add(f);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Characters getCharacters() {
        return characters;
    }
}
enum Characters {
    BLACK(),
    WHITE();
    Direction[] directions;
    Characters() {
        if (ordinal()==0) directions = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.SOUTH_WEST};
        if (ordinal()==1) directions = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH_EAST};
    }
}
class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}

abstract class Piece {
  
    protected Position position;
    protected String color;

    public Piece(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() { return position; }
    public String getColor() { return color; }

    public abstract boolean isLegalMove(Position b);
}

class Rook extends Piece {
  
    public Rook(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        return position.getRow() == b.getRow() || position.getCol() == b.getCol();
    }
}

class Bishop extends Piece {

    public Bishop(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        return Math.abs(position.getRow() - b.getRow()) == Math.abs(position.getCol() - b.getCol());
    }
}

class Queen extends Piece {

    public Queen(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        return position.getRow() == b.getRow()
            || position.getCol() == b.getCol()
            || Math.abs(position.getRow() - b.getRow()) == Math.abs(position.getCol() - b.getCol());
    }
}

class King extends Piece {

    public King(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        return Math.abs(position.getRow() - b.getRow()) <= 1
            && Math.abs(position.getCol() - b.getCol()) <= 1
            && !(position.getRow() == b.getRow() && position.getCol() == b.getCol());
    }
}

class Knight extends Piece {

    public Knight(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        int dr = Math.abs(position.getRow() - b.getRow());
        int dc = Math.abs(position.getCol() - b.getCol());
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }
}

class Pawn extends Piece {
  
    public Pawn(Position position, String color) {
        super(position, color);
    }

    public boolean isLegalMove(Position b) {
        int dr = b.getRow() - position.getRow();
        int dc = Math.abs(b.getCol() - position.getCol());
        if (color.equals("white")) {
            return (dr == 1 && dc == 0);
        } else {
            return (dr == -1 && dc == 0);
        }
    }
}

public class Problem2 {

    public static void main(String[] args) {
        Piece rook   = new Rook(new Position(0, 0), "white");
        Piece bishop = new Bishop(new Position(2, 2), "black");
        Piece queen  = new Queen(new Position(4, 4), "white");
        Piece knight = new Knight(new Position(1, 1), "black");
        Piece pawn   = new Pawn(new Position(3, 3), "white");
        Piece king   = new King(new Position(5, 5), "white");

        System.out.println("Rook (0,0) -> (0,5): "   + rook.isLegalMove(new Position(0, 5)));
        System.out.println("Rook (0,0) -> (3,2): "   + rook.isLegalMove(new Position(3, 2)));
        System.out.println("Bishop (2,2) -> (5,5): " + bishop.isLegalMove(new Position(5, 5)));
        System.out.println("Bishop (2,2) -> (2,5): " + bishop.isLegalMove(new Position(2, 5)));
        System.out.println("Queen (4,4) -> (4,7): "  + queen.isLegalMove(new Position(4, 7)));
        System.out.println("Queen (4,4) -> (7,7): "  + queen.isLegalMove(new Position(7, 7)));
        System.out.println("Knight (1,1) -> (3,2): " + knight.isLegalMove(new Position(3, 2)));
        System.out.println("Knight (1,1) -> (2,2): " + knight.isLegalMove(new Position(2, 2)));
        System.out.println("Pawn (3,3) -> (4,3): "   + pawn.isLegalMove(new Position(4, 3)));
        System.out.println("Pawn (3,3) -> (3,4): "   + pawn.isLegalMove(new Position(3, 4)));
        System.out.println("King (5,5) -> (6,6): "   + king.isLegalMove(new Position(6, 6)));
        System.out.println("King (5,5) -> (5,8): "   + king.isLegalMove(new Position(5, 8)));
    }
}

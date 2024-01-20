package chess;


public class tester
{
    public static void main(String[] args)
    {
        ChessGame game = new ChessGame();
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        System.out.println("new piece is on team " + piece.getTeamColor() + " and is a " + piece.getPieceType());
        ChessBoard board = new ChessBoard();
        ChessPosition pos = new ChessPosition(0, 0);
        ChessPosition check = new ChessPosition(1, 0);
        board.addPiece(pos, piece);
        board.resetBoard();
//        System.out.print(board.getPiece(pos).getPieceType());
        board.displayBoard();

    }
}

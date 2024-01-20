package chess;


public class tester
{
    public static void main(String[] args)
    {
//        ChessGame game = new ChessGame();
//        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
//        System.out.println("new piece is on team " + piece.getTeamColor() + " and is a " + piece.getPieceType());
        ChessBoard board = new ChessBoard();
        ChessBoard board2 = new ChessBoard();

        board.resetBoard();
//        board.displayBoard();

        board2.resetBoard();
//        board2.displayBoard();
        System.out.print(board.equals(board2));

    }
}

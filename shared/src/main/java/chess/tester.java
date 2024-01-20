package chess;


public class tester
{
    public static void main(String[] args)
    {
        ChessGame game = new ChessGame();
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        System.out.println("new piece is on team " + piece.getTeamColor() + " and is a " + piece.getPieceType());
        ChessBoard board = new ChessBoard();

        board.resetBoard();
////        System.out.print(board.getPiece(pos).getPieceType());
        board.displayBoard();

    }
}

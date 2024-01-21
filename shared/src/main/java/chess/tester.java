package chess;


import java.util.Collection;

public class tester
{
    public static void main(String[] args)
    {
//        ChessGame game = new ChessGame();
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
//        System.out.println("new piece is on team " + piece.getTeamColor() + " and is a " + piece.getPieceType());
        ChessBoard board = new ChessBoard();
        ChessBoard board2 = new ChessBoard();

        board.resetBoard();
        board.displayBoard();

//        board2.resetBoard();
//        board2.displayBoard();
//        System.out.print(board.equals(board2));
        ChessPosition pos = new ChessPosition(3, 8);
        Collection<ChessMove> moves = piece.pieceMoves(board, pos);
        String combine = "Moves{";
        for (ChessMove thing: moves)
        {
            String temp = "{" +
                    thing.getEndPosition().getRow() +
                    "," +
                    thing.getEndPosition().getColumn() +
                    "},";
            combine += temp;
        }
        System.out.print(combine);


    }
}

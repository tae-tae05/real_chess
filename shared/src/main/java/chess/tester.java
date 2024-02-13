package chess;


import java.util.Collection;

public class tester
{
    public static void main(String[] args)
    {
        ChessGame game = new ChessGame();
        game.setTeamTurn((ChessGame.TeamColor.BLACK));
        ChessBoard board = new ChessBoard();
        ChessPiece king = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        board.addPiece(new ChessPosition(5, 8), king);
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        board.addPiece(new ChessPosition(6, 7), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        board.addPiece(new ChessPosition(7, 6), piece);
//        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
//        board.addPiece(new ChessPosition(5, 4), piece);
//        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
//        board.addPiece(new ChessPosition(7, 4), piece);
//        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
//        board.addPiece(new ChessPosition(7, 3), piece);
//        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
//        board.addPiece(new ChessPosition(5, 8), piece);

         game.setBoard(board);
//        boolean bool = game.isInCheckmate(ChessGame.TeamColor.WHITE);
        boolean vert = game.checkVertical(ChessGame.TeamColor.WHITE, 5, 8);
        boolean horz = game.checkHorizontal(ChessGame.TeamColor.WHITE, 5, 8);
        boolean diagonal = game.checkDiagonal(ChessGame.TeamColor.WHITE, 5,8);
//        boolean knight = game.checkKnights(ChessGame.TeamColor.BLACK, 5, 4);
//        boolean pawn = game.checkPawn(ChessGame.TeamColor.WHITE, 5,4);
//        System.out.println(pawn || horz || diagonal || vert || knight);
//        Collection<ChessMove> moves = game.validMoves(new ChessPosition(5, 4));
//        System.out.println("checkmate = " + bool);
        System.out.println(diagonal);
        board.displayBoard();



    }
}

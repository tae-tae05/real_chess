package chess;


import java.util.Collection;

public class tester
{
    public static void main(String[] args)
    {
        ChessGame game = new ChessGame();
        game.setTeamTurn((ChessGame.TeamColor.WHITE));
        ChessBoard board = new ChessBoard();
        ChessPiece king = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
        board.addPiece(new ChessPosition(6, 5), king);
        ChessPiece rook = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        board.addPiece(new ChessPosition(8, 1), rook);
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        board.addPiece(new ChessPosition(5, 3), piece);

        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        board.addPiece(new ChessPosition(7, 4), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        board.addPiece(new ChessPosition(1, 2), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board.addPiece(new ChessPosition(7, 8), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        board.addPiece(new ChessPosition(5, 4), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        board.addPiece(new ChessPosition(3, 8), piece);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
        board.addPiece(new ChessPosition(2, 6), piece);


         game.setBoard(board);
//        boolean bool = game.isInCheckmate(ChessGame.TeamColor.BLACK);
//        boolean vert = game.checkVertical(ChessGame.TeamColor.BLACK, 7, 4);
//        boolean horz = game.checkHorizontal(ChessGame.TeamColor.BLACK, 7, 4);
//        boolean diagonal = game.checkDiagonal(ChessGame.TeamColor.BLACK, 7, 4);
//        boolean knight = game.checkKnights(ChessGame.TeamColor.BLACK, 7, 4);
//        boolean pawn = game.checkPawn(ChessGame.TeamColor.BLACK, 7, 4);
//        boolean kingCheck = game.checkKing(ChessGame.TeamColor.BLACK, 7, 4);
//        System.out.println("vert = " + vert);
//        System.out.println("hori = " + horz);
//        System.out.println("diagonal = " + diagonal);
//        System.out.println("knight = " + knight);
//        System.out.println("pawn = " + pawn);
//        System.out.println("king = " + kingCheck);
//        System.out.println(pawn || horz || diagonal || vert || knight);
//        Collection<ChessMove> moves = rook.pieceMoves(board, new ChessPosition(5, 6));
        boolean bool2 = game.isInCheck(ChessGame.TeamColor.BLACK);
        Collection<ChessMove> moves = game.validMoves(new ChessPosition(7, 4));
//        System.out.println("checkmate = " + bool);
//        System.out.println("moves = " + moves);
//        System.out.println("check= " + bool2);


        board.displayBoard();

    }
}

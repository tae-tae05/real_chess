package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMoves implements MovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        if (current == ChessGame.TeamColor.WHITE)
        {
            ChessPosition forward = new ChessPosition(row + 1, col);
            ChessPiece checker = board.getPiece(forward);
            if (checker == null)
            {
                if(row == 7)
                {
                    ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                    ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                    ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                    ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                    moves.add(add1);
                    moves.add(add2);
                    moves.add(add3);
                    moves.add(add4);
                }
                else {
                    ChessMove add = new ChessMove(myPosition, forward, null);
                    moves.add(add);
                }
                if(row == 2)
                {
                    ChessPosition forward2 = new ChessPosition(row + 2, col);
                    ChessMove add1 = new ChessMove(myPosition, forward2, null);
                    moves.add(add1);
                }
            }
            ChessPosition left = new ChessPosition(row + 1, col - 1);
            if (left.isValid(row + 1, col - 1))
            {
                ChessPiece checker2 = board.getPiece(left);
                if (checker2 != null && checker2.getTeamColor() == ChessGame.TeamColor.BLACK)
                {
                    if(row == 7)
                    {
                        ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                        ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                        ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                        ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                        moves.add(add1);
                        moves.add(add2);
                        moves.add(add3);
                        moves.add(add4);
                    }
                    else {
                        ChessMove add = new ChessMove(myPosition, forward, null);
                        moves.add(add);
                    }
                }
            }
            ChessPosition right = new ChessPosition(row + 1, col + 1);
            if (left.isValid(row + 1, col + 1))
            {
                ChessPiece checker2 = board.getPiece(right);
                if (checker2 != null && checker2.getTeamColor() == ChessGame.TeamColor.BLACK)
                {
                    if(row == 7)
                    {
                        ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                        ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                        ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                        ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                        moves.add(add1);
                        moves.add(add2);
                        moves.add(add3);
                        moves.add(add4);
                    }
                    else {
                        ChessMove add = new ChessMove(myPosition, forward, null);
                        moves.add(add);
                    }
                }
            }
        }
        else
        {
            ChessPosition forward = new ChessPosition(row - 1, col);
            ChessPiece checker = board.getPiece(forward);
            if (checker == null)
            {
                if(row == 2)
                {
                    ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                    ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                    ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                    ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                    moves.add(add1);
                    moves.add(add2);
                    moves.add(add3);
                    moves.add(add4);
                }
                else {
                    ChessMove add = new ChessMove(myPosition, forward, null);
                    moves.add(add);
                }
                if(row == 7)
                {
                    ChessPosition forward2 = new ChessPosition(row - 2, col);
                    ChessMove add1 = new ChessMove(myPosition, forward2, null);
                    moves.add(add1);
                }
            }
            ChessPosition left = new ChessPosition(row - 1, col - 1);
            if (left.isValid(row - 1, col - 1))
            {
                ChessPiece checker2 = board.getPiece(left);
                if (checker2 != null && checker2.getTeamColor() == ChessGame.TeamColor.WHITE)
                {
                    if(row == 2)
                    {
                        ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                        ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                        ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                        ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                        moves.add(add1);
                        moves.add(add2);
                        moves.add(add3);
                        moves.add(add4);
                    }
                    else {
                        ChessMove add = new ChessMove(myPosition, forward, null);
                        moves.add(add);
                    }
                }
            }
            ChessPosition right = new ChessPosition(row - 1, col + 1);
            if (left.isValid(row - 1, col + 1))
            {
                ChessPiece checker2 = board.getPiece(right);
                if (checker2 != null && checker2.getTeamColor() == ChessGame.TeamColor.WHITE)
                {
                    if(row == 2)
                    {
                        ChessMove add1 = new ChessMove(myPosition, forward, ChessPiece.PieceType.BISHOP);
                        ChessMove add2 = new ChessMove(myPosition, forward, ChessPiece.PieceType.QUEEN);
                        ChessMove add3 = new ChessMove(myPosition, forward, ChessPiece.PieceType.ROOK);
                        ChessMove add4 = new ChessMove(myPosition, forward, ChessPiece.PieceType.KNIGHT);
                        moves.add(add1);
                        moves.add(add2);
                        moves.add(add3);
                        moves.add(add4);
                    }
                    else {
                        ChessMove add = new ChessMove(myPosition, forward, null);
                        moves.add(add);
                    }
                }
            }
        }
        return moves;
    }
}

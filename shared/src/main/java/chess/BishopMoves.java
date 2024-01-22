package chess;

import java.util.Collection;
import java.util.ArrayList;
public class BishopMoves implements MovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current) {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        int updatedCol = col - 1;
        for (int i = row - 1; i > 0; i--)
        {
            if(updatedCol > 0)
            {
                ChessPosition add1 = new ChessPosition(i, updatedCol);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
                if (checker != null) {
                    break;
                }
            }
            updatedCol -= 1;
        }
        updatedCol = col + 1;
        for (int i = row + 1; i < 9; i++)
        {
            if(updatedCol < 9)
            {
                ChessPosition add1 = new ChessPosition(i, updatedCol);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
                if (checker != null) {
                    break;
                }
            }
            updatedCol += 1;
        }
        updatedCol = col - 1;
        for (int i = row + 1; i < 9; i++)
        {
            if(updatedCol > 0)
            {
                ChessPosition add1 = new ChessPosition(i, updatedCol);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
                if (checker != null) {
                    break;
                }
            }
            updatedCol -= 1;
        }
        updatedCol = col + 1;
        for (int i = row - 1; i > 0; i--)
        {
            if(updatedCol < 9)
            {
                ChessPosition add1 = new ChessPosition(i, updatedCol);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
                if (checker != null) {
                    break;
                }
            }
            updatedCol += 1;
        }
        return moves;
    }
    public Collection<ChessMove> helper(int row, int col, ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        Collection<ChessMove> moves = new ArrayList<>();
        return moves;
    }

}
//ChessPosition add1 = new ChessPosition(i, updatedCol);
//ChessMove add = new ChessMove(myPosition, add1, null);
//                moves.add(add);
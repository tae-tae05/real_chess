package chess;

import java.util.Collection;
import java.util.ArrayList;
public class BishopMoves implements MovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current) {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        for(int i = 1; i < 8; i++) {
            if (isValid(row + i, col + i)){
                if(board.getPiece(new ChessPosition( row + i, col + i)) == null)
                {
                    ChessPosition end = new ChessPosition(row + i, col + i);
                    moves.add(new ChessMove(myPosition, end, null));
                } else if (board.getPiece(new ChessPosition( row + i, col + i)).getTeamColor() != current) {
                    ChessPosition end = new ChessPosition(row + i, col + i);
                    moves.add(new ChessMove(myPosition, end, null));
                    break;
                }
                else {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        for(int i = 1; i < 8; i++) {
            if (isValid(row - i, col + i)){
                if(board.getPiece(new ChessPosition( row - i, col + i)) == null)
                {
                    ChessPosition end = new ChessPosition(row - i, col + i);
                    moves.add(new ChessMove(myPosition, end, null));
                } else if (board.getPiece(new ChessPosition( row - i, col + i)).getTeamColor() != current) {
                    ChessPosition end = new ChessPosition(row - i, col + i);
                    moves.add(new ChessMove(myPosition, end, null));
                    break;
                }
                else {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        for(int i = 1; i < 8; i++) {
            if (isValid(row + i, col - i)){
                if(board.getPiece(new ChessPosition( row + i, col - i)) == null)
                {
                    ChessPosition end = new ChessPosition(row + i, col - i);
                    moves.add(new ChessMove(myPosition, end, null));
                } else if (board.getPiece(new ChessPosition( row + i, col - i)).getTeamColor() != current) {
                    ChessPosition end = new ChessPosition(row + i, col - i);
                    moves.add(new ChessMove(myPosition, end, null));
                    break;
                }
                else {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        for(int i = 1; i < 8; i++)
        {
            if (isValid(row - i, col - i)){
                if(board.getPiece(new ChessPosition( row - i, col - i)) == null)
                {
                    ChessPosition end = new ChessPosition(row - i, col - i);
                    moves.add(new ChessMove(myPosition, end, null));
                } else if (board.getPiece(new ChessPosition( row - i, col - i)).getTeamColor() != current) {
                    ChessPosition end = new ChessPosition(row - i, col - i);
                    moves.add(new ChessMove(myPosition, end, null));
                    break;
                }
                else {
                    break;
                }
            }
            else
            {
                break;
            }
        }
//        int updatedCol = col - 1;
//        for (int i = row - 1; i > 0; i--)
//        {
//            if(updatedCol > 0)
//            {
//                ChessPosition add1 = new ChessPosition(i, updatedCol);
//                ChessPiece checker = board.getPiece(add1);
//                if (checker == null || checker.getTeamColor() != current) {
//                    ChessMove add = new ChessMove(myPosition, add1, null);
//                    moves.add(add);
//                }
//                if (checker != null) {
//                    break;
//                }
//            }
//            updatedCol -= 1;
//        }
//        updatedCol = col + 1;
//        for (int i = row + 1; i < 9; i++)
//        {
//            if(updatedCol < 9)
//            {
//                ChessPosition add1 = new ChessPosition(i, updatedCol);
//                ChessPiece checker = board.getPiece(add1);
//                if (checker == null || checker.getTeamColor() != current) {
//                    ChessMove add = new ChessMove(myPosition, add1, null);
//                    moves.add(add);
//                }
//                if (checker != null) {
//                    break;
//                }
//            }
//            updatedCol += 1;
//        }
//        updatedCol = col - 1;
//        for (int i = row + 1; i < 9; i++)
//        {
//            if(updatedCol > 0)
//            {
//                ChessPosition add1 = new ChessPosition(i, updatedCol);
//                ChessPiece checker = board.getPiece(add1);
//                if (checker == null || checker.getTeamColor() != current) {
//                    ChessMove add = new ChessMove(myPosition, add1, null);
//                    moves.add(add);
//                }
//                if (checker != null) {
//                    break;
//                }
//            }
//            updatedCol -= 1;
//        }
//        updatedCol = col + 1;
//        for (int i = row - 1; i > 0; i--)
//        {
//            if(updatedCol < 9)
//            {
//                ChessPosition add1 = new ChessPosition(i, updatedCol);
//                ChessPiece checker = board.getPiece(add1);
//                if (checker == null || checker.getTeamColor() != current) {
//                    ChessMove add = new ChessMove(myPosition, add1, null);
//                    moves.add(add);
//                }
//                if (checker != null) {
//                    break;
//                }
//            }
//            updatedCol += 1;
//        }
        return moves;
    }

    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }

}
//ChessPosition add1 = new ChessPosition(i, updatedCol);
//ChessMove add = new ChessMove(myPosition, add1, null);
//                moves.add(add);
package chess;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class BishopMoves implements MovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        for(int i = 1; i < 9; i++) {
            if(isValid(row + i, col + i)) {
                if (board.getPiece(new ChessPosition(row + i, col + i)) == null)
                {
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col + i), null);
                    moves.add(move);
                }
                else if (board.getPiece(new ChessPosition(row + i, col + i)).getTeamColor() != current){
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col + i), null);
                    moves.add(move);
                    break;
                }
                else{
                    break;
                }
            }
            else {
                break;
            }
        }
        for(int i = 1; i < 9; i++) {
            if(isValid(row + i, col - i)) {
                if (board.getPiece(new ChessPosition(row + i, col - i)) == null)
                {
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col - i), null);
                    moves.add(move);
                }
                else if (board.getPiece(new ChessPosition(row + i, col - i)).getTeamColor() != current){
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col - i), null);
                    moves.add(move);
                    break;
                }
                else{
                    break;
                }
            }
            else {
                break;
            }
        }
        for(int i = 1; i < 9; i++) {
            if(isValid(row - i, col + i)) {
                if (board.getPiece(new ChessPosition(row - i, col + i)) == null)
                {
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col + i), null);
                    moves.add(move);
                }
                else if (board.getPiece(new ChessPosition(row - i, col + i)).getTeamColor() != current){
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col + i), null);
                    moves.add(move);
                    break;
                }
                else{
                    break;
                }
            }
            else {
                break;
            }
        }
        for(int i = 1; i < 9; i++) {
            if(isValid(row - i, col - i)) {
                if (board.getPiece(new ChessPosition(row - i, col - i)) == null)
                {
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col - i), null);
                    moves.add(move);
                }
                else if (board.getPiece(new ChessPosition(row - i, col - i)).getTeamColor() != current){
                    ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col - i), null);
                    moves.add(move);
                    break;
                }
                else{
                    break;
                }
            }
            else {
                break;
            }
        }

        return moves;
    }
    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }
}
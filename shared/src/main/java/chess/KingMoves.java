package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMoves implements MovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow() - 2;
        int col = myPosition.getColumn() - 2;
        Collection<ChessMove> moves = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            if(isValid(row + 1, col + i)){
                if(board.getPiece(new ChessPosition(row + 1, col + i)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + i), null));
                }
                else if (board.getPiece(new ChessPosition(row + 1, col + i)).getTeamColor() != current){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + i), null));
                    break;
                }
                else {
                    break;
                }
            }
            else{
                break;
            }
        }
        for(int i = 1; i < 4; i++){
            if(isValid(row + 3, col + i)){
                if(board.getPiece(new ChessPosition(row + 3, col + i)) == null){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 3, col + i), null));
                }
                else if (board.getPiece(new ChessPosition(row + 3, col + i)).getTeamColor() != current){
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 3, col + i), null));
                    break;
                }
                else {
                    break;
                }
            }
            else{
                break;
            }
        }
        if(isValid(row + 2, col + 1)) {
            if((board.getPiece(new ChessPosition(row + 2, col + 1)) == null) || board.getPiece(new ChessPosition(row + 2, col + 1)).getTeamColor() != current) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col + 1), null));
            }
        }
        if(isValid(row + 2, col + 3)) {
            if((board.getPiece(new ChessPosition(row + 2, col + 3)) == null) || board.getPiece(new ChessPosition(row + 2, col + 3)).getTeamColor() != current) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col + 3), null));
            }
        }
        return moves;
    }
    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }
}
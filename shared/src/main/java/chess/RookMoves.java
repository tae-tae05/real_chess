package chess;
import java.util.ArrayList;
import java.util.Collection;
public class RookMoves implements MovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        for(int i = 1; i < 9; i++){
            if(isValid(row + i, col) && board.getPiece(new ChessPosition(row + i, col)) == null){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col), null);
                moves.add(move);
            }
            else if(isValid(row + i, col) && board.getPiece(new ChessPosition(row + i, col)).getTeamColor() != current){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row + i, col), null);
                moves.add(move);
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1; i < 9; i++){
            if(isValid(row - i, col) && board.getPiece(new ChessPosition(row - i, col)) == null){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col), null);
                moves.add(move);
            }
            else if(isValid(row - i, col) && board.getPiece(new ChessPosition(row - i, col)).getTeamColor() != current){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row - i, col), null);
                moves.add(move);
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1; i < 9; i++){
            if(isValid(row, col + i) && board.getPiece(new ChessPosition(row, col + i)) == null){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row, col + i), null);
                moves.add(move);
            }
            else if(isValid(row, col + i) && board.getPiece(new ChessPosition(row, col + i)).getTeamColor() != current){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row, col+i), null);
                moves.add(move);
                break;
            }
            else{
                break;
            }
        }
        for(int i = 1; i < 9; i++){
            if(isValid(row, col - i) && board.getPiece(new ChessPosition(row, col - i)) == null){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row, col - i), null);
                moves.add(move);
            }
            else if(isValid(row, col - i) && board.getPiece(new ChessPosition(row, col - i)).getTeamColor() != current){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(row, col - i), null);
                moves.add(move);
                break;
            }
            else{
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
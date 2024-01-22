package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMoves implements MovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        int r = row;
        if (row != 1){
            r -= 1;
        }
        int c = col;
        if (col != 1){
            c -= 1;
        }
        for (int i = r; r < row + 2 && i < 9; i++)
        {
            for (int j = c; c < col + 2 && j < 9; j++)
            {
                ChessPosition add1 = new ChessPosition(i, j);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
            }
        }
        return moves;
    }
}

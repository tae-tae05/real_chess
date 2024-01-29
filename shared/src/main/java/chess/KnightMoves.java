package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMoves implements MovesCalculator{
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current) {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        int[][] possibilities = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };
        for (int[] possibility : possibilities)
        {
            int r = row + possibility[0];
            int c = col + possibility[1];
            if (myPosition.isValid(r, c))
            {
                ChessPosition add1 = new ChessPosition(r, c);
                ChessPiece checker = board.getPiece(add1);
                if (checker == null || checker.getTeamColor() != current) {
                    ChessMove add = new ChessMove(myPosition, add1, null);
                    moves.add(add);
                }
            }
        }
        return moves;
    }

    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }


}

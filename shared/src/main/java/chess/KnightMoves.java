package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMoves {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        int[][] possibilities = { {-2, 1}, {-2, -1}, {1,-2}, {-1, -2}, {1,2}, {-1, 2},
                {2, 1}, {2, -1}};
        for (int[] possible: possibilities)
        {
            int r = row + possible[0];
            int c = col + possible[1];
            if (isValid(r, c) && (board.getPiece(new ChessPosition(r, c)) == null || board.getPiece(new ChessPosition(r, c)).getTeamColor() != current)){
                ChessMove move = new ChessMove(myPosition, new ChessPosition(r, c), null);
                moves.add(move);
            }

        }
        return moves;
    }
    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }
}

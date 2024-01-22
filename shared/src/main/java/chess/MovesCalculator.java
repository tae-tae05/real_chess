package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

interface MovesCalculator{
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current);
}

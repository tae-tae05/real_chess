package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private ChessGame.TeamColor color;
    private PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.color = pieceColor;
        this.type = type;
    }

    public ChessPiece() {

    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return color;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return color == that.color && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }


    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();
        switch (type)
        {
            case ChessPiece.PieceType.BISHOP ->
            {
                BishopMoves bishop = new BishopMoves();
                moves = bishop.pieceMoves(board, myPosition, color);
            }
            case ChessPiece.PieceType.KING ->
            {
                KingMoves king = new KingMoves();
                moves = king.pieceMoves(board, myPosition, color);
            }
            case ChessPiece.PieceType.KNIGHT ->
            {
                KnightMoves knight = new KnightMoves();
                moves = knight.pieceMoves(board, myPosition, color);
            }
            case ChessPiece.PieceType.PAWN ->
            {
                PawnMoves pawn = new PawnMoves();
                moves = pawn.pieceMoves(board, myPosition, color);
            }
            case ChessPiece.PieceType.QUEEN ->
            {
                Queen queen = new Queen();
                moves = queen.pieceMoves(board, myPosition, color);
            }
            default ->
            {
                System.out.print("Stuck here");
            }
        }
        return moves;
    }


}



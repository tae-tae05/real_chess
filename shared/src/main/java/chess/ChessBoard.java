package chess;

import java.util.Arrays;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    private ChessPiece[][] squares = new ChessPiece[8][8];

    public ChessBoard() {
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    public void removePiece(ChessPosition position) {
        squares[position.getRow() - 1][position.getColumn() - 1] = null;
    }

    public void movePiece(ChessMove move) {
        ChessPiece current = getPiece(move.getStartPosition());
        ChessPiece.PieceType upgrade = move.getPromotionPiece();
        squares[move.getStartPosition().getRow()-1][move.getStartPosition().getColumn() - 1] = null;
        int r = move.getEndPosition().getRow();
        int c = move.getEndPosition().getColumn();
        if(upgrade == null) {
            squares[r - 1][c - 1] = current;
        }
        else{
            squares[r-1][c-1] = new ChessPiece(current.getTeamColor(), upgrade);
        }
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow() - 1][position.getColumn() - 1];
    }

    public ChessPosition findPiece(ChessPiece piece) {
        int r = 1;
        int c = 1;
        boolean found = false;
        for (ChessPiece[] row : squares) {
            c = 1;
            for (ChessPiece tempPiece : row) {
                if (piece.equals(tempPiece)) {
                    return new ChessPosition(r, c);
                }
                c += 1;
            }
            r += 1;
        }
        return null;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[8][8];
        for (int i = 1; i < 9; i++) {
            ChessPosition pos = new ChessPosition(7, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i++) {
            ChessPosition pos = new ChessPosition(2, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i += 7) {
            ChessPosition pos = new ChessPosition(8, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i += 7) {
            ChessPosition pos = new ChessPosition(1, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 8; i += 5) {
            ChessPosition pos = new ChessPosition(8, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 8; i += 5) {
            ChessPosition pos = new ChessPosition(1, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 3; i < 7; i += 3) {
            ChessPosition pos = new ChessPosition(8, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        for (int i = 3; i < 7; i += 3) {
            ChessPosition pos = new ChessPosition(1, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        ChessPosition pos = new ChessPosition(1, 4);
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(1, 5);
        piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
        pos = new ChessPosition(8, 4);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(8, 5);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
//        this.displayBoard();
//        System.out.print("\n");
//        that.displayBoard();
        return Arrays.deepEquals(squares, that.squares);
    }

    @Override
    public String toString() {
        String total = "";
        for (ChessPiece[] row : squares) {
            total = total.concat("[");
            for (ChessPiece piece : row) {

                if (piece == null) {
                    total = total.concat("null");
                } else {
                    total = total.concat(piece.toString());
                }
                total = total.concat(",");
            }
            total = total.concat("]\n");

        }
//        Arrays.deepToString(squares) +
        return "ChessBoard{" +
                "squares=" + total +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    /**
     * printing the board out
     */
    public void displayBoard() {
        for(int r = 8; r > 0; r--){
            System.out.print("[");
            for(int c = 1; c < 9; c++) {
                ChessPiece piece = getPiece(new ChessPosition(r, c));
                if (piece == null) {
                    System.out.print(" X ");
                } else {
                    if (piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
                        System.out.print(piece.toString());
                    } else {
                        System.out.print(piece.toString().toLowerCase());
                    }
                }
                System.out.print(",");
            }
            System.out.println("]\n");
            }
//
//        for (ChessPiece[] row : squares) {
//            System.out.print("[");
//            for (ChessPiece piece : row) {
//                if (piece == null) {
//                    System.out.print("null");
//                } else {
//                    if (piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
//                        System.out.print(piece.toString());
//                    } else {
//                        System.out.print(piece.toString().toLowerCase());
//                    }
//                }
//                System.out.print(",");
//            }
//            System.out.println("]\n");
//        }

    }
}


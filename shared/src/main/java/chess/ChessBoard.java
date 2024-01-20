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
    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[8][8];
        for (int i = 1; i < 9; i++)
        {
                ChessPosition pos = new ChessPosition(2, i);
                ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
                this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i++)
        {
            ChessPosition pos = new ChessPosition(7, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i += 7)
        {
            ChessPosition pos = new ChessPosition(1,i);
                ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 9; i += 7)
        {
            ChessPosition pos = new ChessPosition(8,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 8; i += 5)
        {
            ChessPosition pos = new ChessPosition(1,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 8; i += 5)
        {
            ChessPosition pos = new ChessPosition(8,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 3; i < 7; i += 3)
        {
            ChessPosition pos = new ChessPosition(1,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        for (int i = 3; i < 7; i += 3)
        {
            ChessPosition pos = new ChessPosition(8,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        ChessPosition pos = new ChessPosition(8,4);
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(8,5);
        piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
        pos = new ChessPosition(1,4);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(1,5);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
    }

    @Override
    public boolean equals(Object o) {
        ChessBoard that = (ChessBoard) o;
        if (this == o)
        {
            System.out.print("stop one");
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            System.out.print("stop two");
            return false;
        }
//        this.displayBoard();
//        System.out.print("\n");
//        that.displayBoard();
        return Arrays.deepEquals(squares, that.squares);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "squares=" + Arrays.deepToString(squares) +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    /**
     * printing the board out
     */
    public void displayBoard()
    {
        for (int i = 1; i < 9; i++)
        {
            for (int j = 1; j < 9; j++)
            {
//                System.out.print(i +"" + j + " ");
                ChessPosition position = new ChessPosition(i, j);
//                System.out.println(this.getPiece(position));
                if (this.getPiece(position) == null)
                {
                    System.out.print("| ");
                }
                else
                {
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.PAWN)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|P");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|p");

                        }
                    }
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.ROOK)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|R");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|r");

                        }
                    }
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.KNIGHT)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|N");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|n");

                        }
                    }
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.BISHOP)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|B");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|b");

                        }
                    }
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.QUEEN)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|Q");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|q");

                        }
                    }
                    if(this.getPiece(position).getPieceType() == ChessPiece.PieceType.KING)
                    {
                        ChessGame.TeamColor col = this.getPiece(position).getTeamColor();
                        switch (col)
                        {
                            case ChessGame.TeamColor.WHITE ->
                            {
                                System.out.print("|K");
                            }
                            case ChessGame.TeamColor.BLACK -> System.out.print("|k");

                        }
                    }
                }
            }
            System.out.print("|\n");
        }
    }

}

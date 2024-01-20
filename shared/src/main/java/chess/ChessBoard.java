package chess;

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
        squares[position.getRow()][position.getColumn()] = piece;
    }
    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++)
        {
                ChessPosition pos = new ChessPosition(1, i);
                ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
                this.addPiece(pos, piece);
        }
        for (int i = 0; i < 8; i++)
        {
            ChessPosition pos = new ChessPosition(6, i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            this.addPiece(pos, piece);
        }
        for (int i = 0; i < 8; i += 7)
        {
            ChessPosition pos = new ChessPosition(0,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 0; i < 8; i += 7)
        {
            ChessPosition pos = new ChessPosition(7,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 7; i += 5)
        {
            ChessPosition pos = new ChessPosition(0,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 1; i < 7; i += 5)
        {
            ChessPosition pos = new ChessPosition(7,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 6; i += 3)
        {
            ChessPosition pos = new ChessPosition(0,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        for (int i = 2; i < 6; i += 3)
        {
            ChessPosition pos = new ChessPosition(7,i);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
            this.addPiece(pos, piece);
        }
        ChessPosition pos = new ChessPosition(7,3);
        ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(7,4);
        piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
        pos = new ChessPosition(0,3);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        this.addPiece(pos, piece);
        pos = new ChessPosition(0,4);
        piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        this.addPiece(pos, piece);
    }

    /**
     * printing the board out
     */
    public void displayBoard()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
//                System.out.print(i +"" + j + " ");
                ChessPosition position = new ChessPosition(i, j);
//                System.out.println(this.getPiece(position));
                if (this.getPiece(position) == null)
                {
                    System.out.print("o ");
                }
                else
                {
                    System.out.print(this.getPiece(position).getPieceType()+ " ");
                }
            }
            System.out.print("\n");
        }
    }

}

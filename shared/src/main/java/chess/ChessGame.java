package chess;

import java.util.ArrayList;
import java.util.Collection;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {
    private TeamColor turn;
    private ChessBoard game_board = new ChessBoard();

    public ChessGame() {

    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return turn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        turn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece current_piece = game_board.getPiece(startPosition);
        if (current_piece == null) {
            return null;
        }
        return current_piece.pieceMoves(game_board, startPosition);
    }

    @Override
    public String toString() {
        return "ChessGame{" +
                "turn=" + turn +
                ", game_board=" + game_board +
                '}';
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
            Collection<ChessMove> moves = validMoves(move.getStartPosition());
            boolean moved = false;
            for(ChessMove possibleMove: moves) {
                if (possibleMove.equals(move)) {
                    ChessPiece current = game_board.getPiece(move.getStartPosition());
                    if(current != null) {
                        if (current.getTeamColor() == turn) {
                            game_board.movePiece(move);
                            moved = true;
                            if (turn == TeamColor.BLACK) {
                                setTeamTurn(TeamColor.WHITE);
                            } else {
                                setTeamTurn(TeamColor.BLACK);
                            }
                        }
                    }
                }
            }
        if(!moved) {
            System.out.println("made it here");
            throw new InvalidMoveException("Invalid Move");
        }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) { //if teamColor is white, check to see if black can eat white
        ChessPiece king = new ChessPiece(teamColor, ChessPiece.PieceType.KING);
        ChessPosition kingSpot = game_board.findPiece(king);
        boolean knights = checkKnights(teamColor, kingSpot.getRow(), kingSpot.getColumn());
        boolean diagonal = checkDiagonal(teamColor, kingSpot.getRow(), kingSpot.getColumn());
        boolean horizontal = checkHorizontal(teamColor, kingSpot.getRow(), kingSpot.getColumn());
        boolean vertical = checkVertical(teamColor, kingSpot.getRow(), kingSpot.getColumn());
        boolean pawns = checkPawn(teamColor, kingSpot.getRow(), kingSpot.getColumn());
        return knights || diagonal || horizontal || vertical || pawns;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        ChessPiece king = new ChessPiece(teamColor, ChessPiece.PieceType.KING);
        ChessPosition kingSpot = game_board.findPiece(king);
        boolean check = true;
        if(isInCheck(teamColor)){
            for(int r = kingSpot.getRow() - 1; r < kingSpot.getRow() + 2; r ++){
                for (int c = kingSpot.getColumn()-1; c < kingSpot.getColumn() + 2; c++){
                    if(isValid(r, c)){
                        boolean knights = checkKnights(teamColor, r, c);
                        boolean diagonal = checkDiagonal(teamColor, r, c);
                        boolean horizontal = checkHorizontal(teamColor, r, c);
                        boolean vertical = checkVertical(teamColor, r, c);
                        boolean pawns = checkPawn(teamColor, r, c);
                        check = knights || diagonal || horizontal || vertical || pawns; //checking if anything can eat
                    }
                    if(!check){ //if nothing can eat it, return false cuz it can escape
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public boolean checkKing(TeamColor color, int row, int col){
        for(int r = row-1; r < row+2; r++){
            for(int c = col-1; c < col+2; c++){
                return true;
            }
        }
        return false;
    }
    public boolean checkPawn(TeamColor color, int row, int col){
        if (color == TeamColor.BLACK) { //- since white can only move up
            if(isValid(row-1, col-1)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row - 1, col - 1));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.PAWN)) {
                    if (current.getTeamColor() != color) {
                        return true;
                    }
                }
            }
            if(isValid(row -1, col + 1)){
                ChessPiece current = game_board.getPiece(new ChessPosition(row - 1, col + 1));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.PAWN)) {
                    if (current.getTeamColor() != color) {
                        return true;
                    }
                }
            }
        }
        else {
            if(isValid(row+1, col-1)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row+1, col - 1));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.PAWN)) {
                    return current.getTeamColor() != color;
                }
            }
            if(isValid(row+1, col + 1)){
                ChessPiece current = game_board.getPiece(new ChessPosition(row+1, col + 1));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.PAWN)) {
                    return current.getTeamColor() != color;
                }
            }
        }
        return false;
    }
    public boolean checkKnights(TeamColor color, int row, int col){
        int[][] possibilities = { {-2, 1}, {-2, -1}, {1,-2}, {-1, -2}, {1,2}, {-1, 2},
                {2, 1}, {2, -1}};
        for (int[] possible: possibilities) {
            int r = row + possible[0];
            int c = col + possible[1];
            if(isValid(r, c)){
                ChessPiece current = game_board.getPiece(new ChessPosition(r, c));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.KNIGHT)) {
                    if(current.getTeamColor() != color){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkDiagonal(TeamColor color, int row, int col){
        for(int i = 1; i < 9; i++) {
            if (isValid(row + i, col + i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row + i, col + i));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)) {
                    if(current.getTeamColor() != color){
                        return true;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row + i, col - i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row + i, col - i));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)) {
                    if(current.getTeamColor() != color){
                        return true;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row - i, col + i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row - i, col + i));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)) {
                    if(current.getTeamColor() != color){
                        return true;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row - i, col - i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row - i, col - i));
                if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)) {
                    if(current.getTeamColor() != color){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkHorizontal(TeamColor color, int row, int col) {
        for(int i = 1; i < col; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(row, i));
            if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)) {
                return current.getTeamColor() != color;
            }
        }
        for(int i = col; i < 9; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(row, i));
            if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)) {
                return current.getTeamColor() != color;
            }
        }
        return false;
    }
    public boolean checkVertical(TeamColor color, int row, int col) {
        for(int i = 1; i < row; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(i, col));
            if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)) {
                if(current.getTeamColor() != color){
                    return true;
                }
            }
        }
        for(int i = row; i < 9; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(i, col));
            if (current != null && (current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)) {
                if (current.getTeamColor() != color) {
                    return true;
                }
            }
            }

        return false;
    }

    public boolean isValid(int row, int col){
        return row < 9 && row > 0 && col < 9 && col > 0;
    }


    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        game_board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return game_board;
    }
}

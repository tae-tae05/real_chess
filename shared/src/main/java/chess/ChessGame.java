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
    private TeamColor turn = TeamColor.WHITE;
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
//        game_board.displayBoard();
        ChessPiece current_piece = game_board.getPiece(startPosition);
//        Collection<ChessMove> potential_moves = current_piece.pieceMoves(game_board, startPosition);
        Collection<ChessMove> potential_moves = new ArrayList<>();
        potential_moves.add(new ChessMove(startPosition, new ChessPosition(5, 4), null));
        Collection<ChessMove> final_moves = new ArrayList<>();
        if(current_piece == null){
            return final_moves;
        }
        ChessBoard temp_board = game_board;
        System.out.println("potential = " + potential_moves);
        if (isInCheckmate(current_piece.getTeamColor())) { //if checkmate, return empty final_moves
            return final_moves;
        }
        else if (isInCheck(current_piece.getTeamColor())) {
            for (ChessMove move : potential_moves) {
                game_board.movePiece(move);
                System.out.println("move is " + move);
                System.out.println(isInCheck(current_piece.getTeamColor()));
                game_board.displayBoard();
                if(!isInCheck(current_piece.getTeamColor())){
                    final_moves.add(move);
                }
                game_board = temp_board;
            }
            return final_moves;
        }
        else {
            return potential_moves;
        }
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
        if(kingSpot != null) {
            boolean knights = checkKnights(teamColor, kingSpot.getRow(), kingSpot.getColumn());
            boolean diagonal = checkDiagonal(teamColor, kingSpot.getRow(), kingSpot.getColumn());
            boolean horizontal = checkHorizontal(teamColor, kingSpot.getRow(), kingSpot.getColumn());
            boolean vertical = checkVertical(teamColor, kingSpot.getRow(), kingSpot.getColumn());
            boolean pawns = checkPawn(teamColor, kingSpot.getRow(), kingSpot.getColumn());
            return knights || diagonal || horizontal || vertical || pawns;
        }
        else
        {
            return false;
        }
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
        boolean check = false;
        if(kingSpot != null) {
            if (isInCheck(teamColor)) {
                for (int r = kingSpot.getRow() - 1; r < kingSpot.getRow() + 2; r++) {
                    for (int c = kingSpot.getColumn() - 1; c < kingSpot.getColumn() + 2; c++) {
                        if (isValid(r, c)) {
                            boolean knights = checkKnights(teamColor, r, c);
                            boolean diagonal = checkDiagonal(teamColor, r, c);
                            boolean horizontal = checkHorizontal(teamColor, r, c);
                            boolean vertical = checkVertical(teamColor, r, c);
                            boolean pawns = checkPawn(teamColor, r, c);
                            boolean kingCheck = checkKing(teamColor, r, c);
                            check = knights || diagonal || horizontal || vertical || pawns || kingCheck; //checking if anything can eat
//                        System.out.println("spots");
//                        System.out.println("knights = " + knights);
//                        System.out.println("diagonal = " + diagonal);
//                        System.out.println("horizontal = " + horizontal);
//                        System.out.println("vertical = " + vertical);
//                        System.out.println("pawns = " + pawns);
//                        System.out.println("king = " + kingCheck);
                        }

                    }
                }
            }
        }
        return check;
    }

    public boolean checkKing(TeamColor color, int row, int col){
        for(int r = row-1; r < row+2; r++){
            for(int c = col-1; c < col+2; c++){
                if(isValid(r, c)) {
                    ChessPiece current = game_board.getPiece(new ChessPosition(r, c));
                    if (current != null && (current.getPieceType() == ChessPiece.PieceType.KING && current.getTeamColor() != color)) {
                        return true;
                    }
                }
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
                if (current != null) {
                    if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)
                    {
                        return current.getTeamColor() != color;
                    }
                    else if(current.getTeamColor() == color){
                        return false;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row + i, col - i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row + i, col - i));
                if (current != null) {
                    if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)
                    {
                        return current.getTeamColor() != color;
                    }
                    else if(current.getTeamColor() == color){
                        return false;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row - i, col + i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row - i, col + i));
                if (current != null) {
                    if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)
                    {
                        return current.getTeamColor() != color;
                    }
                    else if(current.getTeamColor() == color){
                        return false;
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if (isValid(row - i, col - i)) {
                ChessPiece current = game_board.getPiece(new ChessPosition(row - i, col - i));
                if (current != null) {
                    if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.BISHOP)
                    {
                        return current.getTeamColor() != color;
                    }
                    else if(current.getTeamColor() == color){
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkHorizontal(TeamColor color, int row, int col) {
        for(int i = col - 1; i > 0; i--) {
            ChessPiece current = game_board.getPiece(new ChessPosition(row, i));
            if (current != null) {
                if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)
                {
                    return current.getTeamColor() != color;
                }
                else if(current.getTeamColor() == color){
                    return false;
                }
            }
        }
        for(int i = col + 1; i < 9; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(row, i));
            if (current != null) {
                if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)
                {
                    return current.getTeamColor() != color;
                }
                else if(current.getTeamColor() == color){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean checkVertical(TeamColor color, int row, int col) {
        for(int i = row - 1; i >0; i--) {
            ChessPiece current = game_board.getPiece(new ChessPosition(i, col));
            if (current != null) {
                if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)
                {
                    return current.getTeamColor() != color;
                }
                else if(current.getTeamColor() == color){
                    return false;
                }
            }
        }
        for(int i = row + 1; i < 9; i++) {
            ChessPiece current = game_board.getPiece(new ChessPosition(i, col));
            if (current != null) {
                if(current.getPieceType() == ChessPiece.PieceType.QUEEN || current.getPieceType() == ChessPiece.PieceType.ROOK)
                {
                    return current.getTeamColor() != color;
                }
                else if(current.getTeamColor() == color){
                    return false;
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

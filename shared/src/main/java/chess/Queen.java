package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Queen implements MovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current) {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        Collection<ChessMove> moves = new ArrayList<>();

        for (int r = row + 1; r < 9; r++) {
            ChessPosition checking = new ChessPosition(r, col);
            ChessPiece spot = board.getPiece(checking);
            if (spot == null) {
                ChessMove move = new ChessMove(myPosition, checking, null);
                moves.add(move);
            } else {
                if (spot.getTeamColor() != current) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                break;
            }
        }
        for (int r = row - 1; r > 0; r--) {
            ChessPosition checking = new ChessPosition(r, col);
            ChessPiece spot = board.getPiece(checking);
            if (spot == null) {
                ChessMove move = new ChessMove(myPosition, checking, null);
                moves.add(move);
            } else {
                if (spot.getTeamColor() != current) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                break;
            }
        }
        for (int c = col + 1; c < 9; c++) {
            ChessPosition checking = new ChessPosition(row, c);
            ChessPiece spot = board.getPiece(checking);
            if (spot == null) {
                ChessMove move = new ChessMove(myPosition, checking, null);
                moves.add(move);
            } else {
                if (spot.getTeamColor() != current) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                break;
            }
        }
        for (int c = col - 1; c > 0; c--) {
            ChessPosition checking = new ChessPosition(row, c);
            ChessPiece spot = board.getPiece(checking);
            if (spot == null) {
                ChessMove move = new ChessMove(myPosition, checking, null);
                moves.add(move);
            }
            else {
                if (spot.getTeamColor() != current) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                break;
            }
        }
        //diagonal
        int c = col;
        for (int r = row + 1; r < 9; r++) {
            c += 1;
            if (c < 9)
            {
                ChessPosition checking = new ChessPosition(r, c);
                ChessPiece spot = board.getPiece(checking);
                if (spot == null) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                } else {
                    if (spot.getTeamColor() != current) {
                        ChessMove move = new ChessMove(myPosition, checking, null);
                        moves.add(move);
                    }
                    break;
                }
            }
        }
        c = col;
        for (int r = row - 1; r > 0; r--) {
            c += 1;
            if (c < 9)
            {
                ChessPosition checking = new ChessPosition(r, c);
                ChessPiece spot = board.getPiece(checking);
                if (spot == null) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                } else {
                    if (spot.getTeamColor() != current) {
                        ChessMove move = new ChessMove(myPosition, checking, null);
                        moves.add(move);
                    }
                    break;
                }
            }
        }
        c = col;
        for (int r = row + 1; r < 9; r++) {
            c -= 1;
            if (c > 0)
            {
                ChessPosition checking = new ChessPosition(r, c);
                ChessPiece spot = board.getPiece(checking);
                if (spot == null) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                else {
                    if (spot.getTeamColor() != current) {
                        ChessMove move = new ChessMove(myPosition, checking, null);
                        moves.add(move);
                    }
                    break;
                }
            }
        }
        c = col;
        for (int r = row - 1; r > 0; r--) {
            c -= 1;
            if (c > 0)
            {
                ChessPosition checking = new ChessPosition(r, c);
                ChessPiece spot = board.getPiece(checking);
                if (spot == null) {
                    ChessMove move = new ChessMove(myPosition, checking, null);
                    moves.add(move);
                }
                else {
                    if (spot.getTeamColor() != current) {
                        ChessMove move = new ChessMove(myPosition, checking, null);
                        moves.add(move);
                    }
                    break;
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



package chess;
import java.util.ArrayList;
import java.util.Collection;
public class PawnMoves {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor current)
    {
        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;
        ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;
        Collection<ChessMove> moves = new ArrayList<>();
        if(row == 2 && current == white){ //first move
            if(board.getPiece(new ChessPosition(row+1, col)) == null) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), null));
                if(board.getPiece(new ChessPosition(row+2, col)) == null) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col), null));
                }
            }

        }
        else if(row == 2 && current == black){ //promotion
            for(int i = col - 1; i < col + 2; i+=2) {
                if (isValid(row - 1, i)) {
                    if (board.getPiece(new ChessPosition(row - 1, i)) != null && board.getPiece(new ChessPosition(row - 1, i)).getTeamColor() != current) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, i), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, i), ChessPiece.PieceType.KNIGHT));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, i), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, i), ChessPiece.PieceType.QUEEN));
                    }
                }
            }
            if(isValid(row - 1, col)) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), ChessPiece.PieceType.BISHOP));
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), ChessPiece.PieceType.KNIGHT));
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), ChessPiece.PieceType.ROOK));
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), ChessPiece.PieceType.QUEEN));
            }
        }
        else if(current == white){
            for(int i = col - 1; i < col + 2; i += 2) {
                if(isValid(row + 1, i)) {
                    if(board.getPiece(new ChessPosition(row + 1, i)) != null && board.getPiece(new ChessPosition(row + 1, i)).getTeamColor() != current) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, i), null));
                    }
                }
            }
            if(isValid(row + 1, col) && board.getPiece(new ChessPosition(row + 1, col)) == null && row != 7){
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), null));
            }
        }
        if (row == 7 && current == black) //first move
        {
            if(board.getPiece(new ChessPosition(row-1, col)) == null) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), null));
                if(board.getPiece(new ChessPosition(row-2, col)) == null) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col), null));
                }
            }
        }
        else if(row == 7 && current == white){ //promotion move
            for(int i = col - 1; i < col + 2; i += 2) {
                if(isValid(row + 1, i)) {
                    if (board.getPiece(new ChessPosition(row + 1, i)) != null && board.getPiece(new ChessPosition(row + 1, i)).getTeamColor() != current) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, i), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, i), ChessPiece.PieceType.KNIGHT));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, i), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, i), ChessPiece.PieceType.QUEEN));
                    }
                }
            }
            if(isValid(row + 1, col)) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), ChessPiece.PieceType.BISHOP));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), ChessPiece.PieceType.KNIGHT));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), ChessPiece.PieceType.ROOK));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), ChessPiece.PieceType.QUEEN));
            }
        }
        else if(current == black){
            for(int i = col - 1; i < col + 2; i += 2) {
                if(isValid(row - 1, i)) {
                    if(board.getPiece(new ChessPosition(row - 1, i)) != null && board.getPiece(new ChessPosition(row - 1, i)).getTeamColor() != current && row != 2) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, i), null));
                    }
                }
            }
            if(isValid(row - 1, col) && board.getPiece(new ChessPosition(row - 1, col)) == null && row != 2){
                moves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col), null));
            }
        }
        return moves;
    }
    public Boolean isValid(int row, int col)
    {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }
}
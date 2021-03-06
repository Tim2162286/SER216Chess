package Game.Pieces;

import java.awt.*;
import java.util.LinkedList;

public class King extends Piece {

    public King(Point start, boolean isWhite) {
        super(start, isWhite, 5);
    }

    @Override
    public LinkedList<Point> getMoves() {
        LinkedList<Point> moves = new LinkedList<>();

        for(int xOffset = -1; xOffset <= 1; xOffset++) {
            for(int yOffset = -1; yOffset <= 1; yOffset++) {
                if(xOffset != 0 || yOffset != 0) {
                    Point currentMove = new Point(this.position.x + xOffset, this.position.y + yOffset);
                    Piece pieceAtMove = board.getPieceAt(currentMove);

                    if((pieceAtMove == null || pieceAtMove.isWhite() != this.isWhite) &&
                            currentMove.x < 8 && currentMove.x >= 0 &&
                            currentMove.y < 8 && currentMove.y >= 0) {
                        moves.add(currentMove);
                    }
                }
            }
        }
        return moves;
    }

    @Override
    public Piece clone() {
        return new King(new Point(this.getPosition()), this.isWhite);
    }
}
package ru.mart.xo.model;

import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;

public class Field {

    private final Figure[][] field;
    private final int fieldSize;
    private static final int MIN_COORDINATE = 0;
    private final int sizeX;
    private final int sizeY;

     public Field (final int sizeX, final int sizeY) {
         this.sizeX = sizeX;
         this.sizeY = sizeY;
         this.fieldSize = sizeX;
         field = new Figure[sizeX][sizeY];

     }
    public int getSize() {
        return fieldSize;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Figure getFigure (final Point point) throws InvalidPointException {
        if (isCheckPointer(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure( final Point point, final Figure figure) throws InvalidPointException {
        if (isCheckPointer(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean isCheckPointer(final Point point) {
        return !(isCheckCoordinate(point.x, field.length) && isCheckCoordinate(point.y, field[point.x].length));
    }

    private boolean isCheckCoordinate(final int coordinate, int maxCoordinate) {
        return (coordinate >= MIN_COORDINATE && coordinate < maxCoordinate);
    }


}


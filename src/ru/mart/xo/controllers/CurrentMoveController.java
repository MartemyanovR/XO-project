package ru.mart.xo.controllers;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import java.awt.Point;
import ru.mart.xo.model.exception.InvalidPointException;

public class CurrentMoveController  {
    private static int countFigure = 0;
    public Figure currentMove(final Field field) throws InvalidPointException {
         for(int i = 0; i < field.getSize(); i++) {
            for(int j = 0; j < field.getSize(); j++) {
                if(field.getFigure(new Point(i,j)) != null) {
                countFigure++;
                }
            }
        }
         return (countFigure % 2 == 0) ? Figure.X : Figure.O;
    }
}

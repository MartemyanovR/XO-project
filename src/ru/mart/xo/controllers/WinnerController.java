package ru.mart.xo.controllers;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public static final int MIN_VAL = 0;
    public Figure getWinner(Field field) {
        try {
            for (int i = MIN_VAL; i < field.getSize(); i++) {
                if (check(field, new Point(i, MIN_VAL), p -> new Point(p.x,p.y+1))) //лямбда выражение
                    return field.getFigure(new Point(i, MIN_VAL));
            }
            for (int i = MIN_VAL; i < field.getSize(); i++) {
                if (check(field, new Point(MIN_VAL, i), new IPointGenerator() {  //анонимный класс
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x+1, p.y);
                    }
                }))
                    return field.getFigure(new Point(MIN_VAL, i));
            }
            if (check(field, new Point(MIN_VAL, MIN_VAL), new IPointGenerator() { //анонимный класс
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x +1, p.y + 1);
                    }
                }))
                    return field.getFigure(new Point(0, 0));
            if (check(field, new Point(MIN_VAL, field.getSize()-1),
                    p -> new Point (p.x+1, p.y-1)))     //лямбда
                return field.getFigure(new Point(MIN_VAL, field.getSize()-1));
        }
        catch (InvalidPointException e) {
                e.printStackTrace();
            }
        return null;
    }

    private boolean check(Field field, Point currentPoint, IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }
        if (currentFigure == null)
            return false;
        if (currentFigure != nextFigure)
            return false;
        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next (Point p);
    }
}

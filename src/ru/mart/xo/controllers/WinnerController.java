package ru.mart.xo.controllers;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x,p.y+1))) //лямбда выражение
                    return field.getFigure(new Point(i, 0));
            }
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), new IPointerChecked() {  //анонимный класс
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x+1, p.y);
                    }
                }))
                    return field.getFigure(new Point(0, i));
            }
            if (check(field, new Point(0, 0), new IPointerChecked() { //анонимный класс
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x +1, p.y + 1);
                    }
                }))
                    return field.getFigure(new Point(0, 0));
            if (check(field, new Point(0, field.getSize()-1),
                    p -> new Point (p.x+1, p.y-1)))     //лямбда
                return field.getFigure(new Point(0, 0));
        }
        catch (InvalidPointException e) {
                e.printStackTrace();
            }
        return null;
    }

    private boolean check(Field field, Point startPoint, IPointerChecked pointerChecked){
       // Point p1 = startPoint;  //local variable is redundant
        Point p2 = pointerChecked.next(startPoint);
        Point p3 = pointerChecked.next(p2);
        try {
            if (field.getFigure(startPoint) == field.getFigure(p2) &&
                    field.getFigure(startPoint) == field.getFigure(p3))
                return true;
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private interface IPointerChecked {
        Point next (Point p);
    }
}

package ru.mart.xo.controllers;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.exception.AlreadyOccupiedException;
import ru.mart.xo.model.exception.InvalidPointException;


import java.awt.*;

public class  MoveController {
        public void applyFigure (final Field field,
                                 final Point point,
                                 final Figure figure) throws InvalidPointException, AlreadyOccupiedException{
            if (field.getFigure(point)!= null){
                throw new AlreadyOccupiedException();
            }

            field.setFigure(point, figure);
        }
}

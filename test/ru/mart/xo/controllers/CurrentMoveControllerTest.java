package ru.mart.xo.controllers;

import org.junit.Test;
import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMove() throws InvalidPointException {
        Field field = new Field(3,3);
        CurrentMoveController cmc = new CurrentMoveController();
        Random random = new Random();
        final Figure expectedFigure;
        final int quantityFigure = random.nextInt(field.getSizeX() * field.getSizeY());
        if (quantityFigure % 2 == 0) {
            expectedFigure = Figure.X;
        }
        else {
            expectedFigure = Figure.O;
        }
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for(int j = 0; j < field.getSize(); j++) {
                if(count < quantityFigure) {
                    field.setFigure(new Point(i, j), ((i + j) % 2 == 0) ? Figure.X : Figure.O);
                    count++;
                }
                else {
                    break;
                }
            }
        }
        assertEquals(expectedFigure, cmc.currentMove(field));
    }
}
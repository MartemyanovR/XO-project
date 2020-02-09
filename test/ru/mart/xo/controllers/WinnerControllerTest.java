package ru.mart.xo.controllers;

import org.junit.Test;
import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;

import java.awt.Point;

import static org.junit.Assert.*;

public class WinnerControllerTest {

      @Test
    public void getWinnerWhenWinnerRow() throws Exception{
        Field field = new Field(3,3);
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < field.getSize(); i++){
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winControl.getWinner(field));
        }
    }

    @Test
    public void getWinnerNoWhenWinnerRow() throws Exception{
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < 3; i++) {
            Field field = new Field(3,3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winControl.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerColumn() throws Exception{
        Field field = new Field(3,3);
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < field.getSize(); i++){
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winControl.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerColumnO() throws Exception{
        Field field = new Field(3,3);
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < field.getSize(); i++){
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.O);
            assertEquals(Figure.O, winControl.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn() throws Exception{
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < 3; i++) {
            Field field = new Field(3,3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winControl.getWinner(field));
        }
    }
    @Test
    public void getWinnerWhenNoWinnerColumnOXXOption() throws Exception{
        WinnerController winControl = new WinnerController();
        for(int i = 0; i < 3; i++) {
            Field field = new Field(3,3);
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertNull(winControl.getWinner(field));
        }
    }
    @Test
    public void getWinnerWhenWinnerDiagonal() throws Exception{
        WinnerController winControl = new WinnerController();
        Field field = new Field(3,3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winControl.getWinner(field));
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2() throws Exception{
        WinnerController winControl = new WinnerController();
        Field field = new Field(3,3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winControl.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal() throws Exception{
        WinnerController winControl = new WinnerController();
            Field field = new Field(3,3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);
            assertNull(winControl.getWinner(field));
        }

}
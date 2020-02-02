package ru.mart.xo.model;

import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import ru.mart.xo.model.exception.AlreadyOccupiedException;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(3,3);
        final int expected = 3;

        assertEquals (expected, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessZero() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessZero() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }
    @Test
    public void testGetFigureWhenXMoreThenSize() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(field.getSize() +1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }
    @Test
    public void testGetFigureWhenYMoreThenSize() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }
    @Test
    public void testGetFigureWhenXAndYMoreThenSize() throws Exception{
        final Field field = new Field(3,3);
        final Point inputPoint = new Point(field.getSize() +1,field.getSize() +1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch(final InvalidPointException e) {}
    }

}
package ru.mart.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputValue = "Roman";
        final String expectedValue = "Roman";

        final Player player = new Player(inputValue, null) ;

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
        }

    @Test
    public void getNameNotNull() {
        final String inputValue = "Roman";
        final String expectedValue = "Roman";

        final Player player = new Player(inputValue, null) ;

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() {
        final Figure expectedValue = Figure.X;

        final Player player = new Player(null, expectedValue) ;

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }


}
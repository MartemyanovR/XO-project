package ru.mart.xo.view;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.Game;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;

public class ConsoleViewUI {
    public void view(final Game game)  {
        final Field field = game.getField();
        for(int i=0; i<field.getSizeX(); i++) {
            if(i != 0) System.out.println("~~~~~~~~~");
            ui(field, i);
            System.out.print("\n");
        }
    }
    private void ui(final Field field, final int i) {
        for(int j=0; j<field.getSizeY(); j++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(i, j));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            System.out.print(figure != null ? figure : " ");
            if(j !=field.getSizeY()-1) {
                System.out.print(" | ");
            }
        }
    }

}

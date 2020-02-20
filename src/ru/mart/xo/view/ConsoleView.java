package ru.mart.xo.view;

import ru.mart.xo.controllers.CurrentMoveController;
import ru.mart.xo.controllers.MoveController;
import ru.mart.xo.controllers.WinnerController;
import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.Game;
import ru.mart.xo.model.exception.AlreadyOccupiedException;
import ru.mart.xo.model.exception.FieldIsFilledException;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {
    public Figure console(final Game game) throws AlreadyOccupiedException, InvalidPointException, FieldIsFilledException {
        final Field field = game.getField();
        final Figure figure;
        ConsoleViewMove consoleViewMove = new ConsoleViewMove();
        ConsoleViewUI consoleViewUI = new ConsoleViewUI();
        WinnerController winnerController = new WinnerController();
        consoleViewMove.move(field);
        consoleViewUI.view(game);
        figure = winnerController.getWinner(field);
        if(figure != null) {
            System.out.format("Winner %S", figure);
            return figure;
        }
        return null;
    }
}

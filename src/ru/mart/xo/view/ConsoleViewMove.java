package ru.mart.xo.view;

import ru.mart.xo.controllers.CurrentMoveController;
import ru.mart.xo.controllers.MoveController;
import ru.mart.xo.controllers.WinnerController;
import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.exception.AlreadyOccupiedException;
import ru.mart.xo.model.exception.FieldIsFilledException;
import ru.mart.xo.model.exception.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleViewMove {
    public boolean move(Field field) throws InvalidPointException, AlreadyOccupiedException, FieldIsFilledException {
        CurrentMoveController cmc = new CurrentMoveController();
        MoveController mc = new MoveController();
        Figure figure =  cmc.currentMove(field);
        if (figure == null){
            return false;
        }
        System.out.format("Move figure %s", figure + "\n" );
        System.out.println("Enter coordinate: ");
        Point point = new Point(scan() - 1, scan() - 1);
        mc.applyFigure(field,point,figure);
        return true;
    }
    private int scan() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

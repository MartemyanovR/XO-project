package ru.mart.xo;

import ru.mart.xo.model.Field;
import ru.mart.xo.model.Figure;
import ru.mart.xo.model.Game;
import ru.mart.xo.model.Player;
import ru.mart.xo.model.exception.FieldIsFilledException;
import ru.mart.xo.model.exception.AlreadyOccupiedException;
import ru.mart.xo.model.exception.InvalidPointException;
import ru.mart.xo.view.ConsoleView;

import java.util.InputMismatchException;

public class MainXO {
    public static void main(String[] args) {
        final String name1 = "Olya";
        final String name2 = "Roma";
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        Game game = new Game(players, "XO", new Field(5,5));
        System.out.format("Game name %s" , game.getName() + "\n");
        Figure figure = null;
        ConsoleView consoleView = new ConsoleView();
        while(figure == null)
        try {
            figure = consoleView.console(game);
        }
        catch(InvalidPointException e) {
            System.out.println("Invalid point");
        }
        catch(AlreadyOccupiedException e) {
            System.out.println("Already occupied");
        }
        catch(InputMismatchException e) {
            System.out.println("Please inter the number");
        }
        catch(FieldIsFilledException e) {
            System.out.println("Not Winner! You played are draw.");
            return;
        }
        }

}

package ru.mart.xo.model;

public class Game {

    private final Player[] players;
    private final String name;
    private final Field field;

    public Game(final Player[] players,
                final String name,
                final Field field) {
        this.players = players;
        this.name = name;
        this.field = field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public Field getField() {
        return field;
    }
}

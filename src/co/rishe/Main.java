package co.rishe;

import co.rishe.bowling.Game;

import javax.management.InvalidAttributeValueException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.attempt(5);
            game.attempt(5);
            game.attempt(1);
            game.attempt(1);


            System.out.println(game.getScore());
        } catch (InvalidAttributeValueException e) {
            System.out.println("Wrong input");
        }
    }
}

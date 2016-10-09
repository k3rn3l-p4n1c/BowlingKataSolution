package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bardia on 10/4/16.
 */
class Frame {
    private List<Roll> rolls;

    public Frame() {
        rolls = new LinkedList<>();
    }

    void attempt(Roll roll) throws InvalidAttributeValueException {
        if(roll.getSpins() > GameStatic.SPINS)
            throw new InvalidAttributeValueException("Invalid number for falling_spins can be more than number of all SPINS");

        if(rolls.size() < GameStatic.ROLLS)
            rolls.add(roll);
        else
            throw new InvalidAttributeValueException("You can have two attempts");
    }

    public boolean isStrike() {
        return rolls.size() >= 1 && rolls.get(0).getSpins() == 10;
    }

    public boolean isSpare() {
        return !isStrike() && getSumSpin() == 10;
    }

    public boolean isDone() {
        return rolls.size() == GameStatic.ROLLS;
    }

    public int getSumSpin() {
        int sum = 0;
        for(Roll roll: rolls)
            sum += roll.getSpins();
        return sum;
    }

    public int getScore() {
        if(this.isStrike()) {
            return getSumSpin() + rolls.get(0).getNext().getSpins() + rolls.get(0).getNext().getNext().getSpins();
        } else if(this.isSpare()) {
            return getSumSpin() + rolls.get(rolls.size()-1).getNext().getSpins();
        }
        return getSumSpin();
    }

}

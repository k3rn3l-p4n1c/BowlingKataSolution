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
        if (rolls.size() > GameStatic.FRAME_ROLLS_COUNT)
            throw new InvalidAttributeValueException("You can have two attempts");

        rolls.add(roll);
    }

    public boolean isStrike() {
        return rolls.size() >= 1 && rolls.get(0).getSpins() == GameStatic.MAX_PINS_COUNT;
    }

    public boolean isSpare() {
        return !isStrike() && getSumSpin() == GameStatic.MAX_PINS_COUNT;
    }

    public boolean isDone() {
        return rolls.size() == GameStatic.FRAME_ROLLS_COUNT;
    }

    public int getSumSpin() {
        int sum = 0;
        for(Roll roll: rolls)
            sum += roll.getSpins();
        return sum;
    }

    public int getScore() {
        if(this.isStrike()) {
            return getSumSpin()
                    + oneRollAfter().getSpins()
                    + twoRollAfter().getSpins();
        } else if(this.isSpare()) {
            return getSumSpin()
                    + oneRollAfter().getSpins();
        } else {
            return getSumSpin();
        }
    }

    private Roll oneRollAfter() {
        return rolls.get(rolls.size()-1).getNext();
    }

    private Roll twoRollAfter() {
        return rolls.get(rolls.size()-1).getNext().getNext();
    }

}

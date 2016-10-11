package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bardia on 10/4/16.
 */
class Frame {
    private LinkedList<Roll> rolls;

    public Frame() {
        rolls = new LinkedList<>();
    }

    void attempt(Roll roll) throws InvalidAttributeValueException {
        if (rolls.size() > GameStatic.FRAME_ROLLS_COUNT)
            throw new InvalidAttributeValueException(ErrorMessages.MAX_ROLL_COUNT);

        rolls.add(roll);
    }

    public boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0).getPins() == GameStatic.MAX_PINS_COUNT;
    }

    public boolean isSpare() {
        return !isStrike() && getSumPin() == GameStatic.MAX_PINS_COUNT;
    }

    public boolean isDone() {
        return rolls.size() == GameStatic.FRAME_ROLLS_COUNT;
    }

    public int getSumPin() {
        int sum = 0;
        for(Roll roll: rolls)
            sum += roll.getPins();
        return sum;
    }

    public int getScore() {
        if(this.isStrike()) {
            return getSumPin()
                    + oneRollAfter().getPins()
                    + twoRollAfter().getPins();
        } else if(this.isSpare()) {
            return getSumPin()
                    + oneRollAfter().getPins();
        } else {
            return getSumPin();
        }
    }

    private Roll oneRollAfter() {
        return rolls.get(rolls.size()-1).getNext();
    }

    private Roll twoRollAfter() {
        return rolls.get(rolls.size()-1).getNext().getNext();
    }

}

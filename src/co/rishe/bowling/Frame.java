package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;

/**
 * Created by Bardia on 10/4/16.
 */
class Frame {
    private Roll roll1, roll2;

    void attempt(Roll roll) throws InvalidAttributeValueException {
        if(roll.getSpins() > GameStatic.SPINS)
            throw new InvalidAttributeValueException("Invalid number for falling_spins can be more than number of all SPINS");

        if(roll1 == null)
            roll1 = roll;
        else if(roll2 == null)
            roll2 = roll;
        else
            throw new InvalidAttributeValueException("You can have two attempts");
    }

    public boolean isStrike() {
        return roll1 != null && roll1.getSpins() == 10;
    }

    public boolean isSpare() {
        return !isStrike() && getSumSpin() == 10;
    }

    public boolean isDone() {
        return (roll1 != null && roll2 != null)
                || (roll1.getSpins() == 10 && roll2 == null);
    }

    public int getSumSpin() {
        if(roll1 == null)
            return 0;
        else if (roll2 == null)
            return roll1.getSpins();
        return roll1.getSpins() + roll2.getSpins();
    }

    public int getScore() {
        if(this.isStrike()) {
            return getSumSpin() + roll1.getNext().getSpins() + roll1.getNext().getNext().getSpins();
        } else if(this.isSpare()) {
            return getSumSpin() + roll2.getNext().getSpins();
        }
        return getSumSpin();
    }

    public int getRoll1() {
        return roll1.getSpins();
    }

    public int getRoll2() {
        return roll2.getSpins();
    }
}

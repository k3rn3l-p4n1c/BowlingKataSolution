package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;

/**
 * Created by Bardia on 10/4/16.
 */
class Frame {
    private Integer roll1, roll2;

    void attempt(int falling_spins) throws InvalidAttributeValueException {
        if(falling_spins > GameStatic.SPINS)
            throw new InvalidAttributeValueException("Invalid number for falling_spins can be more than number of all SPINS");

        if(roll1 == null)
            roll1 = falling_spins;
        else if(roll2 == null)
            roll2 = falling_spins;
        else
            throw new InvalidAttributeValueException("You can have two attempts");
    }

    public boolean isStrike() {
        return roll1 != null && roll1 == 10;
    }

    public boolean isSpare() {
        return !isStrike() && roll1 + roll2 == 10;
    }

    public boolean isDone() {
        return (roll1 != null && roll2 != null)
                || (roll1 == 10 && roll2 == null);
    }

    public int getScore() {
        if(roll1 == null)
            return 0;
        else if (roll2 == null)
            return roll1;
        return roll1 + roll2;
    }

    public int getRoll1() {
        return roll1;
    }

    public int getRoll2() {
        return roll2;
    }
}

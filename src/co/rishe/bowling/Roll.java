package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;

/**
 * Created by Bardia on 10/4/16.
 */
class Roll {
    private int spins;
    private Roll nextRoll;

    public Roll(int spins) throws InvalidAttributeValueException {
        if(spins > GameStatic.MAX_PINS_COUNT)
            throw new InvalidAttributeValueException("Invalid number for falling_spins can be more than number of all MAX_PINS_COUNT");

        this.spins = spins;
    }

    public void addRoll(Roll newRoll) {
        if(nextRoll == null)
            nextRoll = newRoll;
        else
            nextRoll.addRoll(newRoll);
    }

    public int getSpins() {
        return spins;
    }

    public Roll getNext() {
        return nextRoll;
    }
}

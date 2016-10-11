package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;

/**
 * Created by Bardia on 10/4/16.
 */
class Roll {
    private Integer pins;
    private Roll nextRoll;

    public Roll(Integer pins) throws InvalidAttributeValueException {
        if(pins > GameStatic.MAX_PINS_COUNT)
            throw new InvalidAttributeValueException(ErrorMessages.INVALID_PIN_COUNT);

        this.pins = pins;
    }

    public void addRoll(Roll newRoll) {
        if(nextRoll == null)
            nextRoll = newRoll;
        else
            nextRoll.addRoll(newRoll);
    }

    public int getPins() {
        return pins;
    }

    public Roll getNext() {
        return nextRoll;
    }
}

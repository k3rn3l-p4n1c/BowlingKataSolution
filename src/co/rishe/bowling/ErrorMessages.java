package co.rishe.bowling;

/**
 * Created by Bardia on 10/11/16.
 */
public class ErrorMessages {
    static final String MAX_ROLL_COUNT = "You can have "+GameStatic.FRAME_ROLLS_COUNT+" attempts";
    static final String INVALID_PIN_COUNT = "Invalid number for pins. Can not be more than number of all "+ GameStatic.MAX_PINS_COUNT;
}

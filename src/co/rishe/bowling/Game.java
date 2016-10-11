package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Bardia on 10/4/16.
 */
public class Game {
    private LinkedList<Frame> frames;
    private Iterator<Frame> frameIterator;
    private Frame currentFrame;
    private Roll roll;

    public Game() {
        frames = new LinkedList<>();

        for(int i = 0; i < GameStatic.INIT_FRAMES_COUNT; i++) {
            frames.add(new Frame());
        }

        frameIterator = frames.iterator();
        currentFrame = frameIterator.next();
    }

    public void attempt(int pins) throws InvalidAttributeValueException {
        Roll currentRoll = new Roll(pins);
        addRoll(currentRoll);
        currentFrame.attempt(currentRoll);
        nextFrameIfDone();
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.getScore();
        }

        return score;
    }

    private void addRoll(Roll newRoll) {
        if(roll == null)
            roll = newRoll;
        else
            roll.addRoll(newRoll);
    }

    private void nextFrameIfDone() {
        if(currentFrame.isDone())
            currentFrame = frameIterator.next();
    }
}

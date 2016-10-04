package co.rishe.bowling;

import javax.management.InvalidAttributeValueException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bardia on 10/4/16.
 */
public class Game {
    private LinkedList<Frame> frames;
    private Iterator<Frame> frameIterator;
    private Frame currentFrame;

    public Game() {
        frames = new LinkedList<>();

        for(int i = 0; i < GameStatic.FRAMES; i++) {
            frames.add(new Frame());
        }

        frameIterator = frames.iterator();
        currentFrame = frameIterator.next();
    }

    public void attempt(int falling_spins) throws InvalidAttributeValueException {
        currentFrame.attempt(falling_spins);

        if(currentFrame.isDone())
            currentFrame = frameIterator.next();
    }

    public int getScore() {
        int score = 0;
        for(int i = 0 ; i < frames.size() ; i ++ ) {
            Frame frame = frames.get(i);
            score += frame.getScore();
            if (frame.isStrike()) {
                if (frames.get(i + 1).isStrike()) {
                    score += frames.get(i + 1).getRoll1() + frames.get(i + 2).getRoll1();
                } else {
                    score += frames.get(i + 1).getScore();
                }
            }
        }

        return score;
    }
}

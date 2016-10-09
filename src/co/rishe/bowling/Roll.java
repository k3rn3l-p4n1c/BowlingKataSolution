package co.rishe.bowling;

/**
 * Created by Bardia on 10/4/16.
 */
class Roll {
    private int spins;
    private Roll nextRoll;

    public Roll(int spins) {
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

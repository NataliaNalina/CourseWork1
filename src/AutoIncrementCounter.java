public class AutoIncrementCounter {
    private int counter = 0;

    public synchronized int getNextId() {
        return counter++;
    }

}
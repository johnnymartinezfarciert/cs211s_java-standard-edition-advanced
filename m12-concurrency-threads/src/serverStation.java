

public class serverStation {


    private int number;
    private boolean boxFilled;

    public serverStation() {
        boxFilled = false;
    }

    public synchronized int getFoodFrom() {
        boxFilled = false;
        return number;
    }

    public synchronized void putNumberInBox(int number) {
        this.number = number;
        boxFilled = true;
    }

    public synchronized boolean isFilled() {
        return boxFilled;
    }

    public String toString() {
        return Integer.toString(number);
    }
}


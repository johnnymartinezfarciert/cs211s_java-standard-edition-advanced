import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class DiceRunnable implements Runnable {

	private int numDie;
	private int numRolls;
	private LongAdder numMatches;

	public DiceRunnable(int numDie, int numRolls, LongAdder numMatches) {
		this.numDie = numDie;
		this.numRolls = numRolls;
		this.numMatches = numMatches;
	}

	@Override
	public void run() {
		Random generator = new Random();
		int count = 1;
		int firstRoll = 0;
		boolean dieEqual = true;

		for (int i = 0; i < numRolls; i++) {
			int diceRoll = generator.nextInt(6);
			firstRoll = diceRoll;
			dieEqual = true;
			count = 1;

			while (count <= numDie && dieEqual) {
				if (diceRoll != firstRoll) {
					dieEqual = false;
				}
				diceRoll = generator.nextInt(6);
				count++;
			}
			if (dieEqual) {
				numMatches.increment();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		final int MAX_NUM_TIMES = 20;
		final int MAX_NUM_DIE = 3;
		final int NUM_THREADS = 5;
		int numTimes = 0;
		int numDie = 0;

		LongAdder counter = new LongAdder();
		Random generator = new Random();

		Thread[] diceRollThreads = new Thread[NUM_THREADS];
		for (int i = 0; i < diceRollThreads.length; i++) {

			numTimes = generator.nextInt(MAX_NUM_TIMES) + 1;
			numDie = generator.nextInt(MAX_NUM_DIE) + 1;

			System.out.println("Thread " + (i + 1) + " is throwing " + numDie + " dice/die " + numTimes + " times.");

			diceRollThreads[i] = new Thread(new DiceRunnable(numDie, numTimes, counter));
			diceRollThreads[i].start();
		}

		
		for (Thread diceRollThread : diceRollThreads) {
			diceRollThread.join();
		}

		System.out.println("\nTotal times, where all die thown in one go match = " + counter);

	}

}

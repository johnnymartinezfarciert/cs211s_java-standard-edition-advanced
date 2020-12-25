import java.util.*;

public class RandomBoxTester {
	private static final int ARRAY_SIZE = 50;

	public static void main(String[] args) {
		Integer[] numbers = new Integer[ARRAY_SIZE];
		fillArray(numbers);
		RandomBox<Integer> numberRandomBox = new RandomBox<>(numbers, false);
		System.out.println(numberRandomBox.toString());
		numberRandomBox.addEntry(numbers[numbers.length - 1]);
		numberRandomBox.addEntry(numbers[0]);
		numberRandomBox.displayEntries(20);

		// allowing duplicates
		System.out.println("\n");
		RandomBox<Integer> numberRandomBoxDups = new RandomBox<>(numbers, true);
		System.out.println(numberRandomBoxDups.toString());
		numberRandomBoxDups.addEntry(numbers[numbers.length - 1]);
		numberRandomBoxDups.addEntry(numbers[0]);
		System.out.println(numberRandomBoxDups.toString());
		numberRandomBoxDups.displayEntries(10);

		System.out.println("\n");
		System.out.println("The Winners are " + pickUniqueWinners(numberRandomBoxDups, 10));
	}

	// PICK MULTIPLE UNIQUE WINNERS
	// bounded wild card types
	public static <T> List<T> pickUniqueWinners(RandomBox<? extends T> rb, int numOfWinners) {
		List<T> winnerList = new ArrayList<>();
		try {
			for (int i = 0; i < numOfWinners; i++) {
				// true parameter indicates winners should be removed from the box
				winnerList.add(rb.drawWinner(true));
			}
			return winnerList;
		} catch (IllegalArgumentException ex) {
//			ex.printStackTrace();
			return null;
		}
	}

	public static void fillArray(Integer[] numbers) {
		Random generator = new Random();
		int maxNum = 100;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(maxNum);
		}
	}

}

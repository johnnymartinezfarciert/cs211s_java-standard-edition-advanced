import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomBox<T extends Comparable<? super T>> {

	private ArrayList<T> items = new ArrayList<T>();
	private boolean allowDuplicates;
	
	public RandomBox(boolean allowDuplicates)
	{
		this.allowDuplicates = allowDuplicates;
	}

	public RandomBox(T[] arr, boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
		items.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (items.contains(arr[i]) && !allowDuplicates) {
				System.out.println(arr[i] + " already exits at position " + items.indexOf(arr[i]));
			} else {
				items.add(arr[i]);
			}
		}
	}

	// ADD ENTRY
	public void addEntry(T item) {
		if (!allowDuplicates && items.contains(item)) {
			System.out.println(item + " already exits at position " + items.indexOf(item));
		} else {
			items.add(item);
		}
	}

	public boolean isAllowDuplicates() {
		return allowDuplicates;
	}

	public void setAllowDuplicates(boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
	}

	// DRAW WINNER
	// boolean indicates whether the winner should be removed from the box
	// or just drawn but left in the box
	public T drawWinner(boolean bool) {
		Random generator = new Random();
		int maxNum = items.size();
		int index = generator.nextInt(maxNum);
		T returnItem = items.get(index);

		if (bool) {
			items.remove(index);
		}
		return returnItem;
	}

	// TOSTRING
	@Override
	public String toString() {
		String s = "There are " + items.size() + " entries \nDuplicates are";
		if (allowDuplicates) {
			s += " allowed.";
		} else {
			s += " not allowed.";
		}
		return s;
	}

	public int size() {
		return items.size();
	}

	// DISPLAY ENTRIES METHOD
	public void displayEntries()
	{
		items.toString();
	}
	
	public void displayEntries(int displayNumber) {
		int indexOfLast = items.size();
		if (displayNumber < items.size()) {
			indexOfLast = displayNumber;
		}
		System.out.println("Displaying " + indexOfLast + " Entries");
		for (int i = 0; i < indexOfLast; i++) {
			System.out.println(items.get(i));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RandomBox<?>) {
			RandomBox<?> otherRandomBox = (RandomBox<?>) obj;
			return items.equals(otherRandomBox.items);
		} else {
			return false;
		}
	}

}

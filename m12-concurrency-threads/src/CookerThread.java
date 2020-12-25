import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookerThread implements Runnable {

	private BlockingQueue<Food> queue;
	private List<Food> foodList;

	public CookerThread(BlockingQueue<Food> queue, List<Food> foodList) {
		this.queue = queue;
		this.foodList = foodList;
	}

	@Override
	public void run() {
		for (Food food : foodList) {
			try {
				System.out.println("Cook \tcooking " + food.getName() + " for " + food.getCookTime() + " seconds");
				Thread.sleep(food.getCookTime() * 1000);
				queue.put(food);
				System.out.println("Cook \tadding " + food.getName() + " to the server counter");
			} catch (InterruptedException ex) {

			}
		}
	}
}

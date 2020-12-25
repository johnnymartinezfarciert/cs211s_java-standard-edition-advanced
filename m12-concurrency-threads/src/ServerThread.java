import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ServerThread implements Runnable {

	private BlockingQueue<Food> queue;
	private List<Food> foodList;
	

	public ServerThread(BlockingQueue<Food> queue, List<Food> foodList) {
			this.queue = queue;
			this.foodList = foodList;
		}

	@Override
	public void run() {
		for (Food food : foodList) {
			try {
				System.out.println("Server \tgetting " + food.getName() + " from the server counter");
				queue.take();
				System.out.println("Server \tserving " + food.getName() + " for " + food.getServeTime() + " seconds");
				Thread.sleep(food.getCookTime() * 1000);
			} catch (InterruptedException ex) {

			}
		}
	}
}

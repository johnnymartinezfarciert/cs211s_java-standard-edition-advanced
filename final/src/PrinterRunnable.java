public class PrinterRunnable implements Runnable {
	// Write a complete thread class that takes a String message and integer
	// numTimes as parameters.
	private String message;
	private int numTimes;

	public PrinterRunnable(String message, int numTimes) {
		this.message = message;
		this.numTimes = numTimes;
	}

	@Override
	public void run() {
		// When the thread is run, it prints the message numTimes times.
		for (int i = 0; i < numTimes; i++) {
			System.out.println(message);
		}

	}
	
	public static void main(String[] args) {
		// Write statements to create and start two threads- one to print your
		// name 10 times and one to print "summer!" 100 times.
		Thread printerRunnable = new Thread(new PrinterRunnable("Johnny", 10));
		printerRunnable.start();
		Thread summerRunnable = new Thread(new PrinterRunnable("SUMMER", 100));
		summerRunnable.start();		

	}

}

public class PrinterThread {

	public static void main(String[] args) {
		// Write statements to create and start two threads- one to print your
		// name 10 times and one to print "summer!" 100 times.
		Thread printerRunnable = new Thread(new PrinterRunnable("Johnny", 10));
		printerRunnable.start();
		Thread summerRunnable = new Thread(new PrinterRunnable("SUMMER", 100));
		summerRunnable.start();		

	}

}
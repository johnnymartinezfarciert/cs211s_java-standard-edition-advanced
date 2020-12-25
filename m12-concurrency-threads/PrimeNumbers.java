import java.util.ArrayList;
import java.util.Scanner;

/**
 * PrimeNumbers.java - tests if a user entered number is prime
 * @Author Marti Kandallu
 * @Date 05-03-20
 */

public class PrimeNumbers implements Runnable{

    private int testNumber;

    public PrimeNumbers(int userNum){
        this.testNumber = userNum;
    }

    @Override
    public void run(){

        System.out.println(testNumber + " is prime? : " + isPrime(testNumber));

    }

    //code to test if the number is prime
    private static boolean isPrime(int num){

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex){
        }

        int divider = 2;

        while (divider <= Math.sqrt(num)) {
            if (num % divider == 0) {
                return false;
            }
            divider++;
        }
        return true;
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int userInput = 1;

        ArrayList<Thread> threads = new ArrayList<>();

        while(userInput >= 1){

            System.out.println("Enter a number to see if it's prime, enter any number <= 0 to quit: ");

            userInput = scan.nextInt();
            if(userInput <= 0){
                System.out.println("Thank you!");
                break;
            }
                Thread numThread = new Thread(new PrimeNumbers(userInput));
                numThread.start();
                threads.add(numThread);
        }
        try {
            for (Thread t : threads) {
                t.join();
            }
        }
        catch (InterruptedException ex){
            System.out.println("Exception has been thrown");
        }
    }
}

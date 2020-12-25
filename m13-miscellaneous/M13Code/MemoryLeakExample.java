import java.util.*;

public class MemoryLeakExample extends Thread {

    private LeakyStack<Integer> stack;
    private Random generator;
    
    public void run() {
        int bigSize = 5000000;
        generator = new Random();
        stack = new LeakyStack<>(bigSize+1);

        for(int i=0; i<bigSize; i++) {
            stack.push(generator.nextInt(100));
        }
        for(int i=0; i<bigSize; i++) {
            stack.pop();
        }
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        List<Thread> threadList = new ArrayList<>();
        int numberOfThreads = 100;
        for(int i=0; i<numberOfThreads; i++) {
            threadList.add(new MemoryLeakExample());
        }

        for(Thread thread : threadList) {
            thread.start();
        }
        for(Thread thread : threadList) {
            thread.join();
        }        
        System.out.println("done");

    }
    
    
    
}
package island;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        island.Island.getInstance();
        island.Island.printMatrix();
        island.IOOperation.scheduleTasks();
        Thread.sleep(20000);
        IOOperation.CONTINUE_EXECUTION.set(false);
    }
}










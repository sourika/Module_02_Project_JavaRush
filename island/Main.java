package island;

import island.IOOperation;
import island.Island;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        island.Island.getInstance();
        island.Island.printMatrix();
        island.IOOperation.scheduleTasks();
        Thread.sleep(20000);
        IOOperation.continueExecution.set(false);

    }
}










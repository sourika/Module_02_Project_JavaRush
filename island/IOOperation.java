package island;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class IOOperation {
    public static Scanner scanner = new Scanner(System.in);
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    static final AtomicBoolean continueExecution = new AtomicBoolean(true);

    public static int enterFromConsole(String message) {
        int number;
        do {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println(message);
            }
            number = scanner.nextInt();
        }
        while (number <= 0);
        return number;
    }

    public static void allTasks() {
        if (continueExecution.get()) {
            Island.selectAction();
            Plant.grow();
            Island.printMatrix();
        }
    }

    public static void scheduleTasks() {
        ScheduledFuture<?> stopHandle = scheduledExecutorService.scheduleAtFixedRate(island.IOOperation::allTasks, 1, 1, TimeUnit.SECONDS);
        Runnable canceller = () -> {
            stopHandle.cancel(true);
            scheduledExecutorService.shutdown();
        };
        try {
            scheduledExecutorService.schedule(canceller, 15, TimeUnit.SECONDS).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}




















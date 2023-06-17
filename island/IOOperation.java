package island;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class IOOperation {
    public static Scanner scanner = new Scanner(System.in);
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    public static final AtomicBoolean CONTINUE_EXECUTION = new AtomicBoolean(true);

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
        if (CONTINUE_EXECUTION.get()) {
            Island.selectAction();
            Plant.grow();
            Island.printMatrix();
        }
    }

    public static void scheduleTasks() {
        ScheduledFuture<?> stopHandle = SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(island.IOOperation::allTasks, 1, 1, TimeUnit.SECONDS);
        Runnable canceller = () -> {
            stopHandle.cancel(true);
            SCHEDULED_EXECUTOR_SERVICE.shutdown();
        };
        try {
            SCHEDULED_EXECUTOR_SERVICE.schedule(canceller, 15, TimeUnit.SECONDS).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}




















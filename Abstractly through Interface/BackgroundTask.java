public class BackgroundTask {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task Running");
        new Thread(task).start();
    }
}
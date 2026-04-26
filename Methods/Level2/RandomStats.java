public class RandomStats {

    public static void main(String[] args) {

        RandomStats obj = new RandomStats();

        int[] numbers = obj.generate4DigitRandomArray(5);

        System.out.println("Generated Numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        double[] results = obj.findAverageMinMax(numbers);

        System.out.println("\nAverage: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }

    public int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }

        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {

        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {

            sum += numbers[i];

            min = (int)Math.min(min, numbers[i]);
            max = (int)Math.max(max, numbers[i]);
        }

        double average = sum / numbers.length;

        return new double[]{average, min, max};
    }
}

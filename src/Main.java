import java.util.Arrays;
import java.util.Random;

class InputThread extends Thread {
    private int[] array;

    public InputThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11) + 25;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = new int[12];
        InputThread[] inputThreads = new InputThread[4];

        for (int i = 0; i < inputThreads.length; i++) {
            inputThreads[i] = new InputThread(array);
            inputThreads[i].start();
        }

        for (int i = 0; i < inputThreads.length; i++) {
            try {
                inputThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(Arrays.toString(array));
    }


}
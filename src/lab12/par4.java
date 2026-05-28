package lab12;

public class par4 {
    static void main() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(i);
            t.start();
            t.join();
        }
    }

    static class MyThread extends Thread {
        private final int number;

        public MyThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println(number);
        }
    }
}

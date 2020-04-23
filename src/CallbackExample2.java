import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CallbackExample2 {

    public static void main(String[] args) {

        CallbackService callbackService = new CallbackService();
        CallbackExample2 listener = new CallbackExample2();
        CompletableFuture<String> f = CompletableFuture.supplyAsync(callbackService::work);
        f.thenAccept(listener::notify);
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Main");
    }

    private void notify(String msg) {
        System.out.println("Received message: " + msg);
    }
}

class CallbackService {
    String work() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        char[] str = new char[5];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int idx = 0; idx < str.length; ++idx)
            str[idx] = (char) ('A' + current.nextInt(26));
        String msg = new String(str);
        System.out.println("Generated message: " + msg);
        return msg;
    }
}
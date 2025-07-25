package mate.academy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncRequestProcessor {
    private final Executor executor;

    public AsyncRequestProcessor(Executor executor) {
        this.executor = executor;
    }

    public CompletableFuture<UserData> processRequest(String userId) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        UserData userData = new UserData(userId, "Details");
        return CompletableFuture.supplyAsync(() -> userData);
    }
}

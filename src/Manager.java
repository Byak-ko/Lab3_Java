import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Manager{

    private final Semaphore access;
    private final Semaphore fullStorage;
    private final Semaphore empty;

    private ArrayList<String> storage = new ArrayList<>();

    public Manager(int storageSize) {
        access = new Semaphore(1);
        fullStorage = new Semaphore(storageSize);
        empty = new Semaphore(0);
    }

    public void acquireStorageSemaphore() throws InterruptedException {
        access.acquire();
    }
    public void releaseStorageSemaphore() throws InterruptedException {
        access.release();
    }

    public void acquireFullStorageSemaphore() throws InterruptedException {
        fullStorage.acquire();
    }
    public void releaseFullStorageSemaphore() throws InterruptedException {
        fullStorage.release();
    }
    public void acquireEmptySemaphore() throws InterruptedException {
        empty.acquire();
    }
    public void releaseEmptySemaphore() throws InterruptedException {
        empty.release();
    }

    public ArrayList<String> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<String> storage) {
        this.storage = storage;
    }
}
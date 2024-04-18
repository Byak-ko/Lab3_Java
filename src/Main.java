public class Main {

    public static void main(String[] args){
        int storageSize = 5;
        int producersNumber = 5;
        int consumersNumber = 5;
        int itemToPC = 40;
        int itemsPerProducer = itemToPC / producersNumber;
        int itemsPerConsumer = itemToPC / consumersNumber;

        Manager manager = new Manager(storageSize);
        for (int i = 0; i < producersNumber; i++) {
            int itemsToProduceForProducer;
            if (i == producersNumber - 1) {
                itemsToProduceForProducer = itemToPC - (itemsPerProducer * (producersNumber - 1));
            } else
                itemsToProduceForProducer = itemsPerProducer;
            new Producer(itemsToProduceForProducer, manager, "Producer #" + i);
        }

        for (int j = 0; j < consumersNumber; j++) {
            int itemsToConsumeForConsumer;
            if (j == consumersNumber - 1) {
                itemsToConsumeForConsumer = itemToPC - (itemsPerConsumer * (consumersNumber - 1));
            } else
                itemsToConsumeForConsumer = itemsPerConsumer;
            new Consumer(itemsToConsumeForConsumer, manager, "Consumer #" + j);
        }

    }
}
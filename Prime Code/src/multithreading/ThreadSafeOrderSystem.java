package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeOrderSystem {

    static class ProductInventory {
        private final String productId;
        private final AtomicInteger stock;
        private final AtomicInteger successfulOrders = new AtomicInteger(0);
        private final AtomicInteger failedOrders = new AtomicInteger(0);
        ReentrantLock lock = new ReentrantLock(true);
        public ProductInventory(String productId, int initialStock) {
            this.productId = productId;
            this.stock = new AtomicInteger(initialStock);
        }

        /**
         * Attempts to deduct stock atomically using a Compare-And-Swap (CAS) loop.
         *
         * @param quantity Number of units requested
         * @return true if the order was filled, false if insufficient stock
         */
        public boolean placeOrder(int quantity) {
            lock.lock();
            try {
                while (true) {
                    int currentStock = stock.get();

                    // Guard check: Reject immediately if stock is depleted
                    if (currentStock < quantity) {
                        failedOrders.incrementAndGet();
                        return false;
                    }

                    // Atomic update: only updates if currentStock has not changed
                    // since reading it. If another thread modified it, CAS fails and loops.
                    if (stock.compareAndSet(currentStock, currentStock - quantity)) {
                        successfulOrders.incrementAndGet();
                        return true;
                    }
                }
            }
            finally {

            }
        }

        public int getStock() {
            return stock.get();
        }

        public int getSuccessfulOrders() {
            return successfulOrders.get();
        }

        public int getFailedOrders() {
            return failedOrders.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int initialStock = 5;
        int totalRequests = 10;
        int threadPoolSize = 4;

        ProductInventory inventory = new ProductInventory("PROD-001", initialStock);
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
       // CountDownLatch latch = new CountDownLatch(totalRequests);

        System.out.println("Starting concurrent order simulation...");

        for (int i = 1; i <= totalRequests; i++) {
            final String customerId = "Customer-" + i;
            executor.submit(() -> {
                try {
                    boolean success = inventory.placeOrder(1);
                    if (success) {
                        System.out.println(customerId + " -> ORDER SUCCESS (Remaining: " + inventory.getStock() + ")");
                    } else {
                        System.out.println(customerId + " -> ORDER FAILED (Out of Stock)");
                    }
                } finally {
                   // latch.countDown();
                }
            });
        }

        // Wait for all threads to finish before generating the audit report
      //  latch.await();
        executor.shutdown();

        System.out.println("\n=== Final Inventory Audit ===");
        System.out.println("Initial Stock:     " + initialStock);
        System.out.println("Remaining Stock:   " + inventory.getStock());
        System.out.println("Successful Orders: " + inventory.getSuccessfulOrders());
        System.out.println("Failed Orders:     " + inventory.getFailedOrders());
        System.out.println("Integrity Check:   " +
                ((inventory.getStock() + inventory.getSuccessfulOrders() == initialStock) ? "PASSED" : "FAILED"));
    }
}

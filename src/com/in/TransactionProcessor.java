package com.in;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionProcessor {
	private  BlockingQueue<Transaction> queue;
	
	private  TransactionHistory history;
	
	private AtomicLong totalProcessingTime = new AtomicLong(0);
    private  AtomicInteger processedTransactions = new AtomicInteger(0);

    public TransactionProcessor(int queueCapacity)
    {
    	this.queue =new ArrayBlockingQueue<>(queueCapacity);
    	this.history = new TransactionHistory();
    }
    
    public void startProcessing(int numProducers, int numConsumers)
    {
    	for(int i =0; i< numProducers; i++)
    	{
    		new Thread(new Producer()).start();
    		
    	}
    	for(int i =0; i< numConsumers; i++)
    	{
    		new Thread(new Consumer()).start();
    	}
    }
    private class Producer implements Runnable {
        private final Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    String transactionID = UUID.randomUUID().toString();
                    long timestamp = System.currentTimeMillis();
                    String transactionType = "Type" + random.nextInt(5);
                    double amount = random.nextDouble() * 1000;

                    Transaction transaction = new Transaction(transactionID, timestamp, transactionType, amount);
                    queue.put(transaction);

                    // Simulate time taken to produce
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    long startTime = System.currentTimeMillis();
                    Transaction transaction = queue.take();
                    long processingTime = System.currentTimeMillis() - startTime;

                    history.add(transaction);
                    totalProcessingTime.addAndGet(processingTime);
                    processedTransactions.incrementAndGet();

                    // Simulate time taken to consume
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public double getAverageProcessingTime() {
        return (double) totalProcessingTime.get() / processedTransactions.get();
    }

    public int getQueueLength() {
        return queue.size();
    }
}
    
	
	
	



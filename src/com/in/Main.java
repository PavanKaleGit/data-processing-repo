package com.in;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
public static void main(String[] args) {
	

	
	TransactionProcessor processor = new TransactionProcessor(100);
    processor.startProcessing(5, 5);
    
 // Monitoring performance
    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("Average processing time: " + processor.getAverageProcessingTime() + " ms");
            System.out.println("Current queue length: " + processor.getQueueLength());
        }
    }, 0, 5000);
}
}


    


package com.cafeform.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Compute fibonacci number by Dynamic Programming 
 */
public class Fibonacci2 {
    AtomicInteger totalSteps = new AtomicInteger(0);

    public static void main(String[] args) {
        new Fibonacci2().start();
    }

    private void start() {
        
        for(int input = 0 ; input < 10 ; input++){
            totalSteps.set(0);
            
            long ans = fibo(input);
            System.out.println("Fibonacci(" + input + ")=" + ans + 
              "\tTotal steps: " + totalSteps);
        }
    }

    private long fibo(long input) {
        if(0 == input ){
            totalSteps.incrementAndGet();            
            return 0;
        } else if(1 == input){
            totalSteps.incrementAndGet();                        
            return 1;
        }
        long fiboArray[] = new long[2];
        fiboArray[0] = 0;
        fiboArray[1] = 1;
        long ans = 0;
        for(int i = 2 ; i <= input ; i++)
        {
            totalSteps.incrementAndGet();            
            ans = fiboArray[0] + fiboArray[1];
            fiboArray[0] = fiboArray[1];
            fiboArray[1] = ans;
        }
        return ans;
    }
}

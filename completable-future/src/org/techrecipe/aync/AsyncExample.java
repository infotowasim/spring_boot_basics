package org.techrecipe.aync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncExample {
    
	
	
	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) {
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		
		Runnable runnable=()->{
			delay(1);
			System.out.println("I am Runnable - "+ Thread.currentThread().getName());
		};
		
		
		CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(runnable,executorService);
		
		System.out.println("I am in main - "+ Thread.currentThread().getName());
		
		
		completableFuture.join();
		
		
	}
}

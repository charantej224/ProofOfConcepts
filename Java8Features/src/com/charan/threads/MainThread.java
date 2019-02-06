package com.charan.threads;

import java.util.concurrent.Callable;

public class MainThread {
	
	public static void main(String[] args) {
		MainThread mainThread = new MainThread();
		mainThread.callableMethodCall();
	}

	private void callableMethodCall() {
		// TODO Auto-generated method stub
		Callable<String> callable = () -> {
			System.out.println("invoking callable interface via lamdas");
			Thread.sleep(2000);
			return "bhiska";
		};
		
		try {
			String string = callable.call();
			System.out.println(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

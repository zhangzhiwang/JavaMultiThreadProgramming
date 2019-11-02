package com.asiainfo.chapter3;

public class Provider3 extends Thread {
	private ProviderConsumer providerConsumer;

	public Provider3(ProviderConsumer providerConsumer) {
		super();
		this.providerConsumer = providerConsumer;
	}
	
	public void run() {
		try {
			providerConsumer.produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

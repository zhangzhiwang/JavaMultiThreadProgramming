package com.asiainfo.chapter3;

public class Consumer3 extends Thread {
	private ProviderConsumer providerConsumer;

	public Consumer3(ProviderConsumer providerConsumer) {
		super();
		this.providerConsumer = providerConsumer;
	}

	public void run() {
		try {
			providerConsumer.consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

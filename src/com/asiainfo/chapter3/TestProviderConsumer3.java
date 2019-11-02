package com.asiainfo.chapter3;

public class TestProviderConsumer3 {
	public static void main(String[] args) {
		ProviderConsumer providerConsumer = new ProviderConsumer();

		for (int i = 0; i < 20; i++) {
			Consumer3 consumer3 = new Consumer3(providerConsumer);
			consumer3.start();

			Provider3 provider3 = new Provider3(providerConsumer);
			provider3.start();
		}
	}
}

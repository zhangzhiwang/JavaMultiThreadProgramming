package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteThread extends Thread {
	private ReadWritePipedStream pipedStream;
	private PipedOutputStream pipedOutputStream;

	public WriteThread(ReadWritePipedStream pipedStream, PipedOutputStream pipedOutputStream) {
		super();
		this.pipedStream = pipedStream;
		this.pipedOutputStream = pipedOutputStream;
	}

	public void run() {
		try {
			pipedStream.write(pipedOutputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

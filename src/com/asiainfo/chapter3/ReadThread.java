package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadThread extends Thread {
	private ReadWritePipedStream pipedStream;
	private PipedInputStream pipedInputStream;

	public ReadThread(ReadWritePipedStream pipedStream, PipedInputStream pipedOutputStream) {
		super();
		this.pipedStream = pipedStream;
		this.pipedInputStream = pipedOutputStream;
	}

	public void run() {
		try {
			pipedStream.read(pipedInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

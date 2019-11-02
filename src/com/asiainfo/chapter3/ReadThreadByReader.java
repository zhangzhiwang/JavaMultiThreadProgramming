package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadThreadByReader extends Thread {
	private ReadWritePipedStream pipedStream;
	private PipedReader pipedReader;

	public ReadThreadByReader(ReadWritePipedStream pipedStream, PipedReader pipedReader) {
		super();
		this.pipedStream = pipedStream;
		this.pipedReader = pipedReader;
	}

	public void run() {
		try {
			pipedStream.readByReader(pipedReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

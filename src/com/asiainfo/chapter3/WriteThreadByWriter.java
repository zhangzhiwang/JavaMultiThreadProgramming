package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteThreadByWriter extends Thread {
	private ReadWritePipedStream pipedStream;
	private PipedWriter pipedWriter;

	public WriteThreadByWriter(ReadWritePipedStream pipedStream, PipedWriter pipedWriter) {
		super();
		this.pipedStream = pipedStream;
		this.pipedWriter = pipedWriter;
	}

	public void run() {
		try {
			pipedStream.writeByWriter(pipedWriter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

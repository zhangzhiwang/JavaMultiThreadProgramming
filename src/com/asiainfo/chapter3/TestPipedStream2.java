package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 测试管道字节流
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午2:41:33
 */
public class TestPipedStream2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ReadWritePipedStream readWritePipedStream = new ReadWritePipedStream();
		
		PipedReader pipedReader = new PipedReader();
		PipedWriter pipedWriter = new PipedWriter();
		pipedWriter.connect(pipedReader);
		
		ReadThreadByReader readThread = new ReadThreadByReader(readWritePipedStream, pipedReader);
		readThread.start();
		
		Thread.sleep(3000);
		
		WriteThreadByWriter writeThread = new WriteThreadByWriter(readWritePipedStream, pipedWriter);
		writeThread.start();
	}
}

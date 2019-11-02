package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 测试管道字节流
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午2:41:33
 */
public class TestPipedStream {
	public static void main(String[] args) throws IOException, InterruptedException {
		ReadWritePipedStream readWritePipedStream = new ReadWritePipedStream();
		
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		pipedInputStream.connect(pipedOutputStream);// 管道输入和输出流建立关系
//		pipedOutputStream.connect(pipedInputStream);
		
		ReadThread readThread = new ReadThread(readWritePipedStream, pipedInputStream);
		readThread.start();
		
		Thread.sleep(3000);
		
		WriteThread writeThread = new WriteThread(readWritePipedStream, pipedOutputStream);
		writeThread.start();
	}
}

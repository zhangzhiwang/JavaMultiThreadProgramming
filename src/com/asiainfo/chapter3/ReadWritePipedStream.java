package com.asiainfo.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道写字节流
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午2:26:06
 */
public class ReadWritePipedStream {
	public void write(PipedOutputStream pipedOutputStream) throws IOException {
		System.out.print("write:");
		for (int i = 0; i < 50; i++) {
			String s = "" + (i + 1);
			pipedOutputStream.write(s.getBytes());
			System.out.print(s);
		}
		System.out.println();
		pipedOutputStream.close();
	}
	
	public void writeByWriter(PipedWriter pipedWriter) throws IOException {
		System.out.print("write:");
		for (int i = 0; i < 50; i++) {
			String s = "" + (i + 1);
			pipedWriter.write(s);
			System.out.print(s);
		}
		System.out.println();
		pipedWriter.close();
	}
	
	public void read(PipedInputStream pipedInputStream) throws IOException {
		System.out.println("read已启动");
		byte[] bs = new byte[20];
		int readLength = pipedInputStream.read(bs);//当没有线程往管道写数据时read()方法阻塞直至有其他线程往管道流写入数据
		System.out.print("read:");
		while(readLength != -1) {
			String newData = new String(bs, 0, readLength);
			System.out.print(newData);
			readLength = pipedInputStream.read(bs);
		}
		System.out.println();
		pipedInputStream.close();
	}
	
	public void readByReader(PipedReader pipedReader) throws IOException {
		System.out.println("read已启动");
		char[] bs = new char[20];
		int readLength = pipedReader.read(bs);//当没有线程往管道写数据时read()方法阻塞直至有其他线程往管道流写入数据
		System.out.print("read:");
		while(readLength != -1) {
			String newData = new String(bs, 0, readLength);
			System.out.print(newData);
			readLength = pipedReader.read(bs);
		}
		System.out.println();
		pipedReader.close();
	}
}

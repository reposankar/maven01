package com.cosmicnet.patterns.structural.decorator;

import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class LowerCaseInputStreamTest {
	
	public static void main(String[] args) {
		int c = 0;
		try {
			InputStream is = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\D\\test\\java\\t2.txt")));
			InputStream isU = new BufferedInputStream(new FileInputStream("C:\\D\\test\\java\\t2.txt"));
			while ((c = is.read())>= 0) {
				System.out.print((char)c);
			}
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}

	}

}

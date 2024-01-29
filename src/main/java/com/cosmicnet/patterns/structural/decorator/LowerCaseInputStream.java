package com.cosmicnet.patterns.structural.decorator;

import java.io.InputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class LowerCaseInputStream extends FilterInputStream{

	
	InputStream is;
	LowerCaseInputStream(InputStream is) {
		super(is);
		this.is = is;
	}
	
	@Override
	public int read() throws IOException {
		int c = is.read(); 
		return c == -1 ? c : Character.toLowerCase((char) c);
		
	}
	@Override
	public int read(byte[] b, int offset, int last) throws IOException {
		int result = is.read(b, offset, last);
		for (int i = offset; i < offset+last; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
		
	}
	
	
}

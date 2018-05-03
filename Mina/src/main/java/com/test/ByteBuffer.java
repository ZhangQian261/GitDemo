package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.mina.core.buffer.IoBuffer;

public class ByteBuffer {

	public static void main(String[] args) {

		/*java.nio.ByteBuffer buf=null;
		Object meeage=null;
		 buf = ((IoBuffer) meeage).buf();
		 
		 int len=buf.getInt(buf.position());
		 System.out.println("buf:"+buf+"  "+"len:"+len);
		*/
		
		/*List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list.size());*/
//		for (int i = 0; i < 1000; i++) {
//			System.out.print(i%4);
//			System.out.print(" ");
//		}
		
		/*String s="1:2222";
		System.out.println(s.substring(s.lastIndexOf(":")+1));*/
		
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int pick = random.nextInt(3);
			System.out.println("Random Value: " + pick);
		}
	
		System.out.println("gitHub上传测试");
		
	}
	
}

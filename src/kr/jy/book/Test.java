package kr.jy.book;

import java.io.UnsupportedEncodingException;

public class Test
{
	static public void main(String [] args) throws UnsupportedEncodingException
	{
		String test = "abcdefg한글입니다.";

		byte [] bb = test.getBytes ();

		for (byte b : bb)
		{
			System.out.print (b + " ");
		}
		System.out.println ();

		String test2 = new String (bb, "EUC-KR");
		String test3 = new String (bb, "UTF-8");

		System.out.println (test2);
		System.out.println (test3);
	}
}

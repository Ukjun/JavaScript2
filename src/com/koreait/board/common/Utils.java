package com.koreait.board.common;

public class Utils {
	public static int parseStringToInt(String str, int n) {
		try {
			Double.parseDouble(str);
			return Integer.parseInt(str);
		}catch(Exception e) {
			return n;
		}
	}
}

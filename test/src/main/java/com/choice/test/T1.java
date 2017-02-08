package com.choice.test;

public class T1 {

	public int i = 1;
	
	public static void bol(T1 t) {
		t.i = 2;
		System.out.println(t.i);
	}
	
	public static void main(String[] args) {
		
		T1 t = new T1();
		bol(t);
		System.out.println(t.i);
		
	}
	
}

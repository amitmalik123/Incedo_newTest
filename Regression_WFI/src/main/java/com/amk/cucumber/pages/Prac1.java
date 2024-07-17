package com.amk.cucumber.pages;

public interface Prac1 {
	
	public void m();
	
	// mainly used for existing implemented interface
	default void m2() {
//		m1();
	}
	
	static void m3() {
		System.out.println("static");
//		m4();		
	}
	
	/*
	 * private void m1() { System.out.println("private"); }
	 * 
	 * private static void m4() { System.out.println("private static"); }
	 */
	
}	

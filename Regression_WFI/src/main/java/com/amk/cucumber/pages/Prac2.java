package com.amk.cucumber.pages;

public class Prac2 extends Prac3 {
	
	Integer temp= null;
	double data= 344.324;
	int d= (int)data;
	
	/*
	 * public Prac2() { this(10); System.out.println("prac2 cons"); }
	 */
	
	/*
	 * public void a() { System.out.println("prac 2 class method"); }
	 */

	public Prac2(int i) {
		System.out.println("i value is "+i);
	}
	{
		System.out.println("instance block");
	}
	
	public static void main(String[] args) {
		
		
		  Prac2 rac= new Prac2(10);   // rac.a(); System.out.println(rac.data);
		 
	}

}

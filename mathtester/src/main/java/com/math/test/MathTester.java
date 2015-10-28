package com.math.test;

public class MathTester implements MathIntf{

	public MathTester(){
		
	}
	public int add(int a,int b){
		return a+b;
	}
	
	public int multiply(int a,int b){
		return a*b;
	}
	
	public int divide(int a,int b){
		if(a>b){
			throw new NumberFormatException ("please enter dividend ");
		}
		return a/b;
	}
	
}

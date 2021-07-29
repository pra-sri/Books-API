package com.mphasis;
import java.util.Scanner;
 
class Tester extends Thread{
	
	public void start()
	{
		 System.out.println("running");
	}
	
  public static void main (String args[]) {
	  
	  Tester t1 = new Tester();
	  t1.start();
	  t1.start(); 
	  
	  
	  
	  
	  
}
}

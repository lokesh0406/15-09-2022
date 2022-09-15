

/*1. create thread 4 object methods are should synchroniced methods 
2. call sleep methods sleeping times depending on user inputs
3. Two thread keep on intrrupting the sleeping thread  
4. print the interrupted threads name and priority's

*/

package com.thread001.demo;
import java.util.Scanner;
class S1   {
	
	synchronized public void Method1() {   
		
		System.out.println("Generating Numbers");
		
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}
	}
    
	
	synchronized public void Method2() {  
		
		System.out.println("Divisible by two");
		
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}

	synchronized  public void Method3() {
		
		System.out.println("Prime numbers");
		int i;
		int j;
		for( i=0; i<=10; i++) {
			for( j=2; j<i; j++) {
				int n = i%j;
				if(n==0)
					break;
			}
			if(i==j) {
				System.out.println(i);
			}
		}
	}

	synchronized public void Method4() {
		
		int i, sum;
		double avg;
		sum=0;
		
		System.out.println("Finding average");
		
		
		for(i=2; i<=10; i++) {
			sum = sum + i;
			avg =sum/(i-1);
		
		
			System.out.println(avg);
		
		}
	}
}
class S2 extends Thread {
	Scanner sc = new Scanner(System.in);
	
	S1 obj;
	
	S2(S1 obj){
		this.obj = obj;
	}
	@Override
	public void run() {
		
		
		try {
			System.out.println("Enter the seconds to process method1");
			System.out.println("1000=1sec");
			int i = sc.nextInt();
			Thread.sleep(i);
	    	obj.Method1();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted 1-st method");
			System.out.println("Thread Name:" +Thread.currentThread().getName());
			System.out.println("Thread Priority:" +Thread.currentThread().getPriority());
		}
	}
}
		
class S3 extends Thread {
	Scanner sc = new Scanner(System.in);
			
			S1 obj;
			
			S3(S1 obj){
				this.obj = obj;
			}
			
			@Override
			public void run() {		
		try {
			
			int i = sc.nextInt();
			Thread.sleep(i);
	    	obj.Method2();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted 2-nd method");
			System.out.println("Thread Name:" +Thread.currentThread().getName());
			System.out.println("Thread Priority:" +Thread.currentThread().getPriority());
		}
	}
			
}		
		
class S4 extends Thread {
	Scanner sc = new Scanner(System.in);
	
	S1 obj;
	
	S4(S1 obj){
		this.obj = obj;
	}
	@Override
	public void run() {	
		
		try {
			
			int i = sc.nextInt();
			Thread.sleep(i);
	    	obj.Method3();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted 3-rd method");
		}
		
	}	
}		
class S5 extends Thread {
			Scanner sc = new Scanner(System.in);
			
			S1 obj;
			
			S5(S1 obj){
				this.obj = obj;
			}
			@Override
			public void run() {	
		
		try {
			
			int i = sc.nextInt();
			Thread.sleep(i);
	    	obj.Method4();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted 4-th method");
		}
		
	}
	
}

public class Thread01 {

	public static void main(String[] args) {
		
		S1 obj1 = new S1();
		
		S2 obj2 = new S2(obj1);
		
		S3 obj3 = new S3(obj1);
		
		S3 obj4 = new S3(obj1);
		
		S3 obj5 = new S3(obj1);
		
		obj2.start();
		
		obj2.interrupt();
		
		obj3.start();
		
		obj3.interrupt();
		
		obj4.start();

        obj5.start();
	
	}

}

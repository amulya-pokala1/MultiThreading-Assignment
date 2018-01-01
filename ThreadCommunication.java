//Implementing even and odd with sync method
package com.accolite.mini_au;
class Printer
{
	static int counter=1;
	synchronized void displayCounter()
	{
		System.out.println(Thread.currentThread().getName()+" : "+counter);
	}
	synchronized int getCounter()
	{
		return counter;
	}
	synchronized void incrementCounter()
	{
		counter++;
	}
}
class PrintNum extends Thread
{
	Printer p;
	String name;
	PrintNum(Printer p,String name)
	{
		this.p=p;
		this.name=name;
	}
	public void run()
	{
		while(p.getCounter()<=100)
		{
			if(name=="odd" && p.getCounter()%2!=0)
			{
				p.displayCounter();
				p.incrementCounter();
			}
			else if(name=="even" && p.getCounter()%2==0)
			{
				p.displayCounter();
				p.incrementCounter();
			}
		}
		
	}
}

public class ThreadCommunication {
	public static void main(String args[])
	{
		Printer p=new Printer();
		PrintNum p1=new PrintNum(p,"odd");
		PrintNum p2=new PrintNum(p,"even");
		p1.start();
		p2.start();
	}
}

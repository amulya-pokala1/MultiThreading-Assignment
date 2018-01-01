package com.accolite.mini_au;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Entity extends Thread
{
	BlockingQueue<Integer> queue ;
	String name;
	static int counter=1;
	Entity(BlockingQueue<Integer> queue,String name)
	{
		this.queue=queue;
		this.name=name;
	}
	public void run()
	{
		while(counter<=11)
		{
			if(name=="producer" && counter<=10)
			{
				try {
					queue.put(counter);
					System.out.println("produced: "+counter++);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			else if(name=="consumer")
			{
				try {
					Integer consumed=queue.take();
					System.out.println("consumed: "+consumed);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}		
			}
		}
		
	}
}

public class ProducerConsumer {
	public static void main(String args[])
	{
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		Entity e1=new Entity(queue,"producer");
		Entity e2=new Entity(queue,"consumer");
		e1.start();
		e2.start();
	}
}

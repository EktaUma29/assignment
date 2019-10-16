package com.yash.assignment.two;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;


public class SingletonThreadSafeTest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Test
	public void shouldEqualsSerializationAndDeSerializationObject() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("file.txt");

		ObjectOutputStream outputStream = new ObjectOutputStream(fos);
		
		SingletonThreadSafe instance = SingletonThreadSafe.getInstance(); 
		
		outputStream.writeObject(instance);
		
		FileInputStream fis = new FileInputStream("file.txt");
		
		ObjectInputStream inputStream = new ObjectInputStream(fis);
		
		Object inputObject = inputStream.readObject();
		
		assertEquals(inputObject, instance);
		
		outputStream.close();
		inputStream.close();
	}
	
	
}

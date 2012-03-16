/*
 * Junit test cases for the package
 */
package com.lynn.caculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
//import static org.mockito.Mockito.*;

public class TestCaculator {
	Caculator caculator = null;
	
	@Before
	public void createCaculatorInstance(){
		caculator = new Caculator();
	}
		
	@Test
	public void testCaculatorAdd(){
		assertEquals(33,caculator.caculatorAdd(11, 22),0);
	}
	
	@Test
	public void testCaculatorSub(){
		assertEquals(11,caculator.caculatorSub(22, 11),0);
	}
	
//	@Test
//	public void testCaculatorToatol(){
//		List mockedList = mock(List.class);
//		Iterator mockedElement = mock(Iterator.class);
//		ArrayList arrayList = new ArrayList();
////		Iterator<Double> element = new Iterator<Double>();
//		
//		mockedList.add(1.1D);
//		mockedList.add(2.1D);
//		mockedList.add(3.1D);
////		when(mockedList.get(anyInt())).thenReturn("get operation");
//		when(mockedList.iterator()).thenReturn(arrayList.iterator());
//		when(mockedElement.next()).thenReturn(arrayList.iterator());
////		when(mockedList.size()).thenReturn(0);
//		caculator.caculatorToatol(mockedList);
////		System.out.println(mockedList.get(1));
//	}
	
	@After
	public void setCaculatorNull(){
		caculator = null;
	}
	
}

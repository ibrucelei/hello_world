package com.example.dataStruct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayAndStringTest {
	
	public ArrayAndString targetObject;
	public int[] targetArray1= {12,34,4,2,2,2,1,1,1};
	public int[] targetArray2= {1,2,3,4,5,4,3,2,1};
	public int[] targetBinaryArray= {1,1,0,1,1,1,0,0,1,1,1,0};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		targetObject=new ArrayAndString();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindCenterIndex() {
		assertEquals(4, targetObject.findCenterIndex(targetArray2));
		assertEquals(-1, targetObject.findCenterIndex(targetArray1));
	}

	@Test
	public void testIsBiggestDoubleOthers() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlusOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDiagonalTraversal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpiralTraversal() {
		fail("Not yet implemented");
	}

	@Test
	public void testYangHuiTriangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBinarySum() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexof() {
		fail("Not yet implemented");
	}

	@Test
	public void testLongestCommonPrefix() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivideArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddForTarget() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveItemByValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountOfContinuousOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testShortestArray() {
		fail("Not yet implemented");
	}

}

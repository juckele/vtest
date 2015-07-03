package com.johnuckele.vtest;

import org.junit.Assert;
import org.junit.Test;

public class TestTests {

	@Test
	public void testEquality() {
	}

	@Test
	public void testNullity() {
		
	}

	@Test
	public void testTruthiness() {
		Tester.isTrue("isTrue", true);
		try{
			Tester.isTrue("isTrue", false);
			Assert.fail("Preceeding Tester case should fail");
		}
		catch (AssertionError e) {
			// Correct
		}
		Tester.isFalse("isFalse", false);
		try{
			Tester.isFalse("isFalse", true);
			Assert.fail("Preceeding Tester case should fail");
		}
		catch (AssertionError e) {
			// Correct
		}
	}
}

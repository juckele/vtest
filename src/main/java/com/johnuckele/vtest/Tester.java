package com.johnuckele.vtest;

import static org.junit.Assert.assertTrue;

/**
 * A verbose wrapper for JUnit tests. Using Tester still requires using @Test annotations
 * on test methods. Each method of Tester will automatically check scope to print test
 * progress, print messages of each test, and print the inputs of the test before printing
 * the pass/fail status of the test.
 * 
 * Because the messages print on every test run, not just failures, the test messages
 * should generally be affirmative statements of expectations.
 * 
 * @author John Uckele
 */
public class Tester
{
	private static String classScope = "";
	private static String methodScope = "";

	private static void checkScope()
	{
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		String localClassScope = elements[3].getClassName();
		String localMethodScope = elements[3].getMethodName();
		// If either have changed, produce some verbose output
		if(!classScope.equals(localClassScope))
		{
			classScope = localClassScope;
			System.out.println("Starting tests for "+localClassScope);
		}
		if(!methodScope.equals(localMethodScope))
		{
			methodScope = localMethodScope;
			System.out.println("\t"+methodScope);
		}
	}

	/**
	 * Test if two boolean values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, boolean lhs, boolean rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if two byte values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if two char values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if a Comparable object is equal to another object.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void equal(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs.compareTo(rhs) == 0 );
	}

	/**
	 * Test if two double values are equal within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void equal(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test(Math.abs(difference) <= margin);
	}

	/**
	 * Test if two float values are equal within a supplied margin
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void equal(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test(Math.abs(difference) <= margin);
	}

	/**
	 * Test if two int values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if two long values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if two short values are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs == rhs );
	}

	/**
	 * Test if two String objects are equal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void equal(String message, String lhs, String rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" == "+rhs);
		test( lhs.equals(rhs) );
	}

	/**
	 * A test that fails if it is reached in the code.

	 * @param message the message to display when running the test
	 */
	public static void fail(String message)
	{
		checkScope();
		System.out.println("\t\t"+message);
		test( false );
	}

	/**
	 * Test if one byte value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterOrEqual(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs >= rhs );
	}

	/**
	 * Test if one char value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterOrEqual(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs >= rhs );
	}

	/**
	 * Test if a Comparable object is greater than or equal to another object.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void greaterOrEqual(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs.compareTo(rhs) >= 0 );
	}

	/**
	 * Test if one double value is greater than or equal to another within a supplied margin
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void greaterOrEqual(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs >= rhs - Math.abs(difference) );
	}

	/**
	 * Test if one float value is greater than or equal to another within a supplied margin
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void greaterOrEqual(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs >= rhs - Math.abs(difference) );
	}

	/**
	 * Test if one int value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterOrEqual(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs >= rhs );
	}

	/**
	 * Test if one long value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterOrEqual(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs >= rhs );
	}

	/**
	 * Test if one short value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterOrEqual(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" >= "+rhs);
		test( lhs >= rhs );
	}

	/**
	 * Test if one byte value is greater than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterThan(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs > rhs );
	}

	/**
	 * Test if one char value is greater than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterThan(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs > rhs );
	}

	/**
	 * Test if a Comparable object is greater than another object.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void greaterThan(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs.compareTo(rhs) > 0 );
	}

	/**
	 * Test if one double value is greater than another within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void greaterThan(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs > rhs - Math.abs(difference) );
	}

	/**
	 * Test if one float value is greater than another within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void greaterThan(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs > rhs - Math.abs(difference) );
	}

	/**
	 * Test if one int value is greater than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterThan(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs > rhs );
	}

	/**
	 * Test if one long value is greater than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterThan(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs > rhs );
	}

	/**
	 * Test if one short value is greater than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void greaterThan(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" > "+rhs);
		test( lhs > rhs );
	}

	public static void isFalse(String string, boolean test)
	{
		checkScope();
		System.out.println("\t\t"+string+": "+test);
		test( !test );
	}

	public static void isNotNull(String string, Object o)
	{
		checkScope();
		System.out.println("\t\t"+string+": "+o);
		test( o != null );
	}

	public static void isNull(String string, Object o)
	{
		checkScope();
		System.out.println("\t\t"+string+": "+o);
		test( o == null );
	}

	public static void isTrue(String string, boolean test)
	{
		checkScope();
		System.out.println("\t\t"+string+": "+test);
		test( test );
	}

	/**
	 * Test if one byte value is greater than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessOrEqual(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs <= rhs );
	}

	/**
	 * Test if one char value is less than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessOrEqual(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs <= rhs );
	}

	/**
	 * Test if one Comparable object is less than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void lessOrEqual(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs.compareTo(rhs) <= 0 );
	}

	/**
	 * Test if one double value is less than or equal to another within a supplied margin
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void lessOrEqual(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs <= rhs - Math.abs(difference) );
	}

	/**
	 * Test if one float value is less than or equal to another within a supplied margin
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void lessOrEqual(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs <= rhs - Math.abs(difference) );
	}

	/**
	 * Test if one int value is less than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessOrEqual(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs <= rhs );
	}

	/**
	 * Test if one long value is less than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessOrEqual(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs <= rhs );
	}

	/**
	 * Test if one short value is less than or equal to another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessOrEqual(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" <= "+rhs);
		test( lhs <= rhs );
	}

	/**
	 * Test if one byte value is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessThan(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs < rhs );
	}

	/**
	 * Test if one char value is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessThan(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs < rhs );
	}

	/**
	 * Test if one Comparable object is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void lessThan(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs.compareTo(rhs) < 0 );
	}

	/**
	 * Test if one double value is less than another within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void lessThan(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs < rhs - Math.abs(difference) );
	}

	/**
	 * Test if one float value is less than another within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void lessThan(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test( lhs < rhs - Math.abs(difference) );
	}

	/**
	 * Test if one int value is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessThan(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs < rhs );
	}

	/**
	 * Test if one long value is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessThan(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs < rhs );
	}

	/**
	 * Test if one short value is less than another.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void lessThan(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" < "+rhs);
		test( lhs < rhs );
	}
	
	/**
	 * Test if two boolean values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, boolean lhs, boolean rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if two byte values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, byte lhs, byte rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if two char values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, char lhs, char rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if a Comparable object is unequal to another object.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param <T> the generic type of the Comparable object
	 */
	public static <T> void notEqual(String message, Comparable<T> lhs, T rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs.compareTo(rhs) != 0 );
	}

	/**
	 * Test if double char values are unequal within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void notEqual(String message, double lhs, double rhs, double margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test(Math.abs(difference) > margin);
	}

	/**
	 * Test if float char values are unequal within a supplied margin.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 * @param margin the maximum difference between which two values are still considered the same
	 */
	public static void notEqual(String message, float lhs, float rhs, float margin)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs+" ± "+margin);
		double difference = lhs - rhs; 
		test(Math.abs(difference) > margin);
	}

	/**
	 * Test if two int values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, int lhs, int rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if two long values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, long lhs, long rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if two short values are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, short lhs, short rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( lhs != rhs );
	}

	/**
	 * Test if two String objects are unequal.
	 * 
	 * @param message the message to display when running the test
	 * @param lhs the left hand side of the equality
	 * @param rhs the right hand side of the equality
	 */
	public static void notEqual(String message, String lhs, String rhs)
	{
		checkScope();
		System.out.println("\t\t"+message+": "+lhs+" != "+rhs);
		test( !lhs.equals(rhs) );
	}

	/**
	 * A test that passes if it is reached in the code.

	 * @param message the message to display when running the test
	 */
	public static void pass(String message)
	{
		checkScope();
		System.out.println("\t\t"+message);
		test( true );
	}

	private static void test(Boolean evaluation)
	{
		if( evaluation )
		{
			System.out.println("\t\t\t✓ PASSED");
			assertTrue(true);
		}
		else
		{
			System.out.println("\t\t\t✗ FAILED");
			assertTrue(false);
		}
	}
}
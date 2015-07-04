package com.johnuckele.vtest;

import java.util.Date;

import org.junit.Test;

public class TestTests
{
    @Test
    public void testEqualityForComparable()
    {
        // Comparable Object setup
        Date thePast = new Date(System.currentTimeMillis() - 1000);
        long currentMillis = System.currentTimeMillis();
        Date now = new Date(currentMillis);
        Date alsoNow = new Date(currentMillis);
        Date theFuture = new Date(System.currentTimeMillis() + 1000);

        // Test ==
        Tester.equal("equal", now, alsoNow);
        try
        {
            Tester.equal("equal", now, thePast);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test !=
        Tester.notEqual("notEqual", now, thePast);
        try
        {
            Tester.notEqual("equal", now, alsoNow);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test >
        Tester.greaterThan("greaterThan", theFuture, thePast);
        try
        {
            Tester.greaterThan("greaterThan", now, alsoNow);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
        try
        {
            Tester.greaterThan("greaterThan", thePast, now);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test >=
        Tester.greaterOrEqual("greaterOrEqual", theFuture, thePast);
        Tester.greaterOrEqual("greaterOrEqual", now, alsoNow);
        try
        {
            Tester.greaterOrEqual("greaterThan", now, theFuture);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test <
        Tester.lessThan("lessThan", thePast, now);
        try
        {
            Tester.lessThan("lessThan", now, alsoNow);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
        try
        {
            Tester.lessThan("lessThan", theFuture, now);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test <=
        Tester.lessOrEqual("lessOrEqual", thePast, now);
        Tester.lessOrEqual("lessOrEqual", now, alsoNow);
        try
        {
            Tester.lessOrEqual("lessThan", theFuture, now);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }

    @Test
    public void testEqualityForString()
    {
        String foo = "foo", bar = "bar", foo2 = "foo";

        // Test ==
        Tester.equal("equal", foo, foo2);
        try
        {
            Tester.equal("equal", foo, bar);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test !=
        Tester.notEqual("notEqual", foo, bar);
        try
        {
            Tester.notEqual("notEqual", foo, foo2);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }

    @Test
    public void testEqualityForFloatingPointNumbers()
    {
        float pif = (float) Math.PI, piApproxf = 3.14f, sqrt2f = (float) Math.sqrt(2), sqrt2Approxf = 1.41f;
        double pi = Math.PI, piApprox = 3.14, sqrt2 = Math.sqrt(2), sqrt2Approx = 1.41;

        // Test ==
        Tester.equal("equal", piApprox, pi, 0.002);
        Tester.equal("equal", piApproxf, pif, 0.002f);
        try
        {
            Tester.equal("equal", piApprox, pi, 0.001);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
        try
        {
            Tester.equal("equal", piApproxf, pif, 0.001f);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test !=
        Tester.notEqual("notEqual", piApprox, pi, 0.001);
        Tester.notEqual("notEqual", sqrt2f, pif, 1);
        try
        {
            Tester.notEqual("notEqual", sqrt2, sqrt2, 0.0001);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
        try
        {
            Tester.notEqual("notEqual", 0, sqrt2Approxf, 2);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }

    @Test
    public void testEqualsForFixedPrecisionNumbers()
    {

    }

    @Test
    public void testCodepaths()
    {
        // Test pass and fail
        Tester.pass("This code should be reached");
        try
        {
            Tester.fail("This code should not be reached");
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }

    @Test
    public void testNullity()
    {
        // null / non-null object setup
        Object object = new Object();
        Object nullObject = null;

        // Test isNull
        Tester.isNull("isNull", nullObject);
        try
        {
            Tester.isNull("isNull", object);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test notNull
        Tester.isNotNull("isNull", object);
        try
        {
            Tester.isNotNull("isNull", nullObject);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }

    @Test
    public void testTruthiness()
    {
        // Test true
        Tester.isTrue("isTrue", true);
        try
        {
            Tester.isTrue("isTrue", false);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }

        // Test false
        Tester.isFalse("isFalse", false);
        try
        {
            Tester.isFalse("isFalse", true);
            Tester.fail("Preceding case should have failed");
        }
        catch (AssertionError e)
        {
            Tester.pass("Preceding case should have failed");
        }
    }
}

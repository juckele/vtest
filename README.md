vtest is a verbose wrapper for JUnit.

As someone who uses TDD in my day job, I often do my main development entirely with unit tests. I will then run the end to end user test only after the feature is mostly complete and I'm testing the integration of various components by hand. In these cases, knowing what an incorrect value is, or even what a correct value is (if say non null is required), piggybacks with good old school console debug spam style development.

vtest is currently very young, being pulled from the utils package of my artificial life simulation package. After pushing this to a more feature complete status, I'll try to deploy this to an artifact repo. In the meantime, if you want to use this code, I've included a sample usage below:

<pre><code>
import com.johnuckele.vtest.Tester;

...

  int basicMath = 2 + 2;
  Tester.test("Addition test", basicMath, 4);
</code></pre>

vtest does expect a different order for expected and actual parameters than JUnit, but there is no technical need to follow the named usage. You can continue writing tests in the same order as JUnit and the verbose output will still read in an appropriate manner. As long as operands are ordered correctly for inequality tests (the second arguemt will be the LHS of the the inequality, the third argument will be the RHS), 

package org.shelajev.timedignore;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shelajev on 05/08/14.
 */

@RunWith(TimedIgnoreTestRunner.class)
@Ignore(until = "10.12.1999")
public class PastIgnoreTest {

  @Test(expected = RuntimeException.class)
  public void ignoreHasPassed() {
    throw new RuntimeException("This test runs");
  }

}

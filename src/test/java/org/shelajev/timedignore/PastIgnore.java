package org.shelajev.timedignore;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by shelajev on 05/08/14.
 */

@RunWith(TimedIgnoreTestRunner.class)
@Ignore(until = "10.12.1999")
public class PastIgnore {

  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    //this test is supposed to pass
  }
}

package org.shelajev.timedignore;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;

@RunWith(TimedIgnoreTestRunner.class)
@IgnoreUntil(until = "2100-12-10")
public class IgnoredTest {

  @Test
  public void testUnderTimedIgnore() {
    fail("This test is expected to fail");
  }
}

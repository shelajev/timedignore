package org.shelajev.timedignore;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;

@RunWith(TimedIgnoreTestRunner.class)
@Ignore(until = "10.12.2100")
public class Ignored {

  @Test
  public void underTimedIgnore() {
    fail("This test is expected to fail");
  }
}

package org.shelajev.timedignore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Created by shelajev on 05/08/14.
 */
public class TimedIgnoreTestRunner extends BlockJUnit4ClassRunner {
  public TimedIgnoreTestRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  @Override
  public void run(RunNotifier notifier) {
    IgnoreUntil ignoreUntil = getTestClass().getJavaClass().getAnnotation(IgnoreUntil.class);

    if(shouldIgnore(ignoreUntil)) {
      notifier.fireTestIgnored(getDescription());
      return;
    }
    super.run(notifier);
  }

  boolean shouldIgnore(IgnoreUntil ignoreUntil) {
    if(ignoreUntil == null) {
      return false;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    //how awesome Java 8 date and time api is? We don't have to deal with timezones. Pure joy!
    LocalDate date = LocalDate.parse(ignoreUntil.until(), formatter);
    return date.isAfter(LocalDate.now());
  }
}

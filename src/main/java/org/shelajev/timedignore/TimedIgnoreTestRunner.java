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
    //take all annotations and find if any of them is ignore that we should obey
    boolean ignoreTest = Arrays.stream(getTestClass().getAnnotations())
                           .anyMatch(a -> a instanceof Ignore && shouldIgnore(((Ignore) a).until()));
    if(ignoreTest) {
      notifier.fireTestIgnored(getDescription());
      return;
    }
    super.run(notifier);
  }

  boolean shouldIgnore(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    //how awesome Java 8 date and time api is? We don't have to deal with timezones. Pure joy!
    LocalDate date = LocalDate.parse(dateString, formatter);
    return date.isAfter(LocalDate.now());
  }
}

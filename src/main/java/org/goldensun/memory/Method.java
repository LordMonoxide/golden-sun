package org.goldensun.memory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Method {
  int value();
  boolean ignoreExtraParams() default false;
}

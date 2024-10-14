package org.goldensun.memory.segments;

public class PrivilegeNotAcquiredException extends RuntimeException {
  public PrivilegeNotAcquiredException(final String message) {
    super(message);
  }

  public PrivilegeNotAcquiredException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PrivilegeNotAcquiredException(final Throwable cause) {
    super(cause);
  }

  protected PrivilegeNotAcquiredException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

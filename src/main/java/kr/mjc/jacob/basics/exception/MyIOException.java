package kr.mjc.jacob.basics.exception;

/**
 * IOException의 unchecked exception 타입
 */
public class MyIOException extends RuntimeException {
	public MyIOException() {
		super();
	}

	public MyIOException(Throwable cause) {
		super(cause);
	}
}

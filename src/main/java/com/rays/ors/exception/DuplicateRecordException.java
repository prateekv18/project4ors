package com.rays.ors.exception;

/*
 * Duplicate exception is used when a record is already in database
 * */

public class DuplicateRecordException extends Exception {

	/*
	 * Error message for duplicacy....
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}

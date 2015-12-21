package com.rockwellcollins.validation;

public class SpearIncompleteException extends RuntimeException {

	/**
	 * This exception is used when the code does not match all cases for developer feedback.
	 */
	private static final long serialVersionUID = -6019470612527156779L;

	public SpearIncompleteException(String message) {
		super(message);
	}
}

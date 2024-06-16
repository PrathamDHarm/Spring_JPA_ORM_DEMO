package com.acc.lkm.exception;

public class CustomException1 extends Exception {
	public CustomException1() {
		super("Employee ID doesn't exist.Please verify the input.");
	}
}

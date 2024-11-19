package com.abhiyantrikitech.exception;

public class ResourceAlreadExists extends RuntimeException {
	public ResourceAlreadExists(String str) {
		super(str);
	}
}

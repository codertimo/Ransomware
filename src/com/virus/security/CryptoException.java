package com.virus.security;

/**
 * Created by codertimo on 15. 11. 25..
 */

/**
 * 암호화 하는 과정에서 발생하는 Exeption Class
 */
public class CryptoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CryptoException() {
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

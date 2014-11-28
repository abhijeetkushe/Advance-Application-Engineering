/**
 * 
 */
package org.stable.sdk.service.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.stable.sdk.service.exceptions.EncryptionException;

/**
 * @author Amuthan Arulraj
 * 
 */
public class EncryptionUtil {

	/**
	 * name of the character set to use for converting between characters and
	 * bytes
	 */
	private static final String CHARSET_NAME = "UTF-8";

	/** random number generator algorithm */
	private static final String RNG_ALGORITHM = "SHA1PRNG";

	/** message digest algorithm */
	private static final String DIGEST_ALGORITHM = "SHA-1";

	/** random number generator algorithm */
	private static final String SECURITY_PROVIDER = "BC";

	/** Adding Bouncy Castle to Security Provider list */
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * Please create new instance of the class for overcoming concurrency issues
	 */
	public EncryptionUtil() {
		super();
	}

	/**
	 * Encrypts input string and returns the encoded digest
	 * 
	 * @param password
	 * @return encoded digest
	 * @throws EncryptionException
	 */
	public String encryptPassword(String password)
			throws EncryptionException {
		// TODO Add password salting
		int iteration = 10;
		// byte[] salt = ;
		try {
			MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM,
					SECURITY_PROVIDER);
			md.reset();
			// md.update(salt);
			byte[] digest = md.digest(password.getBytes(CHARSET_NAME));
			for (int i = 0; i < iteration; i++) {
				md.reset();
				digest = md.digest(digest);
			}
			return new sun.misc.BASE64Encoder().encode(digest);
		} catch (NoSuchAlgorithmException nsae) {
			throw new EncryptionException("Digest Algorithm "
					+ DIGEST_ALGORITHM + " not available", nsae);
		} catch (NoSuchProviderException nspe) {
			throw new EncryptionException("Security provider "
					+ SECURITY_PROVIDER + " not available", nspe);
		} catch (UnsupportedEncodingException usee) {
			throw new EncryptionException("Encoding " + CHARSET_NAME
					+ " not available", usee);
		}
	}
}

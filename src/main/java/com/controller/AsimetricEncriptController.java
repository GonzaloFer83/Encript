package com.controller;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class AsimetricEncriptController {
	private String valueCodification;

	private Cipher cifrador;
	private KeyPair claves;
	private byte[] bytesMensajeOriginal;
	private byte[] bytesMensajeCifrado;

	public AsimetricEncriptController(String toEncript) {
		try {
			KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");

			claves = generador.generateKeyPair();

			cifrador = Cipher.getInstance("RSA");

			cifrador.init(Cipher.ENCRYPT_MODE, claves.getPrivate());
			

			bytesMensajeOriginal = toEncript.getBytes();
			bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
			valueCodification = new String(bytesMensajeCifrado);

			

		} catch (GeneralSecurityException e) {
			System.out.println("Error al cifrar o descifrar el mensaje");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

	public String DecodeString() {
		String aux = null;
		try {
			cifrador.init(Cipher.DECRYPT_MODE, claves.getPublic());
			byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
			aux = new String(bytesMensajeDescifrado);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	public String getValueCodification() {
		return valueCodification;
	}
}

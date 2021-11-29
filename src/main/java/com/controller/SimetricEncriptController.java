package com.controller;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SimetricEncriptController {
	private String valueCodification;
	private Cipher cifrador;
	private byte[] bytesMensajeCifrado;
	private SecretKey paloEspartano;
		public String getValueCodification() {
		return valueCodification;
	}

		public SimetricEncriptController(String toCodification) {
			
			
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
		

			paloEspartano = generador.generateKey();

		

			cifrador = Cipher.getInstance("AES");
			

			cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);

			
			byte[] bytesMensajeOriginal = toCodification.getBytes();
			bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
			valueCodification = new String(bytesMensajeCifrado);
			
			

		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
		}
		public String DecodeString() {
			String aux = null;
			try {
				cifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
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
	

	
}

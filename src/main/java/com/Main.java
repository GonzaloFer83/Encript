package com;

import java.util.Scanner;

import com.controller.AsimetricEncriptController;
import com.controller.SimetricEncriptController;
import com.model.Car;

public class Main {
private static Scanner sc = new Scanner(System.in);
private static int menuValue;
private static SimetricEncriptController simetricEncriptator ;
private static AsimetricEncriptController asimetricEncriptator;
private static String howEncript= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		while(menuValue !=7){
			System.out.println("Pulse el numero correspondiente a la acción que desee.\n"
					+ "1: Encriptar una frase.\n"
					+ "2: Mostrar una la frase encriptada.\n"
					+ "3: Desencriptar la frase encriptada.\n"
					+ "4: Encriptar un Coche.\n"
					+ "5: Mostrar los valores encriptados del coche.\n"
					+ "6: Desencriptar los valores del coche.\n"
					+ "7: Salir.\n");
			menuValue = sc.nextInt();
			switch(menuValue) {
			case 1:
				sc.nextLine();
				System.out.println("Dame la frase que tu quieras codificar.");
				String toEncript = sc.nextLine();
				System.out.println("Como quieres hacerlo.\n"
						+ "1: Codificacion Simetrica.\n"
						+ "2: Codificacion Asimetrica.\n");
				int metEncript = sc.nextInt();
				if(metEncript == 1) {
					SimetricEncriptator(toEncript);
				}else {
					AsimetricEncriptator(toEncript);
				}
				break;
			case 2:
				showCodinMessage();
				break;
			case 3:
				ToDecode();
				break;
			case 4:
				carMenu();
				break;
			case 5:
				showCodinMessage();
				break;
			case 6:
				ToDecode();
				break;
			case 7:
				System.out.println("Sayonara Baby.");
				break;
			default:
				System.out.println("Debes elegir uno de los valores correctos.\n");
				
			}
			
			
		}
		
	}
	public static void carMenu() {
	
		System.out.println("Dame los valores que te vaya pidiendo.");
		System.out.println("Dame la Matricula: ");
		String readRegistration = sc.next();
		System.out.println("Dame la marca: ");
		String readMark = sc.next();
		System.out.println("Dame la modelo: ");
		String readModel = sc.next();
		System.out.println("Dame la precio: ");
		Double readPrice = sc.nextDouble();
		Car car = new Car(readRegistration, readModel, readMark, readPrice);
		System.out.println("Como quieres hacerlo.\n"
				+ "1: Codificacion Simetrica.\n"
				+ "2: Codificacion Asimetrica.\n");
		int metEncript = sc.nextInt();
		if(metEncript == 1) {
			SimetricEncriptator(car.toString());
		}else {
			AsimetricEncriptator(car.toString());
		}
		
	}
	public static void AsimetricEncriptator(String stringValue) {
		asimetricEncriptator = new AsimetricEncriptController(stringValue);
		howEncript = "asime";
	}
	public static void SimetricEncriptator(String StringValue) {
		simetricEncriptator = new SimetricEncriptController(StringValue);
		howEncript = "sime";
	}
	public static void ToDecode() {
		if(howEncript.equals("asime")) {
			System.out.println(asimetricEncriptator.DecodeString());
		}else if(howEncript.equals("sime")) {
			System.out.println(simetricEncriptator.DecodeString());
		}else {
			System.out.println("No existe ningun mensaje codificado.");
		}
	}
	public static void showCodinMessage() {
		if(howEncript.equals("asime")) {
			System.out.println(asimetricEncriptator.getValueCodification());
		}else if(howEncript.equals("sime")) {
			System.out.println(simetricEncriptator.getValueCodification());
		}else {
			System.out.println("No existe ningun mensaje codificado.");
		}
	}

}

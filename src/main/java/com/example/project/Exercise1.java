package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.convertirBaseGabriel(n));			
		}
	}

	public String convertirBaseGabriel(int a) {

		String numCadena = Integer.toString(a);
		int posDig = numCadena.length();
		int conversion=0;
		
		if(baseGabriel(numCadena) == true) {
			for(int i=0; i<numCadena.length(); i++) {
				conversion = conversion + Integer.parseInt(numCadena.substring(i, i+1))*((int)Math.pow(2, posDig)-1);
				posDig--;
			}
		}
		else {
			return "El numero proporcionado no esta en base Gabriel.";
		}
		
		return Integer.toString(conversion);
	}

	public static boolean baseGabriel(String num) {
		int i=0;
		int cantDos = 0;
		while(i<num.length()) {
			if(Integer.parseInt(num.substring(i, i+1)) > 2) {
				break;
			}
			if(num.substring(i, i+1).equalsIgnoreCase("2")) {
				cantDos++;
			}
			if(cantDos > 1) {
				break;
			}
			i++;
			
		}
		if(i == num.length()) {
			if(Integer.toString(invertir(num)).substring(0, 1).equalsIgnoreCase("2") || binario(num) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static int invertir(String num) {
		String nuevaCad = "";
		int tamNum = num.length();
		for(int i=0; i<num.length(); i++) {
			nuevaCad = nuevaCad + num.subSequence(tamNum-1, tamNum);
			tamNum--;
		}
		return Integer.parseInt(nuevaCad);
	}
	
	public static boolean binario(String num) {
		int i=0;
		while(i < num.length()) {
			if(num.substring(i, i+1).equalsIgnoreCase("1") || num.substring(i, i+1).equalsIgnoreCase("0")) {
				i++;
			}
			else {
				break;
			}
		}
		if(i == num.length()) {
			return true;
		}
		return false;
	}

}

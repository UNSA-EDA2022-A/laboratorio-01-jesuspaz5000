package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

            int a [] = new int [7];
            for(int i = 0; i < 7; i++){
                int n = sc.nextInt();
                a[i] = n;
            }
			
			System.out.println(obj.getMenorNumeroSaltos(a));			
		}
	}

	public Integer getMenorNumeroSaltos(int a []) {
		
		int pos = 50;
		int saltos = 0;
		
		if(posible(a) == true) {
			int i=0;
			while(i<a.length) {
				if(a[i] < pos) {
					i++;
				}
				else if(a[i] > pos){
					pos = a[i-1];
					pos = pos + 50;
					saltos++;
				}
				else {
					pos = a[i];
					pos = pos + 50;
					saltos++;
				}
			}
			if((pos-a[a.length-1]) != 50) {
				return saltos+1;
			}
			else {
				return saltos;
			}
		}
		
		return -1;
	}

	public static boolean posible(int[] posiciones) {
		
		for(int i=0; i<posiciones.length-1; i++) {
			if((posiciones[i+1] - posiciones[i]) > 50) {
				return false;
			}
		}
		
		return true;
	}

}
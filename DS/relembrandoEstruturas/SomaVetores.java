/*
	Ler um vetor A de 10 posi��es de inteiro, ler um vetor B com 10 posi��es de inteiro e apresentar um vetor C
	que ser� a soma de A com B.
 */

package relembrandoEstruturas;

import java.util.Scanner;

public class SomaVetores {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = 10, a[], b[], c[], i;
		
		a = new int [n];
		b = new int [n];
		c = new int [n];
		
		for (i = 0; i < n; i++) {
			System.out.printf("Informe o valor da %d� posi��o do vetor A: ", (i + 1));
			a[i] = in.nextInt();
		}
		
		for (i = 0; i < n; i++) {
			System.out.printf("Informe o valor da %d� posi��o do vetor B: ", (i + 1));
	  	    b[i] = in.nextInt();
			c[i] = a[i] + b[i];
		}

		System.out.print("\nVetor A: ");
		for (i = 0; i < n; i++) {
			if (i == 0) {
				System.out.print("[" + a[i] + " ");
			} else if (i == n - 1) {
				System.out.print(a[i] + "]");
			} else {
				System.out.print(a[i] + " ");
			}
		}
		
		System.out.print("\nVetor B: ");
		for (i = 0; i < n; i++) {
			if (i == 0) {
				System.out.print("[" + b[i] + " ");
			} else if (i == n - 1) {
				System.out.print(b[i] + "]");
			} else {
				System.out.print(b[i] + " ");
			}
		}
		
		System.out.print("\nVetor C: ");
		for (i = 0; i < n; i++) {
			if (i == 0) {
				System.out.print("[" + c[i] + " ");
			} else if (i == n - 1) {
				System.out.print(c[i] + "]");
			} else {
				System.out.print(c[i] + " ");
			}
		}
	}
}

package com.airwallex;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			calculator.calc(scan.nextLine().trim());
		}
	}

}


package com.airwallex.test;

import com.airwallex.Calculator;

public class Example6 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calc("1 2 3 4 5");
		calculator.calc("*");
		calculator.calc("clear 3 4 -");
	}

}

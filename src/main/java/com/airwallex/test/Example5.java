package com.airwallex.test;

import com.airwallex.Calculator;

public class Example5 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calc("7 12 2 /");
		calculator.calc("*");
		calculator.calc("4 /");
	}

}

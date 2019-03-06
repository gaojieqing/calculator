package com.airwallex.test;

import com.airwallex.Calculator;

public class Example4 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calc("5 4 3 2");
		calculator.calc("undo undo *");
		calculator.calc("5 *");
		calculator.calc("undo");
	}

}

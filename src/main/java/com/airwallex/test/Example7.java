package com.airwallex.test;

import com.airwallex.Calculator;

public class Example7 {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calc("1 2 3 4 5");
		calculator.calc("* * * *");
	}

}

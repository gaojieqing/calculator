package com.airwallex.operator.impl;

import com.airwallex.operator.BinaryOperator;

import java.math.BigDecimal;

/**
 * 除法操作
 *
 * @author Gao Jieqing
 */
public class DivideOperator implements BinaryOperator {

	@Override
	public BigDecimal calc(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal1.divide(bigDecimal2, 15, BigDecimal.ROUND_DOWN);
	}

}
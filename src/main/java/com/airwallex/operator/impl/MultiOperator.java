package com.airwallex.operator.impl;

import com.airwallex.operator.BinaryOperator;

import java.math.BigDecimal;

/**
 * 乘法操作
 *
 * @author Gao Jieqing
 */
public class MultiOperator implements BinaryOperator {

	@Override
	public BigDecimal calc(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal1.multiply(bigDecimal2);
	}

}
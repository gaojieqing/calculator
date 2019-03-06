package com.airwallex.operator.impl;

import com.airwallex.operator.BinaryOperator;

import java.math.BigDecimal;

/**
 * 减法操作
 *
 * @author Gao Jieqing
 */
public class SubOperator implements BinaryOperator {

	@Override
	public BigDecimal calc(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal1.subtract(bigDecimal2);
	}

}

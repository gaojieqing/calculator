package com.airwallex.operator.impl;

import com.airwallex.operator.BinaryOperator;

import java.math.BigDecimal;

/**
 * 加法操作
 *
 * @author Gao Jieqing
 */
public class AddOperator implements BinaryOperator {

	@Override
	public BigDecimal calc(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal1.add(bigDecimal2);
	}

}

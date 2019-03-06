package com.airwallex.operator.impl;

import com.airwallex.operator.UnaryOperator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 开平方操作
 *
 * @author Gao Jieqing
 */
public class SqrtOperator implements UnaryOperator {

	@Override
	public BigDecimal calc(BigDecimal bigDecimal) {
		BigDecimal two = BigDecimal.valueOf(2.0);
		int precision = 100;
		MathContext mc = new MathContext(precision, RoundingMode.DOWN);
		if (BigDecimal.ZERO.compareTo(bigDecimal) != 0) {
			BigDecimal tmp = bigDecimal;
			int count = 0;
			while (count < precision) {
				tmp = (tmp.add(bigDecimal.divide(tmp, mc))).divide(two, mc);
				count++;
			}
			return tmp;
		}
		return BigDecimal.ZERO;
	}

}

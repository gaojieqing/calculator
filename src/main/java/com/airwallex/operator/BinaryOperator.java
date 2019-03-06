package com.airwallex.operator;

import java.math.BigDecimal;

/**
 * 二元操作
 *
 * @author Gao Jieqing
 */
public interface BinaryOperator extends Operator {

	BigDecimal calc(BigDecimal bigDecimal1, BigDecimal bigDecimal2);

}

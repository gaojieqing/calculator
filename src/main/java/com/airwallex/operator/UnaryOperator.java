package com.airwallex.operator;

import java.math.BigDecimal;

/**
 * 一元操作
 *
 * @author Gao Jieqing
 */
public interface UnaryOperator extends Operator {

	BigDecimal calc(BigDecimal bigDecimal);

}

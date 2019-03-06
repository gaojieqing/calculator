package com.airwallex;

import com.airwallex.operator.BinaryOperator;
import com.airwallex.operator.Operator;
import com.airwallex.operator.Operators;
import com.airwallex.operator.UnaryOperator;
import com.airwallex.operator.impl.ClearOperator;
import com.airwallex.operator.impl.UndoOperator;
import com.airwallex.utils.NumberUtils;
import com.airwallex.utils.StringSplitUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

/**
 * 计算器
 *
 * @author Gao Jieqing
 */
public class Calculator {

	private Stack<BigDecimal> stack;

	private StringBuilder history;

	private static final String WHITESPACE = " ";

	private DecimalFormat df = new DecimalFormat("0.##########");

	public Calculator() {
		stack = new Stack<>();
		history = new StringBuilder();
		df.setRoundingMode(RoundingMode.DOWN);
	}

	public synchronized void calc(String text) {
		calc(text, true);
	}

	protected synchronized void calc(String text, boolean ifPrintStack) {
		if (text != null && text.length() > 0) {
			List<String> list = StringSplitUtils.spiltToList(text);
			if (list != null && list.size() > 0) {
				int position = 0;
				for (int i = 0; i < list.size(); i++) {
					String str = list.get(i);
					position = text.indexOf(str, position) + 1;
					if (NumberUtils.isNumber(str)) {
						// 如果是数字，则入栈
						stack.push(new BigDecimal(str));
						history.append(WHITESPACE).append(str);
					} else {
						// 如果是操作，则进行相关操作
						Operator operator = Operators.getOperator(str);
						if (operator == null) {
							printWarning(str, position, "no such operator");
							break;
						}
						if (operator instanceof UnaryOperator) {
							// 如果是一元操作，则从栈里取一个元素进行运算
							if (stack.size() < 1) {
								// 如果栈内元素不足一个，则打印异常
								printWarning(str, position, "insucient parameters");
								break;
							}
							history.append(WHITESPACE).append(str);
							BigDecimal bigDecimal = stack.pop();
							try {
								BigDecimal result = ((UnaryOperator) operator).calc(bigDecimal);
								stack.push(result);
							} catch (Exception e) {
								stack.push(bigDecimal);
								printWarning(str, position, e.getMessage());
								break;
							}
						} else if (operator instanceof BinaryOperator) {
							// 如果是二元操作，则从栈里取两个元素进行运算
							if (stack.size() < 2) {
								// 如果栈内元素不足两个，则打印异常
								printWarning(str, position, "insucient parameters");
								break;
							}
							history.append(WHITESPACE).append(str);
							BigDecimal bigDecimal1 = stack.pop();
							BigDecimal bigDecimal2 = stack.pop();
							try {
								BigDecimal result = ((BinaryOperator) operator).calc(bigDecimal2, bigDecimal1);
								stack.push(result);
							} catch (Exception e) {
								stack.push(bigDecimal2);
								stack.push(bigDecimal1);
								printWarning(str, position, e.getMessage());
								break;
							}
						} else if (operator instanceof UndoOperator) {
							// 如果是撤销操作，删除最后一次操作
							if (history.length() == 0) {
								printWarning(str, position, "out of range");
								break;
							}
							String tmp = history.substring(0, history.lastIndexOf(WHITESPACE));
							clear();
							calc(tmp, false);
						} else if (operator instanceof ClearOperator) {
							// 如果是清空操作，则清空栈内数据
							clear();
						}
					}
				}
			}
			if (ifPrintStack) {
				printHistory();
				printStack();
			}
		}
	}

	protected synchronized void clear() {
		stack = new Stack<>();
		history = new StringBuilder();
	}

	protected void printWarning(String str, Integer position, String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("operator ").append(str)
				.append(" (position: ").append(position).append("): ")
				.append(message);
		System.out.println(sb.toString());
	}

	protected void printStack() {
		StringBuilder sb = new StringBuilder();
		sb.append("stack:");
		for (int i = 0; i < stack.size(); i++) {
			sb.append(WHITESPACE).append(df.format(stack.get(i)));
		}
		System.out.println(sb.toString());
	}

	protected void printHistory() {
//		System.out.println("history :" + history.toString());
	}

}

package com.airwallex.operator;

import com.airwallex.operator.impl.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作工厂类
 *
 * @author Gao Jieqing
 */
public class Operators {

	private static Map<String, Operator> cachedOperator;

	static {
		Map<String, Operator> tmpMap = new HashMap<>();
		tmpMap.put("+", new AddOperator());
		tmpMap.put("-", new SubOperator());
		tmpMap.put("*", new MultiOperator());
		tmpMap.put("/", new DivideOperator());
		tmpMap.put("sqrt", new SqrtOperator());
		tmpMap.put("undo", new UndoOperator());
		tmpMap.put("clear", new ClearOperator());
		cachedOperator = Collections.unmodifiableMap(tmpMap);
	}

	public static Operator getOperator(String operator) {
		return cachedOperator.get(operator);
	}

}

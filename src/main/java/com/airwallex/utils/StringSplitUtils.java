package com.airwallex.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitUtils {

	public static List<String> spiltToList(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		String[] array = str.trim().split(" ");
		return Arrays.asList(array);
	}
}

package com.lg.zzq.bia.web.common.util;

import java.util.List;
import java.util.StringTokenizer;

import javassist.bytecode.Descriptor.Iterator;

public class UtilFuns {

	/**
	 * 字符串是否是为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		try {
			if (str == null || str.equals("null") || str.equals("")) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return true;
		}
	}

	/* 删除最后1个字符 */
	public static String delLastChar(String s) {
		try {
			if (s.length() > 0) {
				s = s.substring(0, s.length() - 1);
			}
		} catch (Exception e) {
			return "";
		}
		return s;
	}
	
	
	
	
	

	public static String newLine() {
		return System.getProperty("line.separator");
	}

	/* 验证数组是否为空 */
	public static boolean arryValid(Object[] objects) {
		// 不为空，返回true
		if (objects != null && objects.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* 验证list是否为空 */
	public static boolean listValid(List list) {
		// 不为空，返回true
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* 获取年龄 */
	public static int age(String dateStart, String dateEnd) throws Exception {
		int yearStart = Integer.parseInt(dateStart.substring(0, 4));
		int yearEnd = Integer.parseInt(dateEnd.substring(0, 4));

		return yearEnd - yearStart;
	}

	/* 是否是奇数 */
	public static boolean isOdd(int i) {
		if (i % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}

	/* 截取字符串 */
	public static String cutStr(String str, int len) {
		try {
			str = str.substring(0, len);
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
		return str;
	}

	/* 返回固定长度串，空白地方用空格填充 */
	public static String fixSpaceStr(String str, int len) {
		// TODO 有疑问
		StringBuffer sBuf = new StringBuffer();
		try {
			if (str.length() > len) {
				return str;
			} else {
				sBuf.append(str);
				for (int i = 0; i < (len - str.length()); i++) {
					sBuf.append(" ");
				}
				return sBuf.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}

	public static String fixSpaceStr(int number, int len) {
		return fixSpaceStr(String.valueOf(number), len);
	}

	/* 前缀空格 */
	public static String prefixSpaceStr(String str, int len) {
		// TODO 此处也有疑问
		StringBuffer sBuf = new StringBuffer();
		try {
			if (str.length() > len) {
				return str;
			} else {
				for (int i = 0; i < (len - str.length()); i++) {
					sBuf.append(" ");
				}
				sBuf.append(str);
				return sBuf.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
	}

	/* 截取字符串过长则加省略号 */
	public static String suspensionStr(String str, int len) {
		try {
			str = str.substring(0, len) + "...";
		} catch (Exception e) {
			e.printStackTrace();
			return str;
		}
		return str;
	}

	/* url get方式传参 */
	public static String joinUrlParameter(List<String> sList) {
		StringBuffer sBuf = new StringBuffer();
		for (Iterator it = (Iterator) sList.iterator(); it.hasNext();) {
			sBuf.append("&").append(it.next()).append("=").append(it.next());
		}
		return sBuf.substring(1, sBuf.length()); // 去除&符号
	}

	/*
	 * splitStr 返回分割后的数组
	 * 
	 * @param str 设置返回系统时间样式
	 * 
	 * @param splitFlag 设置分割字符
	 * 
	 * @return
	 */
	public static String[] splitStr(String str, String splitFlag) {
		int i = 0;
		try {
			StringTokenizer st = new StringTokenizer(str, splitFlag);
			String tokens[] = new String[st.countTokens()];

			while (st.hasMoreTokens()) {
				tokens[i] = st.nextToken();
				i++;
			}
			return tokens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* 实现多个关键字的查询 */
	public String[] splitFindStr(String str) {
		if (str == null) {
			return null;
		}
		String[] aStr = null;
		str = str.replaceAll(",", " ");
		str = str.replaceAll("，", " ");
		aStr = this.splitStr(str, " ");

		return aStr;
	}

	/* 阶梯函数 */
	public static String[] splitStair(String str, String splitFlag) {
		try {
			String[] temp = splitStr(str, splitFlag);
			for (int i = 1; i < temp.length; i++) {
				temp[i] = temp[i - 1] + splitFlag + temp[i];
			}
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * splitStr 功能：将数组合并为一个字符串
	 * 
	 * @param aStr
	 *            要合并数组
	 * @param splitFlag
	 *            设置分割字符
	 * @return
	 */
	public static String joinStr(String[] aStr, String splitFlag) {
		StringBuffer sBuffer = new StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(aStr[i]).append(splitFlag);
			}
			sBuffer.delete(sBuffer.length() - 1, sBuffer.length()); // 去掉最后的分隔符
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	/* 链接,但中间无链接符号 */
	public static String joinStr(String[] aStr) {
		StringBuffer sBuffer = new StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(aStr[i]);
			}
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	/**
	 * 将数组合并为一个字符串
	 * 
	 * @param aStr
	 * @param sPrefix
	 *            数组元素加的前缀
	 * @param sSuffix
	 *            数组元素加的后缀
	 * @param splitFlag
	 *            设置分割字符
	 * @return
	 */
	public static String joinStr(String[] aStr, String sPrefix, String sSuffix, String splitFlag) {
		StringBuffer sBuffer = new StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix).append(splitFlag);
			}
			sBuffer.delete(sBuffer.length() - splitFlag.length(), sBuffer.length()); // 去掉最后的分隔符
																						// SplitFlag
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	/* 返回用于in查询的串 'x','y' */
	public static String joinInStr(String[] aStr) {
		StringBuffer sBuffer = new StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append("'").append(aStr[i]).append("'").append(",");
			}
			sBuffer.delete(sBuffer.length() - 1, sBuffer.length());
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	/* 链接,但中间无链接符号 */
	public static String joinStr(String[] aStr, String sPrefix, String sSuffix) {
		StringBuffer sBuffer = new StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix);
			}
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	/* 链接len(s)个symbol符号 */
	public static String joinStr(String s, String symbol) {
		StringBuffer sBuf = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			sBuf.append(symbol);
		}
		return sBuf.toString();
	}

}

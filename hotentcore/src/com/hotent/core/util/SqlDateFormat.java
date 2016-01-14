package com.hotent.core.util;

import com.hotent.core.table.SqlTypeConst;

/**
 * SQL格式转换。
 * @author ray
 *
 */
public class SqlDateFormat {

	/**
	 * 转换日期格式。
	 * @param format
	 * @param value
	 * @param dbType
	 * @return
	 */
	public static String convertDateFormat(String format,String value,String dbType){
		if(SqlTypeConst.ORACLE.equals(dbType)){
			return convertToOracle(format,value);
		}
		else if(SqlTypeConst.MYSQL.equals(dbType)){
			return convertToMySql(format,value);
		}
		else if(SqlTypeConst.SQLSERVER.equals(dbType)){
			return convertToMsSql(format,value);
		}
		return value;
	}
	
	/**
	 * 转换oracle格式。
	 * @param format
	 * @param value
	 * @return
	 */
	private static String convertToOracle(String format,String value){
		if(StringUtil.isEmpty(format)){
			format="yyyy-MM-dd";
		}
		format=format.replace("HH", "hh24");
		format=format.replace("mm", "mi");
		String rtn=" TO_DATE('" +value +"','" +format+"')" ;
		
		return rtn;
	}
	
	/**
	 * <pre>
	* %S, %s 两位数字形式的秒（ 00,01, . . ., 59）
	%i 两位数字形式的分（ 00,01, . . ., 59）
	%H 两位数字形式的小时，24 小时（00,01, . . ., 23）
	%h, %I 两位数字形式的小时，12 小时（01,02, . . ., 12）
	%k 数字形式的小时，24 小时（0,1, . . ., 23）
	%l 数字形式的小时，12 小时（1, 2, . . ., 12）
	%T 24 小时的时间形式（h h : m m : s s）
	%r 12 小时的时间形式（hh:mm:ss AM 或hh:mm:ss PM）
	%p AM 或P M
	%W 一周中每一天的名称（ S u n d a y, Monday, . . ., Saturday）
	%a 一周中每一天名称的缩写（ Sun, Mon, . . ., Sat）
	%d 两位数字表示月中的天数（ 00, 01, . . ., 31）
	%e 数字形式表示月中的天数（ 1, 2， . . ., 31）
	%D 英文后缀表示月中的天数（ 1st, 2nd, 3rd, . . .）
	%w 以数字形式表示周中的天数（ 0 = S u n d a y, 1=Monday, . . ., 6=Saturday）
	%j 以三位数字表示年中的天数（ 001, 002, . . ., 366）
	% U 周（0, 1, 52），其中Sunday 为周中的第一天
	%u 周（0, 1, 52），其中Monday 为周中的第一天
	%M 月名（J a n u a r y, February, . . ., December）
	%b 缩写的月名（ J a n u a r y, February, . . ., December）
	%m 两位数字表示的月份（ 01, 02, . . ., 12）
	%c 数字表示的月份（ 1, 2, . . ., 12）
	%Y 四位数字表示的年份
	%y 两位数字表示的年份
	%% 直接值“%”
		</pre>
	 * @param format
	 * @param value
	 * @return
	 */
	private static String convertToMySql(String format,String value){
		if(StringUtil.isEmail(format)){
			format="%Y-%m-%d";
		}
		format=format.replace("yyyy", "%Y");
		format=format.replace("MM", "%m");
		format=format.replace("dd", "%d");
		format=format.replace("HH", "%H");
		format=format.replace("hh", "%h");
		format=format.replace("mm", "%i");
		format=format.replace("ss", "%s");
		String rtn=" STR_TO_DATE('" +value +"','" +format+"')" ;
		
		return rtn;
	}
	
	/**
	 * 将字符串转成日期类型。
	 * @param format
	 * @param value
	 * @return
	 */
	private static String convertToMsSql(String format,String value){
		String rtn=" cast('"+value+"' as datetime) ";
		return rtn;
	}
	

}

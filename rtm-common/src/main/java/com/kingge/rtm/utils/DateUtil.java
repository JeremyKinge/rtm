package com.kingge.rtm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	//clean install
    //日期格式，年份，例如：2004，2008
    public static final String DATE_FORMAT_YYYY = "yyyy";
    
    //日期格式，年份和月份，例如：200707，200808
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    
    //日期格式，年月日，例如：20050630，20080808
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    
    //日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    
    //日期格式，年月日时分秒，例如：20001230120000，20080808200808
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    
    //日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开，
    //例如：2008-08-08 20:08:08
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    
    //例如：2008-08-08 20:08
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";
    
    //日期格式，年月日，用横杠分开，例如：2006/12/25
    public static final String DATE_FORMAT_YYYY_MM_DD_format2 = "yyyy/MM/dd";
    
    //日期格式，年月日时分秒，例如：2000/12/30 12:00:00
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS_format2 = "yyyy/MM/dd HH:mm:ss";
    
    private static SimpleDateFormat dataFormat = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
    
    public static SimpleDateFormat getDataFormat() {
		return dataFormat;
	}
	/**
     * 获取时间 时分秒
     * 
     * @param date
     * 			if date == null,则date为当前时间
     * @param type
     * 			0 hhmmss
     *  		1 hh:mm:ss
     * @return
     */
    public static String getTime(Date date,int type){
    	if(date == null)
    		date = new Date();
    	String str = "";
        switch(type){
        	case 0:
        		if(date.getHours()<10)
        			str = "0"+String.valueOf(date.getHours());
        		else
        			str = String.valueOf(date.getHours());
        		if(date.getMinutes()<10)
        			str =str+ "0"+String.valueOf(date.getMinutes());
        		else
        			str = str+String.valueOf(date.getMinutes());
        		if(date.getSeconds()<10)
        			str =str+ "0"+String.valueOf(date.getSeconds());
        		else
        			str = str+String.valueOf(date.getSeconds());
//        		str = String.valueOf(date.getHours())+String.valueOf(date.getMinutes())+String.valueOf(date.getSeconds());
        		break;
        	case 1:
        		if(date.getHours()<10)
        			str = "0"+String.valueOf(date.getHours())+":";
        		else
        			str = String.valueOf(date.getHours())+":";
        		if(date.getMinutes()<10)
        			str = str+"0"+String.valueOf(date.getMinutes())+":";
        		else
        			str = str+String.valueOf(date.getMinutes())+":";
        		if(date.getSeconds()<10)
        			str = str+"0"+String.valueOf(date.getSeconds());
        		else
        			str = str+String.valueOf(date.getSeconds());
//        		str = String.valueOf(date.getHours())+":"+String.valueOf(date.getMinutes())+":"+String.valueOf(date.getSeconds());
        		break;
        } 
        return str;
    }
    /**
    * 字符串转换为日期
    * @author dingyongli
    * @return String
    * @throws 
    */
    public static Date strToDate(String strDate, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try{
        	if(strDate!=null&&!"".equals(strDate)){
        		date = dateFormat.parse(strDate);
        	}
        }catch(ParseException e){
            e.printStackTrace();
            //Logger.getLogger(DateUtil.class).debug(e.getMessage());
        }
        return date;
    }
    
    
    public static void main(String[] args) {
		String str = "2014-4-11 12";
		String str1 = "yyyy-MM-dd HH";
	}

    /**
    * 字符串转换为日期时间
    * @author dingyongli
    * @return String
    * @throws 
    */
    public static Date strToDateTime(String strDateTime, String fromat){
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(fromat);
        Date dateTime = null;
        try{
        	if(strDateTime!=null&&!"".equals(strDateTime)){
        		dateTime = dateTimeFormat.parse(strDateTime);
        	}
        }catch(ParseException e){
            e.printStackTrace();
            //Logger.getLogger(DateUtil.class).debug(e.getMessage());
        }
        return dateTime;
    }

    /**
    * 日期转换为字符串
    * @author dingyongli
    * @return String
    * @throws 
    */
    public static String dateToStr(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if(null==date) return null;
        return dateFormat.format(date);
    }

    /**
    * 日期时间转换为字符串
    * @author dingyongli
    * @return String
    * @throws 
    */    
    public static String dateTimeToStr(Date date, String format){
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format); 
        return dateTimeFormat.format(date);
    }
    
    /**
    * 得到当天的最后时间,today是字符串类型"yyyy-mm-dd",
    * 返回是日期类型"yyyy-mm-dd 23:59:59"
    * @author dingyongli
    * @return Date
    * @throws 
    */    
    public static Date getTodayLastTime(String today){
        String todayLastTime = today + " 23:59:59";
        return strToDateTime(todayLastTime,DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);        
    }    
    
    /**
     * 得到当天的最后时间
     * @param date
     * @return
     */
    public static Date getToDayLastTime(Date date){
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.AM_PM,Calendar.AM);
		calendar.set(Calendar.HOUR,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		return calendar.getTime();
    }
    
    /**
     * 得到当天的最早时间
     * @param date
     * @return
     */
    public static Date getToDayBeginTime(Date date){
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.AM_PM,Calendar.AM);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
    }
    
	/**
	 * 比较2个时间的先后
	 * @param source 待比较的时间。
	 * @param target 
	 * @return 当 source < target = true, else false
	 */
	public static boolean compare(Date source, Date target){
		return source.before(target);
	}
	
	/**
	 * 当前的时间比较格式为 DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS 和 DATE_FORMAT_YYYY_MM_DD
	 * @param source
	 * @param target
	 * @return   source 在 target 之后返回 false。否则返回true
	 * @throws ParseException
	 */
	public static boolean compare(String source, String target) throws Exception{
		if(source.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")){//处理YYYY-MM-HH格式的时间
			SimpleDateFormat dataFormat1 = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
			Date s = dataFormat1.parse(source);
			Date t = dataFormat1.parse(target);
			return s.before(t);
		}
		else if(source.matches("^\\d{4}-\\d{2}-\\d{2}$")){
			SimpleDateFormat dataFormat2 = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
			Date s = dataFormat2.parse(source);
			Date t = dataFormat2.parse(target);
			return s.before(t);
		}else{
			throw new Exception("未知时间格式");
		}
		
	}
	
	/**
	 * 求2个时间段之间的间隔
	 * @param bdate
	 * @param edate
	 * 			edate = "" or null时间， edate的值为目前时间
	 * @param type
	 * 			type = 1:时间段间的天数,type = 2:2时间段间的小时数,type = 3:时间段间的分钟数 4:时间段间的秒数 5:时间段间的毫秒数
	 * @return
	 */
	public static long getDateLong(String bdate,String edate,int type){
//		Logger.getLogger(DateUtil.class).debug(bdate+" |  "+edate);
		if(bdate == null || bdate.equals("")) return 0L;
		long result = 0L;
		long bt =  dataFormat.getCalendar().getTimeInMillis();
		long et = 0L;
		if(edate != null && !edate.equals("")){
			et =  dataFormat.getCalendar().getTimeInMillis();
		}else{
			et = Calendar.getInstance().getTimeInMillis();//当天
		}
		switch(type){
			case 1:
				result =  ((et-bt)/(1000*60*60*24));
				break;
			case 2:
				result =  ((et-bt)/(1000*60*60));
				break;
			case 3:
				result =  ((et-bt)/(1000*60));
				break;
			case 4:
				result =  ((et-bt)/(1000));
				break;
			case 5:
				result =  (et-bt);
				break;
		}
		
		return result;
	}
	
	public static long getDateLong(Date bdate,Date edate,int type){
		if(bdate == null) return 0L;
		return edate == null?getDateLong(getDataFormat().format(bdate),null,type):getDateLong(getDataFormat().format(bdate),getDataFormat().format(edate),type);
	}
	
	/**
	 * 计算 time 的下n天
	 * @param time
	 * @return
	 */
	public static String nextDate(String time,int nday){
		Calendar now_Time = Calendar.getInstance();
        DateFormat df=new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        try {
            now_Time.setTime(df.parse(time));
        } catch (ParseException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        now_Time.add(Calendar.DATE,nday);
        SimpleDateFormat sdNowDate = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        return sdNowDate.format(now_Time.getTime());

	}
	
	/**
	 * 计算 time 的下n天
	 * @param time
	 * @return
	 */
	public static Date nextDate(Date time,int nday){
		Calendar now_Time = Calendar.getInstance();
        now_Time.setTime(time);
        now_Time.add(Calendar.DATE,nday);
        return now_Time.getTime();
	}
	public static Date nextMinute(Date time,int minutes){
		Calendar now_Time = Calendar.getInstance();
		now_Time.setTime(time);
		now_Time.add(Calendar.MINUTE,minutes);
		return now_Time.getTime();
	}
	
	/**
	 * 时间运算，
	 * 如某时间经过多少分或多少天后的时间
	 *  某时间前几分或几小时或几天的时间 
	 * @param time
	 * @param calcuate  计算数
	 * @param type 计算类型，0:分为单位;1:时为单位;2天为单位;3月为单位
	 * @param addOrdec;运算类型 1:加 ; 2:减 该参数咱不支持，
	 * @return 返回的日期格式是
	 */
	public static String nextDate(String time,int calcuate,int type,int addOrdec){
		Calendar now_Time = Calendar.getInstance();
        DateFormat df=new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        try {
            now_Time.setTime(df.parse(time));
        } catch (ParseException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        if(addOrdec == 2)
        	calcuate = 0-calcuate;
        switch(type){
        	case 0:
        		now_Time.add(Calendar.MINUTE, calcuate);
        		break;
        	case 1:
        		now_Time.add(Calendar.HOUR_OF_DAY, calcuate);
        		break;
        	case 2:
        		now_Time.add(Calendar.DATE,calcuate);
        		break;
        	case 3:
        		now_Time.add(Calendar.MONTH, calcuate);
        		break;
        }
        SimpleDateFormat sdNowDate = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        return sdNowDate.format(now_Time.getTime());

	}
	/**
	 * 获取年份
	 */
	public static int getYear(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int year = cal.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 获取月份
	 */
	public static int getMonth(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}
	/**
	 * 获取本月第几日
	 */
	public static int getDay(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int day = cal.get(Calendar.DATE);
		return day;
	}
	/**
	 * 获取小时
	 */
	public static int getHour(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	/**
	 * 获取分钟
	 */
	public static int getMinute(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int minute = cal.get(Calendar.MINUTE);
		return minute;
	}
	/**
	 * 获取秒钟
	 */
	public static int getSecond(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int second = cal.get(Calendar.SECOND);
		return second;
	}
	/**
	 * 获取星期几 星期天=0...星期六=6
	 */
	public static int getWeek(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int week = cal.get(Calendar.DAY_OF_WEEK)-1;
		return week;
	}

	/**
	 * 比较tg时间是否在strat到end时间段之间
	 * @param strat
	 * @param end
	 * @param tg
	 * @return 是返回true，否则 false
	 */
	public static boolean cmpDate(Date strat,Date end,Date tg){
		if(tg == null) return false;
		long tl = tg.getTime();
		return tl>=strat.getTime() && tl<= end.getTime();
	}

	/**
	 * 取第几季度，1-4,失败为－1
	 */
	public static int getJd(Date date){
	   	Calendar cal = Calendar.getInstance();
	   	cal.setTime(date);
	    int month = cal.get(Calendar.MONTH) + 1;
		if(month==1||month==2||month==3)
			return 1;
		if(month==4||month==5||month==6)
			return 2;
		if(month==7||month==8||month==9)
			return 3;
		if(month==10||month==11||month==12)
			return 4;
		return -1;
	}
	
	/**
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate){
		if(null==strDate) return null;
		if(strDate.matches("\\d{8}")){
			return strToDate(strDate, DATE_FORMAT_YYYYMMDD);
		}
		if(strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
			return strToDate(strDate, DATE_FORMAT_YYYY_MM_DD);
		}
		if(strDate.matches("\\d{14}")){
			return strToDate(strDate, DATE_TIME_FORMAT_YYYYMMDDHHMISS);
		}
		if(strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}:\\d{2}")){
			return strToDate(strDate, DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
		}
		if(strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}")){
			return strToDate(strDate, DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
		}
		if(strDate.matches("\\d{4}/\\d{1,2}/\\d{1,2} \\d{2}:\\d{2}:\\d{2}")){
			return strToDate(strDate, DATE_TIME_FORMAT_YYYYMMDDHHMISS_format2);
		}
		if(strDate.matches("\\d{4}/\\d{1,2}/\\d{1,2}")){
			return strToDate(strDate, DATE_FORMAT_YYYY_MM_DD_format2);
		}
		return null;
	}
}

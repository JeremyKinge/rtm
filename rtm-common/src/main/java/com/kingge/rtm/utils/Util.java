package com.kingge.rtm.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Util {
	
	public static void main(String[] args) throws Exception {
//		getMappingValues("com.base",Permission.class);
	}

	//百度计算2个GPS的距离,单位 米
	public static Double getDistance(Double[] point1,Double[] point2) {
		Double R = 6378.137; // 地球半径
		Double lat1 = point1[1] * Math.PI / 180.0;
		Double lng1 = point1[0] * Math.PI / 180.0;
		Double lat2 = point2[1] * Math.PI / 180.0;
		Double lng2 = point2[0] * Math.PI / 180.0;
		Double distance =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lng2-lng1))*R;
		return distance*1000;
	}

	public static boolean isNullOrEmpty(Object obj) {
		return null==obj || "".equals(obj.toString().trim()) || "null".equals(obj.toString().trim()) || "NULL".equals(obj.toString().trim());
	}
	public static boolean isNullOrEmpty(List list) {
		return null==list || list.size()<1;
	}

	public static Map<String,Map<Method,Object>> getMappingValues(String packageName,Class annotationClass) {
		String[] strs=packageName.split(",");
		Map<String,Map<Method,Object>> mainMap=new HashMap<String, Map<Method,Object>>();
		for (int i = 0; i < strs.length; i++) {
			 Map<String,Map<Method,Object>> map=getMappingValue(strs[i],annotationClass);
			 for (Map.Entry<String,Map<Method,Object>> entry : map.entrySet()) {
				 mainMap.put(entry.getKey(), entry.getValue());	
			}
		}
		return mainMap;
	}
	public static Map<String,Map<Method,Object>> getMappingValue(String packageName,Class  annotationClass) {
		// 第一个class类的集合
		List<Class<?>> classes = new ArrayList<Class<?>>();
		// 是否循环迭代
		boolean recursive = true;
		// 获取包的名字 并进行替换
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的文件
		Enumeration<URL> dirs;
		try {
			// 读取指定package下的所有class
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 判断是否以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				} else if ("jar".equals(protocol)) {
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    if (jarURLConnection != null) {
                        JarFile jarFile = jarURLConnection.getJarFile();
                        if (jarFile != null) {
                            Enumeration<JarEntry> jarEntries = jarFile.entries();
                            while (jarEntries.hasMoreElements()) {
                                JarEntry jarEntry = jarEntries.nextElement();
                                String jarEntryName = jarEntry.getName();
                                
                                if (jarEntryName.startsWith(packageDirName) && jarEntryName.endsWith(".class")) {
                                    String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                    try {
										classes.add(Thread.currentThread().getContextClassLoader().loadClass(className));
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
                                }
                            }

                        }
                    }
                }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String,Map<Method,Object>> mainMap=new HashMap<String, Map<Method,Object>>();
		for (Class<?> clazz : classes) {
			// 循环获取所有的类
			Class<?> c = clazz;
			// 获取类的所有方法
			Method[] methods = c.getMethods();
			Map<Method,Object> map=new HashMap<Method, Object>();
			for (Method method : methods) {
				// 获取RequestMapping注解
				Object annotation = method.getAnnotation(annotationClass);
				if (annotation != null) {
					map.put(method, annotation);
				}
			}
			if(map.size()>0)
				mainMap.put(clazz.getName(), map);
		}
		return mainMap;
	}

	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {

				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		if(null!=dirfiles){
			for (File file : dirfiles) {
				// 如果是目录 则继续扫描
				if (file.isDirectory()) {
					findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
				} else {
					// 如果是java类文件 去掉后面的.class 只留下类名
					String className = file.getName().substring(0, file.getName().length() - 6);
					try {
						// 添加到集合中去
						classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void setProperty(String name, Object value, Object entity) throws IllegalArgumentException, IllegalAccessException {
		Field[] fs = entity.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);// 设置些属性是可以访问的
			if (f.getName().equals(name)) {
				f.set(entity, value); // 给属性设值
				break;
			}
		}
	}

	/**
	 * 数字/字母随机数
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomString(int len) {
		java.util.Random rd = new java.util.Random();
		StringBuffer sb = new StringBuffer();
		int rdGet; // 取得随机数
		char ch;

		for (int i = 0; i < len; i++) {
			if (rd.nextInt(2) == 0) {
				// rdGet = Math.abs(rd.nextInt()) % 10 + 48; //
				// 产生48到57的随机数(0-9的键位值)

				int iTemp = rd.nextInt();
				if (iTemp != Integer.MIN_VALUE)// Integer.MIN_VALUE
					rdGet = Math.abs(iTemp) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
				else
					rdGet = Math.abs(Integer.MIN_VALUE) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
			} else {
				int iTemp = rd.nextInt();
				if (iTemp != Integer.MIN_VALUE)// Integer.MIN_VALUE
					rdGet = Math.abs(iTemp) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
				else
					rdGet = Math.abs(Integer.MIN_VALUE) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
			}
			ch = (char) rdGet;
			sb.append(ch);
		}

		return sb.toString();
	}

	/**
	 * 字母随机数
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomStringWithChar(int len) {
		java.util.Random rd = new java.util.Random();
		StringBuffer sb = new StringBuffer();
		int rdGet; // 取得随机数
		char ch;

		for (int i = 0; i < len; i++) {
			{
				int iTemp = rd.nextInt();
				if (iTemp != Integer.MIN_VALUE)// Integer.MIN_VALUE
					rdGet = Math.abs(iTemp) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
				else
					rdGet = Math.abs(Integer.MIN_VALUE) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
			}
			ch = (char) rdGet;
			sb.append(ch);
		}

		return sb.toString();
	}

	/**
	 * 数字随机数
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomStringWithNum(int len) {
		java.util.Random rd = new java.util.Random();
		StringBuffer sb = new StringBuffer();
		int rdGet; // 取得随机数
		char ch;

		for (int i = 0; i < len; i++) {
			{
				// rdGet = Math.abs(rd.nextInt()) % 10 + 48; //
				// 产生48到57的随机数(0-9的键位值)

				int iTemp = rd.nextInt();
				if (iTemp != Integer.MIN_VALUE)// Integer.MIN_VALUE
					rdGet = Math.abs(iTemp) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
				else
					rdGet = Math.abs(Integer.MIN_VALUE) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
			}
			ch = (char) rdGet;
			sb.append(ch);
		}

		return sb.toString();
	}

	// Create an 24 byte UUID
//	protected static int count = 0;

	/**
	 * 24UUID
	 * 
	 * @return UUID 24bit string
	 */
//	public static synchronized String getUUID() {
//		count++;
//		long time = System.currentTimeMillis();
//
//		String uuid = "G" + Long.toHexString(time) + Integer.toHexString(count) + Long.toHexString(Double.doubleToLongBits(Math.random()));
//
//		uuid = uuid.substring(0, 24).toUpperCase();
//
//		return uuid;
//	}

	public static String getPath() {
		return System.getProperty("user.dir") + "/";
	}

	public static String chgNull(String in) {
		String out = null;
		out = in;
		if (out == null || (out.trim()).equals("null")) {
			return "";
		} else {
			return out.trim();
		}
	}

	public static Double roundDouble(double val, int precision) {
		Double ret = null;
		try {
			double factor = Math.pow(10, precision);
			ret = Math.floor(val * factor + 0.5) / factor;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * 字符串转BigDecimal，非数字一律返回零
	 * 
	 * @param str
	 * @return BigDecimal
	 */
	public static BigDecimal stringToBigDecimal(String str) {
		try {
			return new BigDecimal(str);
		} catch (Exception e) {
			return new BigDecimal("0");
		}

	}

	/**
	 * 人民币元转换成分
	 * @param yuanStr
	 * @return
	 */
	public static String YuanToFen(String yuanStr) throws Exception{
		BigDecimal yuan=new BigDecimal(yuanStr);
		BigDecimal fen=yuan.multiply(new BigDecimal(100));
		String fenStr=String.valueOf(fen.intValue());
		return fenStr;
	}
}

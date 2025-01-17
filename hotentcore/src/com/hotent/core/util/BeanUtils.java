package com.hotent.core.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.ContextLoader;


/**
 * BeanUtils的等价类，只是将check exception改为uncheck exception
 * @author badqiu
 */
public class BeanUtils
{
	private static Logger logger=LoggerFactory.getLogger(BeanUtils.class);
	/**
	 * BeanUtil类型转换器
	 */
	public static ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
	
	private static BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean,new PropertyUtilsBean());

	static{
		convertUtilsBean.register(new DateConverter(), Date.class);
		convertUtilsBean.register(new LongConverter(null),Long.class);
	}
	
	
	
	/**
	 * 可以用于判断 Map,Collection,String,Array,Long是否为空
	 * @param o java.lang.Object.
	 * @return boolean.
	 */
	@SuppressWarnings("unused")
	public static boolean isEmpty(Object o) 
	{
		if (o == null) return true;
		if (o instanceof String){
			if (((String) o).trim().length() == 0){
				return true;
			}
		}
		else if (o instanceof Collection){
			if (((Collection) o).isEmpty()){
				return true;
			}
		}
		else if (o.getClass().isArray()){
			if (((Object[]) o).length == 0){
				return true;
			}
		}
		else if (o instanceof Map){
			if (((Map) o).isEmpty()){
				return true;
			}
		}
		
		
		return false;
	
	}
	
	/**
	 * 判断对象是否为空。
	 * o:为null 返沪true。
	 * 如果为集合，判断集合大小是否为0 为0则返回true
	 * Double，Float,Long,Short,Integer 为0也表示为空。
	 * @param o
	 * @return
	 */
	public static boolean isZeroEmpty(Object o) 
	{
		if (o == null) return true;
		if (o instanceof String){
			if (((String) o).trim().length() == 0){
				return true;
			}
		}
		else if (o instanceof Collection){
			if (((Collection) o).isEmpty()){
				return true;
			}
		}
		else if (o.getClass().isArray()){
			if (((Object[]) o).length == 0){
				return true;
			}
		}
		else if (o instanceof Map){
			if (((Map) o).isEmpty()){
				return true;
			}
		}
		else if (o instanceof Double){
			Double lEmpty=0.0;
			if(o==lEmpty){
				return true;
			}
		}
		else if (o instanceof Float){
			Float lEmpty=0f;
			if(o==lEmpty){
				return true;
			}
		}
		else if (o instanceof Long){
			Long lEmpty=0L;
			if(o==lEmpty){
				return true;
			}
		}
		else if (o instanceof Short){
			Short sEmpty=0;
			if(o==sEmpty ){
				return true;
			}
		}
		else if (o instanceof Integer){
			Integer sEmpty=0;
			if(o==sEmpty ){
				return true;
			}
		}
		
		return false;
	
	}
	

	/**
	 * 可以用于判断 Map,Collection,String,Array是否不为空
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(Object o)
	{
		return !isEmpty(o);
	}
	
	public static boolean isNotEmpty(Long o)
	{
		return !isEmpty(o);
	}
	
	/**
	 * 判断对象不为空。
	 * 如果为0表示为空。
	 * @param o
	 * @return
	 */
	public static boolean isNotIncZeroEmpty(Object o)
	{
		return !isZeroEmpty(o);
	}
	

	/**
	 * 判断是否为数字
	 * @param o
	 * @return
	 */
	public static boolean isNumber(Object o)
	{
		if (o == null) 	return false;
		
		if (o instanceof Number){
			return true;
		}
		if (o instanceof String){
			try{
				Double.parseDouble((String) o);
				return true;
			}
			catch (NumberFormatException e){
				return false;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 封装
	 * @param map
	 * @param entity
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object populateEntity(Map map,Object entity)throws IllegalAccessException, InvocationTargetException{
		beanUtilsBean.populate(entity, map);
		return entity;
	}
	
	/**
	 * 根据指定的类名判定指定的类是否存在。
	 * @param className
	 * @return
	 */
	public static boolean validClass(String className){
		try{
			Class.forName(className);
			return true;
		}
		catch (ClassNotFoundException e)
		{
			 return false;
		}
	}
	
	/**
	 * 判定类是否继承自父类
	 * @param cls	子类
	 * @param parentClass	父类
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean isInherit(Class cls,Class parentClass)
	{
		return parentClass.isAssignableFrom(cls);
	}
	
	/**
	 * 克隆对象
	 * @param bean
	 * @return
	 */
	public static Object cloneBean(Object bean){
		try{
			return beanUtilsBean.cloneBean(bean);
		}
		catch (Exception e){
			handleReflectionException(e);
			return null;
		}
	}
	/**
	 * 获取bean
	 * @param cls
	 * @return
	 */
	public  static Object getBean(Class cls)
	{
		ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		
		return ctx.getBean(cls);
	}
	
	
	/**
	 * 输入基类包名，扫描其下的类，返回类的全路径
	 * @param basePackages 如：com.hotent
	 * @return
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("all")
	public static List<String> scanPackages(String basePackages) throws IllegalArgumentException{
		
		ResourcePatternResolver rl = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(rl); 
		List result = new ArrayList();
		String[] arrayPackages = basePackages.split(",");
		try {
			for(int j = 0; j < arrayPackages.length; j++) {
				String packageToScan = arrayPackages[j];
				String packagePart = packageToScan.replace('.', '/');
				String classPattern = "classpath*:/" + packagePart + "/**/*.class";
				Resource[] resources = rl.getResources(classPattern);
				for (int i = 0; i < resources.length; i++) {
					Resource resource = resources[i];
					MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);   
					String className = metadataReader.getClassMetadata().getClassName();
					result.add(className);
				}
			}
		}catch(Exception e) {
			new IllegalArgumentException("scan pakcage class error,pakcages:"+basePackages);
		}

		return result;
	}
	
	/**
	 * 拷贝一个bean中的非空属性于另一个bean中
	 * 
	 * @param dest
	 * @param orig
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void copyNotNullProperties(Object dest, Object orig){
	
		// Validate existence of the specified beans
		if (dest == null) {
			logger.error("No destination bean specified");
			return;
		}
		if (orig == null) {
			logger.error("No origin bean specified");
			return;
		}
		
		try{
			// Copy the properties, converting as necessary
			if (orig instanceof DynaBean) {
				DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass()
						.getDynaProperties();
				for (int i = 0; i < origDescriptors.length; i++) {
					String name = origDescriptors[i].getName();
					if (beanUtilsBean.getPropertyUtils().isReadable(orig, name)
							&& beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
						Object value = ((DynaBean) orig).get(name);
						beanUtilsBean.copyProperty(dest, name, value);
					}
				}
			} else if (orig instanceof Map) {
				Iterator entries = ((Map) orig).entrySet().iterator();
				while (entries.hasNext()) {
					Map.Entry entry = (Map.Entry) entries.next();
					String name = (String) entry.getKey();
					if (beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
						beanUtilsBean.copyProperty(dest, name, entry.getValue());
					}
				}
			} else /* if (orig is a standard JavaBean) */{
				PropertyDescriptor[] origDescriptors = beanUtilsBean.getPropertyUtils()
						.getPropertyDescriptors(orig);
				for (int i = 0; i < origDescriptors.length; i++) {
					String name = origDescriptors[i].getName();
					if ("class".equals(name)) {
						continue; // No point in trying to set an object's class
					}
					if (beanUtilsBean.getPropertyUtils().isReadable(orig, name)
							&& beanUtilsBean.getPropertyUtils().isWriteable(dest, name)) {
						try {
							Object value = beanUtilsBean.getPropertyUtils().getSimpleProperty(orig, name);
							if (value != null) {
								beanUtilsBean.copyProperty(dest, name, value);
							}
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}catch(Exception ex){
			handleReflectionException(ex);
		}

	}

	@SuppressWarnings("unchecked")
	public static <T> T copyProperties(Class<T> destClass, Object orig)
	{
		Object target = null;
		try
		{
			target = destClass.newInstance();
			copyProperties((Object) target, orig);
			return (T) target;
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static void copyProperties(Object dest, Object orig)
	{
		try
		{
			beanUtilsBean.copyProperties(dest, orig);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
		}
	}

	public static void copyProperty(Object bean, String name, Object value)
	{
		try
		{
			beanUtilsBean.copyProperty(bean, name, value);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map describe(Object bean)
	{
		try
		{
			return beanUtilsBean.describe(bean);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String[] getArrayProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getArrayProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static ConvertUtilsBean getConvertUtils()
	{
		return beanUtilsBean.getConvertUtils();
	}

	public static String getIndexedProperty(Object bean, String name, int index)
	{
		try
		{
			return beanUtilsBean.getIndexedProperty(bean, name, index);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getIndexedProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getIndexedProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getMappedProperty(Object bean, String name, String key)
	{
		try
		{
			return beanUtilsBean.getMappedProperty(bean, name, key);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getMappedProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getMappedProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getNestedProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getNestedProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static PropertyUtilsBean getPropertyUtils()
	{
		try
		{
			return beanUtilsBean.getPropertyUtils();
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	public static String getSimpleProperty(Object bean, String name)
	{
		try
		{
			return beanUtilsBean.getSimpleProperty(bean, name);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static void populate(Object bean, Map properties)
	{
		try
		{
			beanUtilsBean.populate(bean, properties);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
		}
	}

	public static void setProperty(Object bean, String name, Object value)
	{
		try
		{
			beanUtilsBean.setProperty(bean, name, value);
		}
		catch (Exception e)
		{
			handleReflectionException(e);
		}
	}

	private static void handleReflectionException(Exception e)
	{
		ReflectionUtils.handleReflectionException(e);
	}
	
	
	/**
	 * 将字符串数据按照指定的类型进行转换。
	 * 
	 * @param typeName	实际的数据类型
	 * @param value		字符串值。
	 * @return  Object
	 */
	public static Object convertByActType(String typeName,String value){
		Object o = null;
		if (typeName.equals("int")) {
			o = Integer.parseInt(value);
		} else if (typeName.equals("short")) {
			o = Short.parseShort(value);
		} else if (typeName.equals("long")) {
			o = Long.parseLong(value);
		} else if (typeName.equals("float")) {
			o = Float.parseFloat(value);
		} else if (typeName.equals("double")) {
			o = Double.parseDouble(value);
		} else if (typeName.equals("boolean")) {
			o = Boolean.parseBoolean(value);
		} else if (typeName.equals("java.lang.String")) {
			o = value;
		}
		else{
			o=value;
		}
		return o;
	}
	
	
	
}

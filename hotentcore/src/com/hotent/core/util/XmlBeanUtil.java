package com.hotent.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

/**
 * XML与POJO相互转换
 * @author csx
 *
 */
public class XmlBeanUtil {
	/**
	 * XML转换为POJO类型
	 * @param xml
	 * @param clsToUnbound
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static Object unmarshall(String xml, Class clsToUnbound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToUnbound);
		return unmarshall(jc,xml);
	}
	/**
	 * POJO类型转换为XML
	 * @param serObj
	 * @param clsToBound
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static String marshall(Object serObj,Class clsToBound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToBound);
		return marshall(jc,serObj);
	}
	
	public static String marshall(Object serObj,Class clsToBound,String[] cdataEls) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToBound);
		return marshall(jc,serObj,cdataEls);
	}
	
	/**
	 * InputStream转换为POJO类型
	 * @param xml
	 * @param clsToUnbound
	 * @return
	 * @throws JAXBException
	 */
	public static Object unmarshall(InputStream is, Class<?> clsToUnbound) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(clsToUnbound);
		return unmarshall(jc,is);
	}
	
	/**
	 * InputStream转换为POJO类型
	 * @param jc
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	private static Object unmarshall(JAXBContext jc, InputStream is)
			throws JAXBException {
		Unmarshaller u = jc.createUnmarshaller();
		return (Object) u.unmarshal(is);
	}
	
	/**
	 * XML转换为POJO类型
	 * @param jc
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	private static Object unmarshall(JAXBContext jc, String xml)
			throws JAXBException {
		Unmarshaller u = jc.createUnmarshaller();
		return (Object) u.unmarshal(new StringReader(xml));
	}
	/**
	 * POJO类型转换为XML
	 * @param jc
	 * @param serObj
	 * @return
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	private static String marshall(JAXBContext jc, Object serObj)
			throws JAXBException, PropertyException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Marshaller m = jc.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, System.getProperty("file.encoding"));
		m.marshal(serObj, out);
	
		
		return out.toString();
	}
	
	private static String marshall(JAXBContext jc, Object serObj,String[] cdataEls)
			throws JAXBException, PropertyException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Marshaller m = jc.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, System.getProperty("file.encoding"));
		
		
		XMLSerializer serializer= getXMLSerializer(cdataEls);
		serializer.setOutputByteStream(out);
		
		
		
		SAXResult result=null;
		try {
			result = new SAXResult( serializer.asContentHandler() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
		m.marshal(serObj, result);
		
		return out.toString();
	}
	
	private static XMLSerializer getXMLSerializer(String[] aryProperty) {
		  OutputFormat of = new OutputFormat();
		  of.setCDataElements(aryProperty); //  
		  // set any other options you'd like
		  of.setPreserveSpace(true);
		  of.setIndenting(true);
		  // create the serializer
		  XMLSerializer serializer = new XMLSerializer(of);
		    
		  return serializer;
	}

}

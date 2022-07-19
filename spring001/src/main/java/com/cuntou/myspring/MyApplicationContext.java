package com.cuntou.myspring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyApplicationContext {

    Map<String,Object> ioc = new HashMap<>();

    //传入文件路径，构建容器
    public MyApplicationContext(String path) {
        try {
            //1、通过XML解析读取spring.xml中配置信息
            XMLDTO xmldto = parseXML(path);
            //2、根据这些配置信息通过反射创建对象
            createObj(xmldto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id){
        return ioc.get(id);
    }

    /**
     * 创建对象
     * @return
     */
    public void createObj(XMLDTO xmldto){
        try {
            //创建对象
            String clazz = xmldto.getClazz();
            Class cls = Class.forName(clazz);
            Object o = cls.getConstructor(null).newInstance(null);
            //给属性赋值
            List<Map<String, String>> propertyList = xmldto.getProperty();
            for (Map<String, String> map : propertyList) {
                callSetter(o,map,cls);
            }
            //存储对象
            ioc.put(xmldto.getId(), o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调set方法完成赋值
     */
    public void callSetter(Object object,Map<String,String> map,Class cls){
        try {
            String name = map.get("name");
            String value = map.get("value");
            //获取方法名
            String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
            //通过反射获取方法
            Field declaredField = cls.getDeclaredField(name);
            Method method = cls.getMethod(methodName, declaredField.getType());
            //值的类型转换
            Object val = null;
            switch (declaredField.getType().getName()){
                case "java.lang.Integer":
                    val = Integer.parseInt(value);
                    break;
                case "java.lang.Double":
                    val = Double.parseDouble(value);
                    break;
                case "java.lang.String":
                    val = value;
                    break;
            }
            //调用setter赋值
            method.invoke(object, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析XML
     * @param path
     * @return
     */
    public XMLDTO parseXML(String path) throws Exception{
        XMLDTO xmldto = new XMLDTO();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src\\main\\resources\\"+path);
        //获取根节点
        Element rootElement = document.getRootElement();
        //遍历根节点
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element node = iterator.next();
            String id = node.attributeValue("id");
            String aClass = node.attributeValue("class");
            xmldto.setId(id);
            xmldto.setClazz(aClass);
            //迭代property
            Iterator<Element> iterator1 = node.elementIterator();
            List<Map<String,String>> propertyList = new ArrayList<>();
            while (iterator1.hasNext()) {
                Element property = iterator1.next();
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                Map<String,String> map = new HashMap<>();
                map.put("name", name);
                map.put("value", value);
                propertyList.add(map);
            }
            xmldto.setProperty(propertyList);
        }
        return xmldto;
    }

}

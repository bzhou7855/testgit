package com.dream.model1;

import java.lang.reflect.Method;

public class Reflectutils {
    /*
    * 1. 已知对象与成员变量名调用对应的get方法
    * 2. 已知对象与成员变量名调用对应的set方法
    * 3. 已知对象及方法名调用此方法
    *
    * 首先获取METHOD对象，然后调用invoke方法
    *
    * Method method = class1.getMethod(methodName,parameterTypes);
    * method.invoke(obj,parameters);
    *
    * */

    /**
        * @param obj
    	* @param fieldName
        * @return java.lang.Object
        * @author bobzhou
        * @date 2022/6/15 8:43
    */
    public static Object invokeGetter(Object obj,String fieldName){
        if(obj == null){
            throw new RuntimeException("对象为空");
        }
        String methodName = "get".concat(LargerFirstChar(fieldName));
        return invokeMethod(obj,methodName,null,null);
    }

    public static String lowerFirstChar(String str){
        char[] chars = str.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }

    public static String LargerFirstChar(String str){
        char[] chars = str.toCharArray();
        chars[0]-=32;
        return String.valueOf(chars);
    }

    /**
        * @param obj
    	* @param fieldName
    	* @param value
        * @return void
        * @author bobzhou
        * @date 2022/6/15 8:45
    */
    public static void invokeSetter(Object obj,String fieldName,Object value){
        if(obj == null){
            throw new RuntimeException("对象为空");
        }

        String methodName = "set".concat(LargerFirstChar(fieldName));

        invokeMethod(obj,methodName,new Class<?>[] {value.getClass()}, new Object[] {value});
    }

    public static void invokeSetter(Object obj,String fieldName,Class<?> clazz , Object value){
        if(obj == null){
            throw new RuntimeException("对象为空");
        }

        String methodName = "set".concat(LargerFirstChar(fieldName));


        invokeMethod(obj,methodName,new Class<?>[] {clazz}, new Object[] {value});
    }

    /**
        * @param obj
    	* @param methodName
    	* @param parameterTypes
    	* @param args
        * @return java.lang.Object
        * @author bobzhou
        * @date 2022/6/15 8:49
    */
    public static Object invokeMethod(Object obj,String methodName,Class<?>[] parameterTypes,Object[] args){
        Class<?> aClass = obj.getClass();
        Method method = getMethod(aClass, methodName, parameterTypes);
        //Method method1 = Optional.ofNullable(method).orElse(null);
        if(method == null){
            throw new RuntimeException("无法找到方法："+methodName);
        }

        try {
            return method.invoke(obj,args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用方法出错："+e.getMessage());
        }
    }

    /**
        * @param class1
    	* @param methodName
    	* @param parameterTypes
        * @return Method
        * @author bobzhou
        * @date 2022/6/15 8:51
    */
    public static Method getMethod(Class<?> class1, String methodName, Class<?>[] parameterTypes){
        Method method = null;

        try {
            method = class1.getMethod(methodName,parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    /**
        * @param
        * @return void
        * @author bobzhou
        * @date 2022/6/15 9:08
    */
    public static void test() throws Exception {
        PbCourse pbCourse = new PbCourse();
        invokeSetter(pbCourse,"courseName","计算机计算技术");
        invokeSetter(pbCourse,"price",int.class,100);
        PbCourse pbCourse1 = new PbCourse();
        invokeSetter(pbCourse1,"courseName","漫威英雄");
        invokeSetter(pbCourse1,"price",int.class,200);

        Object compareTo = invokeMethod(pbCourse, "compareTo", new Class<?>[]{PbCourse.class}, new Object[]{pbCourse1});

        System.out.println(compareTo);
    }

    /**
        * @param args
        * @return void
        * @author bobzhou
        * @date 2022/6/15 9:08
    */
    public static void main(String[] args) throws Exception{
        test();
//        PbCourse pbCourse = new PbCourse();
//        invokeMethod(pbCourse,"setPrice",new Class<?>[] {int.class},new Object[]{100});
//
//        System.out.println(pbCourse.getPrice());
    }
}

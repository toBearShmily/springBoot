package com.shmily;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Reflect {

    public Object copy(Object obj) throws Exception{
        //得到需要复制对象的class类型
        Class<?> classType = obj.getClass();
        //通过构造当前对象的空构造来得到一个对象

        Object copyObject = classType.getConstructor(new Class[]{})//new Class[] 构造参数(类型)
                .newInstance(new Object[]{});//为参数赋值

        //获得复制对象的成员变量
        Field[] fields = classType.getDeclaredFields();//获取某个类的所有申明的字段(不包括父类)，而getFields则会都取到包括父类
        for(Field field : fields){
            String name = field.getName();
            System.out.println(name);

            String firstName = name.substring(0,1).toUpperCase();//属性第一个字母大写

            String getMethodName = "get"+firstName+name.substring(1);
            String setMethodName = "set"+firstName+name.substring(1);

            Method getMethod = classType.getMethod(getMethodName,new Class[]{});
            Method setMethod = classType.getMethod(setMethodName,new Class[]{field.getType()});

            Object getValue = getMethod.invoke(obj,new Object[]{});//被复制对象的get方法取值
            setMethod.invoke(copyObject,new Object[]{getValue});
        }
        return copyObject;

    }

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("吴旭彪");
        customer.setAge(23L);
        Customer copyCustomer = (Customer) new Reflect().copy(customer);
        System.out.println("id："+copyCustomer.getId()+
                            "----name:"+copyCustomer.getName()+
                            "----age:"+copyCustomer.getAge());

    }

}

class Customer{
    private Integer id;

    private String name;

    private Long age;

    public Customer(){}

    public Customer(String name,Long age){
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

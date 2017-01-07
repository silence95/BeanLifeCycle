package beanFactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import bean.BeanTest;

public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("MyBeanPostProcessor construction");
    }
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanTest) {
            BeanTest beanTest = (BeanTest)bean;
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization:beanTest.addProperty " + beanTest.getAddProperty()
                    + " ,beanAutowiredTest=" + beanTest.getBeanAutowiredTest());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanTest) {
            BeanTest beanTest = (BeanTest)bean;
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization:beanTest.addProperty " + beanTest.getAddProperty()
                    + " ,beanAutowiredTest=" + beanTest.getBeanAutowiredTest());
        }
        return bean;
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("beanTest".equals(beanName))
            System.out.println("MyBeanPostProcessor.postProcessBeforeInstantiation");
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanTest) {
            BeanTest beanTest = (BeanTest)bean;
            System.out.println("MyBeanPostProcessor.postProcessAfterInstantiation:beanTest.addProperty " + beanTest.getAddProperty()
                    + " ,beanAutowiredTest=" + beanTest.getBeanAutowiredTest());
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
            String beanName) throws BeansException {
        if(bean instanceof BeanTest) {
            BeanTest beanTest = (BeanTest)bean;
            System.out.println("MyBeanPostProcessor.postProcessPropertyValues:beanTest.addProperty " + beanTest.getAddProperty()
                    + " ,beanAutowiredTest=" + beanTest.getBeanAutowiredTest());
            pvs.getPropertyValue("addProperty").setConvertedValue("addConvertedPropertyValue");
        }
        return pvs;
    }

}

package beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("MyBeanFactoryPostProcessor construction");
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory"); // 不能用getBean("beanTest"),不然这条语句的打印就会出现在beanTest初始完以后
        BeanDefinition bd = beanFactory.getBeanDefinition("beanTest");
        MutablePropertyValues mutablePropertyValues = bd.getPropertyValues();
        if(mutablePropertyValues.contains("addProperty"))
            mutablePropertyValues.add("addProperty", "addFactoryPostProcessorPropertyValue");
    }

}

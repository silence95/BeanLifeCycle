package bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanTest implements InitializingBean {

    private String beanName;
    private String addProperty;
    @Autowired private BeanAutowiredTest beanAutowiredTest;
    
    public BeanTest() {
        System.out.println("construction BeanTest bean=" + this + " beanName=" + beanName + " ,addProperty=" + addProperty + " ,beanAutowiredTest=" + beanAutowiredTest);
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        System.out.println("setBeanName=" + beanName);
        this.beanName = beanName;
    }

    public String getAddProperty() {
        return addProperty;
    }

    public void setAddProperty(String addProperty) {
        System.out.println("setAddProperty=" + addProperty);
        this.addProperty = addProperty;
    }

    public BeanAutowiredTest getBeanAutowiredTest() {
        return beanAutowiredTest;
    }

    public void setBeanAutowiredTest(BeanAutowiredTest beanAutowiredTest) {
        System.out.println("setBeanAutowiredTest=" + beanAutowiredTest);
        this.beanAutowiredTest = beanAutowiredTest;
    }
    
    @PostConstruct
    public void println() {
        System.out.println("@PostConstruct after construction bean=" + this + " ,beanName=" + beanName + " ,addProperty=" + addProperty + " ,beanAutowiredTest=" + beanAutowiredTest);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet after construction bean=" + this + " ,beanName=" + beanName + " ,addProperty=" + addProperty + " ,beanAutowiredTest=" + beanAutowiredTest);
    }
    
}

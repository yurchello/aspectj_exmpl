package com.yurchello.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
        Customer customer = (Customer) appContext.getBean("customer");
        //customer.addCustomer();
        customer.addCustomerAround("2222");
    }
}

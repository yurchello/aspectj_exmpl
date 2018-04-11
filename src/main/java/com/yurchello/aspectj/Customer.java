package com.yurchello.aspectj;

public interface Customer {
    String addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}

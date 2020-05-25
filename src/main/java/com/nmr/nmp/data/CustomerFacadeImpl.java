package com.nmr.nmp.data;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class CustomerFacadeImpl implements IDataFacade<Customer> {

    private CustomerMapper customerMapper = new CustomerMapper();

    @Override
    public void create(Customer customer) {
        customerMapper.create(customer);
    }

    @Override
    public ArrayList<Customer> read() {
        return customerMapper.read();
    }

    @Override
    public Customer read (int id){
        return customerMapper.read(id);
    }

    @Override
    public void update(Customer type) {

    }

    @Override
    public void delete(int id) {

    }


}
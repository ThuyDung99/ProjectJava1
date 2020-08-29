package hust.dungttt.service;

import hust.dungttt.model.Customer;
import hust.dungttt.model.EnterpriseCustomer;

import java.util.List;

public interface CustomerService {
    Customer insert();

    Customer update(Customer customer);

    List<Customer> search(String fullname,String address, String phoneNumber, String email, int productQuantityMin, int productQuantityMax, double moneySpentMin, double moneySpentMax, int purchaseNumberMin, int purchaseNumberMax)  ;

    boolean delete(int id);

    void findAllCustomer();

    List<Customer> findMoneySpentMax();

    List<Customer> findProductQuantityMax();

    List<Customer> findOldCustomer();

    Customer findById(int id);
}

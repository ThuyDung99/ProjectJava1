package hust.dungttt.service;

import hust.dungttt.model.Customer;
import hust.dungttt.model.EnterpriseCustomer;

import java.util.List;

public interface EnterpriseCustomerService {

    EnterpriseCustomer insert();

    EnterpriseCustomer update(EnterpriseCustomer enterpriseCustomer);

    boolean delete(int id);

    List<EnterpriseCustomer> search(String fullname,String address, String phoneNumber, String email, int productQuantityMin, int productQuantityMax, double moneySpentMin, double moneySpentMax, int purchaseNumberMin, int purchaseNumberMax, int taxCode, String owner, String website);

    EnterpriseCustomer findById(int id);

}

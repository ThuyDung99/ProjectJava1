package hust.dungttt.controller;

import hust.dungttt.model.Customer;
import hust.dungttt.service.CustomerService;
import hust.dungttt.service_impl.CustomerServiceImpl;
import java.util.*;


public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    public void findAll() {
        customerService.findAllCustomer();
    }

    public Customer insert() {
        Customer customer = customerService.insert();
        System.out.println(customer);
        return customer;
    }

    public Customer update() {
        Customer newCustomer = null;
        System.out.println("Mời nhập id của khách hàng cần sửa:");
        int id = new Scanner(System.in).nextInt();
        newCustomer = customerService.findById(id);
        if(newCustomer != null) {
            newCustomer.setAddress(customerService.checkAddress());
            newCustomer.setDateOfBirth(customerService.checkDateOfBirth());
            newCustomer.setEmail(customerService.checkEmail());
            newCustomer.setFullName(customerService.checkFullName());
            newCustomer.setPhoneNumber(customerService.checkPhone());
            System.out.println("Nhập số tiền đã tiêu:");
            newCustomer.setMoneySpent(new Scanner(System.in).nextInt());
            System.out.println("Nhập số lần đã mua:");
            newCustomer.setPurchaseNumber(new Scanner(System.in).nextInt());
            System.out.println("Nhập số lượng sản phẩm:");
            newCustomer.setProductQuantity(new Scanner(System.in).nextInt());
            newCustomer = customerService.update(newCustomer);
        }
        return newCustomer;
    }

    public boolean delete() {
        System.out.println("Nhập id khách hàng cần xóa:");
        int id = new Scanner(System.in).nextInt();
        boolean rs = customerService.delete(id);
        if(rs) {
            System.out.println("Xóa khách hàng thành công");
        } else {
            System.out.println("Xóa khách hàng không thành công");
        }
        return customerService.delete(id);
    }

    public List<Customer> findMoneySpentMax() {
        List<Customer> listRs = customerService.findMoneySpentMax();
        if(!listRs.isEmpty()) {
            System.out.println("Danh sách người dùng tiêu nhiều tiền nhất");
            printListCustomer(listRs);
        } else {
            System.out.println("Chưa có người dùng nào mua sản phẩm của bạn");
        }
        return customerService.findMoneySpentMax();
    }

    public List<Customer> findProductQuantityMax() {
        List<Customer> listRs = customerService.findProductQuantityMax();
        if(!listRs.isEmpty()) {
            System.out.println("Danh sách người dùng mua nhiều sản phẩm nhất");
            printListCustomer(listRs);
        } else {
            System.out.println("Chưa có người dùng nào mua sản phẩm của bạn");
        }
        return customerService.findProductQuantityMax();
    }

    public List<Customer> findOldCustomer() {
        List<Customer> listRs = customerService.findOldCustomer();
        if(!listRs.isEmpty()) {
            System.out.println("Danh sách người dùng quay lại dùng dịch vụ");
            printListCustomer(listRs);
        } else {
            System.out.println("Chưa có người dùng nào quay lại dùng dịch vụ của bạn");
        }
        return customerService.findOldCustomer();
    }

    public Customer findById(int id) {
        return customerService.findById(id);
    }

    public List<Customer> search() {
        System.out.println("Nhập tên tìm kiếm:");
        String fullname = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ tìm kiếm:");
        String address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại tìm kiếm:");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Nhập email tìm kiếm:");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Số lượng sản phẩm đã mua cao hơn:");
        int productQuantityMin = new Scanner(System.in).nextInt();
        System.out.println("Số lượng sản phẩm đã mua thấp hơn:");
        int productQuantityMax = new Scanner(System.in).nextInt();
        System.out.println("Số lượng tiền sử dụng cao hơn:");
        double moneySpentMin = new Scanner(System.in).nextInt();
        System.out.println("Số lượng sản phẩm đã mua thấp hơn:");
        double moneySpentMax = new Scanner(System.in).nextInt();
        System.out.println("Số lượng lượt đã mua cao hơn:");
        int purchaseNumberMin = new Scanner(System.in).nextInt();
        System.out.println("Số lượng sản phẩm đã mua thấp hơn:");
        int purchaseNumberMax = new Scanner(System.in).nextInt();
        List<Customer> customerList = customerService.search(fullname, address, phoneNumber, email, productQuantityMin, productQuantityMax, moneySpentMin, moneySpentMax, purchaseNumberMin, purchaseNumberMax);
        if(!customerList.isEmpty()) {
            System.out.println("Thông tin tìm kiếm:");
            printListCustomer(customerList);
        } else {
            System.out.println("Không có thông tin tìm kiếm phù hợp");
        }
        return customerList;
    }

    public void statisticMoney() {
        System.out.println("Số tiền đã tiêu cao hơn");
        int minMoney = new Scanner(System.in).nextInt();
        System.out.println("Số tiền đã tiêu thấp hơn");
        int maxMoney = new Scanner(System.in).nextInt();
        int rs = customerService.statisticMoney(minMoney, maxMoney);
        if(rs > 0) {
            System.out.println("Có "+ rs +" khách hàng tiêu trên " + minMoney + " và dưới " + maxMoney);
        } else {
            System.out.println("Không có khách hàng tiêu trong khoảng "  + minMoney + " đến " + maxMoney);
        }
    }

    public void printListCustomer(List<Customer> customerList) {
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
    }

    public boolean writeFileCustomer() {
        return customerService.writeFileCustomer();
    }

    public boolean readFileCustomer() {
        return customerService.readFileCustomer();
    }
}

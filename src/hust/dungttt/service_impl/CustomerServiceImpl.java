package hust.dungttt.service_impl;

import hust.dungttt.common.AppConfig;
import hust.dungttt.model.Customer;
import hust.dungttt.service.CustomerService;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    Scanner sc = new Scanner(System.in);
    String textRegexFullName = "^(\\s*)(\\w+\\s+)+(\\w+\\s*)$";
    String textRegexPass= "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@$%^+=])).{8,}"; //Password có 8 ký tự trở lên, ít nhất 1 chữ hoa, 1 ký tự đặc biệt, 1 số
    String textRegexEmail="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    String textRegexPhone= "0[35789]\\d{8}";
    String textRegexUsername= "^[a-z0-9_-]{3,16}$";
    String textRegexAddress= "^(\\s*)(\\w+\\s+)+(\\w+\\s*)$";
    String textRegexDateOfBirth = "\\d{2}/\\d{2}/\\d{4}"; //Định dạng DD/MM/YYYY

    public void printInput(String text) {
        System.out.println("Mời bạn nhập vào " + text + " :");
    }

    public void printError(String text) {
        System.out.println("Nhập sai định dạng " + text + ". Mời bạn nhập lại!");
    }

    public String checkString(String text, String regex) {
        String rs = "";
        //to do
        while(true) {
            printInput(text);
            rs = sc.nextLine();
            if(rs.matches(regex)) {
                break;
            }
            printError(text);
        }
        return rs;
    } //Hàm check chung cho chuỗi : pass, email, name, add,phone

    boolean checkInitUsername(String username) {
        boolean rs = false;
        for (Customer customer : AppConfig.listCustomer) {
            if(customer.getUsername().equals(username)) {
                rs = true;
                break;
            }
        }
        return rs;
    } // check username đã tồn tại

    public String checkUsernameInsert() {
        String rs = "";
        //to do
        while(true) {
            printInput("username (VD:dungttt_123)");
            rs = sc.nextLine();
            if(rs.matches(textRegexUsername)) {
                if(!checkInitUsername(rs)) {
                    break;
                }
                System.out.println("Tên đăng nhập đã tồn tại. Mời nhập lại!");
            }
            else printError("username (VD:dungttt_123))");
        }
        return rs;
    }

    public String checkPasswordInsert() {
        String rs = checkPassword();
        System.out.println("Mời nhập lại password: ");
        String test = "";
        while(true){
            test = sc.nextLine();
            if(rs.equals(test)){
                break;
            }
            System.out.println("Mật khẩu không khớp, vui lòng nhập lại!");
        } // check lại
        return rs;
    }

    public String checkPassword() {
        return checkString("password "+ "(Password có 8 ký tự trở lên, ít nhất 1 chữ hoa, 1 ký tự đặc biệt, 1 số)", textRegexPass);
    }

    public String checkFullName() {
        return checkString("họ và tên",textRegexFullName);
    }

    public String checkPhone() {
        return checkString("số điện thoại",textRegexPhone);
    }

    public String checkAddress() {
        return checkString("địa chỉ",textRegexAddress);
    }

    public String checkDateOfBirth() {
        return checkString("ngày tháng năm sinh ( Định dạng DD/MM/YYYY )",textRegexDateOfBirth);
    }

    public String checkEmail() {
        return checkString("email (VD:aaa@gmail.com))", textRegexEmail);
    }

    @Override
    public Customer insert() {
        Customer cus = new Customer(AppConfig.countCus++,checkUsernameInsert(),checkPasswordInsert(),checkFullName(),checkDateOfBirth(),
                checkAddress(),checkPhone(),checkEmail(), 0, 0, 0,
                new Date(),new Date(),false);
        AppConfig.listCustomer.add(cus);
        System.out.println("***** Thêm thành công *****");
        return cus;
    }

    @Override
    public Customer update(Customer customer) {
        Customer cusFix= null;
        for(Customer customer1 : AppConfig.listCustomer){
            if(customer.getId() == customer1.getId()){
                cusFix = customer1;
                // customer 1 là thằng cần sửa thì sửa trong này luôn chuyển 130 lên đây rồi bỏ if đi
                break;
            }
        }
        if(cusFix == null){
        return null;
        }
        cusFix.setUsername(customer.getUsername());
        cusFix.setPassword(customer.getPassword());
        cusFix.setAddress(customer.getAddress());
        cusFix.setDateOfBirth(customer.getDateOfBirth());
        cusFix.setEmail(customer.getEmail());
        cusFix.setFullName(customer.getFullName());
        cusFix.setMoneySpent(customer.getMoneySpent());
        cusFix.setPurchaseNumber(customer.getPurchaseNumber());
        cusFix.setPhoneNumber(customer.getPhoneNumber());
        cusFix.setProductQuantity(customer.getProductQuantity());
        cusFix.setModifyDate(new Date());
        return cusFix;
    }

    @Override
    public List<Customer> search(String fullname, String address, String phoneNumber, String email, int productQuantityMin, int productQuantityMax, double moneySpentMin, double moneySpentMax, int purchaseNumberMin, int purchaseNumberMax) {
        List<Customer> listCustomerSearch = new ArrayList<>();
        for(Customer customer1 : AppConfig.listCustomer){
            if(customer1.getUsername().equals(fullname)||customer1.getAddress().equals(address)|| customer1.getPhoneNumber().equals(phoneNumber)||customer1.getEmail().equals(email)|| (customer1.getProductQuantity()>=productQuantityMin&customer1.getProductQuantity()<=productQuantityMax)||(customer1.getMoneySpent()>= moneySpentMin & customer1.getMoneySpent()<= moneySpentMax) ||(customer1.getPurchaseNumber()<=productQuantityMax & customer1.getPurchaseNumber()>=productQuantityMin)){
                listCustomerSearch.add(customer1);
            }
        }
        return listCustomerSearch;
    }

    @Override
    public boolean delete(int id) {
        boolean rs= false;
        for(Customer customer1 : AppConfig.listCustomer){
            if(id == customer1.getId()){
                customer1.setDeleted(true);
                rs = true;
                break;
            }
        }
        return rs;
    }

    @Override
    public void findAllCustomer() {
        System.out.println("*************Thông tin các khách hàng***************");
        for(Customer customer1 : AppConfig.listCustomer) {
            System.out.println(customer1.toString());
        }
    }

    @Override
    public List<Customer> findMoneySpentMax() {
        List<Customer> listOldCustomer = new ArrayList<>();
        for(Customer customer1 : AppConfig.listCustomer) {
            if(customer1.getPurchaseNumber()>1){
                listOldCustomer.add(customer1);
            }
        }
        return listOldCustomer;
    }

    @Override
    public List<Customer> findProductQuantityMax() {
        List<Customer> listProductQuantityMax = new ArrayList<>();
        List<Customer> listProductQuantity = new ArrayList<>();
        for(Customer customer1 : AppConfig.listCustomer) {
            listProductQuantity.add(customer1);
        }
        Collections.sort(listProductQuantity, new Comparator<Customer>() {
            public int compare(Customer o1, Customer o2) {
                return o2.getProductQuantity() - o1.getProductQuantity();
            }
        });
        int max = 0;
        for(Customer customer1 : listProductQuantity) {
            if(max <= customer1.getProductQuantity()){
                max = customer1.getProductQuantity();
                listProductQuantityMax.add(customer1);
            }
            else break;
        }
        System.out.println("******Thông tin các khách hàng mua nhiều sản phẩm nhất:");
        for(Customer customer1 : listProductQuantityMax) {
            System.out.println(customer1.toString());
        }
        return listProductQuantityMax;
    }

    @Override
    public List<Customer> findOldCustomer() {
        List<Customer> listOldCustomer = new ArrayList<>();
        for(Customer customer1 : AppConfig.listCustomer) {
            if(customer1.getPurchaseNumber()>1){
                listOldCustomer.add(customer1);
            }
        }
        return listOldCustomer;
    }

    @Override
    public Customer findById(int id) {
        Customer rs = null;
        for(Customer customer1 : AppConfig.listCustomer){
            if(id == customer1.getId()){
                rs = customer1;
            }
        }
        return rs;
    }

}

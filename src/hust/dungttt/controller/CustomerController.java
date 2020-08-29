package hust.dungttt.controller;

import hust.dungttt.model.Customer;
import hust.dungttt.service.CustomerService;
import hust.dungttt.service_impl.CustomerServiceImpl;

import java.util.List;

//Dùng để gọi các hàm service, xong view gọi controller
public class CustomerController {

    // Khởi tạo với kiểu dữ liệu là Interface nhưng new thì phải new thằng Impl để private code
    // nhìn giải thích ở ví dụ khi khởi tạo click nó sẽ ra luôn triển khai còn new nhưu dưới thì ko
    private CustomerService customerService = new CustomerServiceImpl();

    public void findAll() {
        customerService.findAllCustomer();
        //ở đây trong service em in ra rồi thì thằng này chỉ việc gọi đến thôi thế là xong
        //giờ anh  viết yêu cầu các hàm rồi em làm tiếp nha
    }
    //hay anh làm cho rồi đem nọp sau lên me code lại theo anh rồi lên tình bay thôi ok ?n
}

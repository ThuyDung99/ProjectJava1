package hust.dungttt.view;

import com.sun.javaws.IconUtil;
import hust.dungttt.common.AppConfig;
import hust.dungttt.model.Customer;
import hust.dungttt.service_impl.CustomerServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {
        CustomerServiceImpl customer = new CustomerServiceImpl();

        AppConfig.listCustomer.add(new Customer(AppConfig.countCus++,"dungttt_123","thuydung281199@D",
                "tran dung","28/11/1999","ha tinh","0342838383","dung.ttt@gmail.com"
        ,5,0,0,new Date(),new Date(),false));
        AppConfig.listCustomer.add(new Customer(AppConfig.countCus++,"dungttt23","thuydung281199@D",
                "tran dung","28/11/1999","ha tinh","0342838383","dung.ttt@gmail.com"
                ,0,0,0,new Date(),new Date(),false));
        AppConfig.listCustomer.add(new Customer(AppConfig.countCus++,"dungttt_123","thuydung281199@D",
                "tran dung","28/11/1999","ha tinh","0342838383","dung.ttt@gmail.com"
                ,3,0,0,new Date(),new Date(),false));
       // customer.insert();
        for(Customer customer1 : AppConfig.listCustomer) {
            System.out.println(customer1.toString());
        }
        //customer.delete(1);
        customer.update(new Customer(2,"dungttt","thuylll81199@D",
                "tran dung","28/11/1999","ha tinh","0342855583","dung.ttt@gmail.com",
                5,0,0,new Date(),new Date(),false));
        System.out.println("---------------------------------------------");
        customer.findProductQuantityMax();

    }
}

package hust.dungttt.view;

import com.sun.javaws.IconUtil;
import hust.dungttt.common.AppConfig;
import hust.dungttt.controller.CustomerController;
import hust.dungttt.controller.MenuItemController;
import hust.dungttt.model.Customer;
import hust.dungttt.model.MenuItem;
import hust.dungttt.service_impl.CustomerServiceImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.readFileCustomer();
        MenuItemController menuItemController = new MenuItemController();
        menuItemController.showMenuHome();
    }
}

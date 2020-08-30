package hust.dungttt.controller;

import hust.dungttt.model.MenuItem;
import java.util.*;

public class MenuItemController {

    private CustomerController customerController = new CustomerController();

    public void showMenuHome() {
        MenuItem themKhachHang = new MenuItem(1, "Thêm khách hàng");
        MenuItem suaThongTin = new MenuItem(2, "Sửa thông tin khách hàng");
        MenuItem xoaThongTin = new MenuItem(3, "Xóa thông tin khách hàng");
        MenuItem inThongTin = new MenuItem(4, "In thông tin toàn bộ khách hàng");
        MenuItem nhieuTienNhat = new MenuItem(5, "Thông tin khách hàng tiêu nhiều tiền nhất");
        MenuItem nhieuSanPhamNhat = new MenuItem(6, "Thông tin khách hàng mua nhiều sản phẩm nhất");
        MenuItem quayLaiDungDichVu = new MenuItem(7, "Thông tin khách hàng quay lại dùng dịch vụ");
        MenuItem timKiem = new MenuItem(8, "Tìm kiếm thông tin khách hàng");
        MenuItem thongKeTien = new MenuItem(9, "Thống kê mức tiêu tiền khách hàng");
        MenuItem thoat = new MenuItem(0, "Thoát");
        showMenu(themKhachHang, suaThongTin, xoaThongTin, inThongTin, nhieuTienNhat, nhieuSanPhamNhat, quayLaiDungDichVu, timKiem, thongKeTien, thoat);
        while(true){
            System.out.println("Mời bạn nhập lựa chọn theo đúng số thứ tự trên menu.");
            int chon = new Scanner(System.in).nextInt();
            actionMenuHome(chon);
            showMenuHome();
        }
    }

    public void actionMenuHome(int option) {
        switch (option) {
            case 1:
                customerController.insert();
                break;
            case 2:
                customerController.update();
                break;
            case 3:
                customerController.delete();
                break;
            case 4:
                customerController.findAll();
                break;
            case 5:
                customerController.findMoneySpentMax();
                break;
            case 6:
                customerController.findProductQuantityMax();
                break;
            case 7:
                customerController.findOldCustomer();
                break;
            case 8:
                customerController.search();
                break;
            case 9:
                customerController.statisticMoney();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Chọn sai vui lòng chọn lại!");
                break;
        }
    }

    public void showMenu(MenuItem ...listMenu) {
        int len = listMenu.length;
        for (int i = 0; i < len; i++) {
            System.out.println(listMenu[i]);
        }
    }
}

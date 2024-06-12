package caseStudy.views;

import caseStudy.services.iml.CommonCheck;


public class ViewMenu {

    public int adminMenu() {
        System.out.println("==========================================================");
        System.out.println("|         Danh sách các tùy chọn quản trị viên           |");
        System.out.println("|                                                        |");
        System.out.println("| > 1: Xem danh sách sản phẩm trong kho                  |");
        System.out.println("| > 2: Tìm kiếm sản phẩm                                 |");
        System.out.println("| > 3: Quản lý đơn hàng đã được mua                      |");
        System.out.println("| > 4: Quản lý đơn hàng đã được đặt trước                |");
        System.out.println("| > 5: Chat với khách hàng                               |");
        System.out.println("| > 6: doanh thu                                         |");
        System.out.println("| > 7: Đăng xuất                                         |");
        System.out.println("==========================================================");
        System.out.println("Choice:");
        int choice = CommonCheck.checkParseInteger();


        return choice;
    }

    public int customerMenu() {
        System.out.println("==========================================================");
        System.out.println("|         Danh sách các tùy chọn khách hàng              |");
        System.out.println("|                                                        |");
        System.out.println("| > 1: Thêm sản phẩm vào giỏ hàng                        |");
        System.out.println("| > 2: xóa sản phẩm vào giỏ hàng                         |");
        System.out.println("| > 3: Xem danh sách sản phẩm                            |");
        System.out.println("| > 4: Tìm kiếm sản phẩm                                 |");
        System.out.println("| > 5: Xem danh sách các sản phẩm khuyến mãi             |");
        System.out.println("| > 6: Quản lý giỏ hàng cá nhân                          |");
        System.out.println("| > 7: Chat với Shop                                     |");
        System.out.println("| > 8: Đăng xuất                                         |");
        System.out.println("==========================================================");
        System.out.println("Choice:");
        int choice = CommonCheck.checkParseInteger();
        return choice;
    }
}

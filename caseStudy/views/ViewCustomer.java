package Casestudy_Module_2.caseStudy.views;

import Casestudy_Module_2.caseStudy.models.InformationCustomer;
import Casestudy_Module_2.caseStudy.services.iml.CommonCheck;

import java.util.Scanner;

public class ViewCustomer {


    public String customerBuyCode() {
        System.out.println("Nhập mã sản phẩm bạn muốn mua: ");
        String code = CommonCheck.checkRegexPoint();
        return code;
    }

    public int customerBuyQuantily() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng: ");
        int quantily = Integer.parseInt(input.nextLine());
        return quantily;
    }

    public String customerRemoveCode() {
        System.out.println("Nhập mã sản phẩm cần xóa trong giỏ hàng: ");
        String code = CommonCheck.checkRegexPoint();
        return code;
    }

    public boolean buyProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhấn BUY để xác nhận mua hàng: ");
        String code = input.nextLine();
        if (code.equals("BUY")) {
            return true;
        }
        return false;
    }

    public int payProduct(boolean buy) {
        Scanner input = new Scanner(System.in);
        if (buy) {
            System.out.println("Chọn phương thức thanh toán : " + "\n"
                    + " 1: Bằng tiền tài khoảng PayShop " + "\n" + " 2: Bằng thẻ tín dụng");
            int check = CommonCheck.checkParseInteger();
            return check;
        }
        System.out.println("Thao tác bị hủy!");
        return 0;
    }

    public void completeBuy(int check) {
        if (check == 1 || check == 2) {
            System.out.println("Mua hàng thành công" + "\n" + " Cám ơn và hẹn được phụ vụ bạn lần tới ^_^");
        } else {
            System.out.println("Mua hàng thất bại!");
        }
    }

    public InformationCustomer chatCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================================");
        System.out.println("|              Nhận tư vấn từ quản trị viên              |");
        System.out.println("==========================================================");
        System.out.println("Nhập tện của bạn:");
        String name = input.nextLine();
        System.out.println("Nhập số điện thoại liên hệ: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.println("Nhập Email của bạn: ");
        String email = input.nextLine();
        InformationCustomer informationCustomer = new InformationCustomer(name,phone,email);
        return informationCustomer;
    }

    public void notification(String message) {
        if (message.equals("")) {
            System.out.println("Tin nhắn chưa được gửi đi!");
        } else {
            System.out.println("Tin nhắn đã được gửi đi thành công, chúng tôi sẽ phản hồi bạn sớm nhất");
        }
    }

    public String Chat() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================================");
        System.out.println("|                 Chat với quản trị viên                 |");
        System.out.println("==========================================================");
        System.out.println("Nhập tin nhắn: ");
        String message = input.nextLine();
        return message;
    }

    public int selectionChat() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================================");
        System.out.println("|                  Tùy chọn phương thức                  |");
        System.out.println("|                                                        |");
        System.out.println("| 1> Để lại thông tin để được tư vấn                     |");
        System.out.println("| 2> Trò chuyện trực tiếp với tư vấn viên                |");
        System.out.println("==========================================================");
        int choice = Integer.parseInt(input.nextLine());
        return choice;
    }

}

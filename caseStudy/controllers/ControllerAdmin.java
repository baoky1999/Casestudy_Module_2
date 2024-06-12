package Casestudy_Module_2.caseStudy.controllers;

import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.repositories.CartRepositories;
import Casestudy_Module_2.caseStudy.repositories.ChatRepo;
import Casestudy_Module_2.caseStudy.services.iml.AdminService;
import Casestudy_Module_2.caseStudy.views.ViewMenu;
import Casestudy_Module_2.caseStudy.views.ViewWareHouse;

import java.util.List;

public class ControllerAdmin {

    ViewWareHouse wareHouse = new ViewWareHouse();
    AdminService adminService = new AdminService();
    ViewMenu viewMenu = new ViewMenu();

    String message;


    public void controllerMenu() {
        int choice;
        String searchName;
        List<Product> searchList;
        double revenue;
        while (true) {
            choice = viewMenu.adminMenu();
            switch (choice) {
                case 1:
                    controllerWareHouseMenu();
                    break;
                case 2:
                    searchName = wareHouse.searchProduct();
                    searchList = adminService.seachByName(searchName);
                    wareHouse.viewTotal(searchList);
                    break;
                case 3:
                    CartRepositories.readFile1();
                    break;
                case 4:
                    break;
                case 5:
                    choice = wareHouse.selectionChat();
                    switch (choice) {
                        case 1:
                            wareHouse.chatAdmin();
                            adminService.readInfor();
                            break;
                        case 2:
                            adminService.readChat();
                            String message = wareHouse.chat();
                            adminService.chat("Quản trị viên: " + message);
                            wareHouse.notification(message);
                            break;
                    }
                    break;
                case 6:
                    wareHouse.revenue();
                    revenue = adminService.totalRevenue();
                    System. out.println(revenue + " VNĐ");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    public void controllerWareHouseMenu() {
        int choice;
        List<Product> adminProducts;
        adminProducts = adminService.getAdmins();
        wareHouse.viewTotal(adminProducts);
        Product product;
        boolean check;
        String item;
        Product adminProductRemove;
        Product adminProductEdit;
        int index;
        while (true) {
            choice =  wareHouse.viewWareHouse();

            switch (choice) {
                case 1:
                    adminProducts = adminService.getAdmins();
                    wareHouse.viewTotal(adminProducts);
                    break;
                case 2:
                    item = wareHouse.removeProduct();
                    adminProductRemove = adminService.findRemoveAdmin(item);
                    if (adminProductRemove == null) {
                        wareHouse.viewRemove(false);
                    } else {
                        check = wareHouse.isRemove(adminProductRemove);
                        if (check) {
                            adminService.removeProduct(adminProductRemove);
                            wareHouse.viewRemove(true);
                            adminProducts = adminService.getAdmins();
                            wareHouse.viewTotal(adminProducts);
                        }
                    }
                    break;
                case 3:
                    product = wareHouse.viewAdd();
                    check = adminService.addProduct(product);
                    wareHouse.viewAddMessage(check);
                    break;
                case 4:
                    item = wareHouse.editProduct();
                    adminProductRemove = adminService.findRemoveAdmin(item);
                    index = adminService.findIndexEdit(adminProductRemove);
                    if (adminProductRemove == null || index == -1) {
                        wareHouse.viewEdit(false);
                    } else {
                        adminProductEdit = wareHouse.EidtProduct(adminProductRemove);
                        adminService.editProduct(index, adminProductEdit);
                        wareHouse.viewEdit(true);
                        adminProducts = adminService.getAdmins();
                        wareHouse.viewTotal(adminProducts);

                    }

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;

            }
        }
    }
}

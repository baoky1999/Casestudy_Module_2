package Casestudy_Module_2.caseStudy.services.iml;

import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.repositories.AdminRepositories;
import Casestudy_Module_2.caseStudy.repositories.CartRepositories;
import Casestudy_Module_2.caseStudy.repositories.ChatRepo;
import Casestudy_Module_2.caseStudy.services.AdminMethod;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminMethod {
    AdminRepositories adminRepositories = new AdminRepositories();

    @Override
    public List<Product> getAdmins() {
        return adminRepositories.getAllAdmin();
    }

    @Override
    public List<Product> getAdminOder() {
        return List.of();
    }

    @Override
    public void editProduct(int index, Product adminProduct) {
        adminRepositories.editProduct(index, adminProduct);
    }

    @Override
    public double totalRevenue() {
        CartRepositories cart = new CartRepositories();
        return cart.moneyProductRevenue();
    }

    @Override
    public Product findRemoveAdmin(String admin) {
        List<Product> adminProducts = getAdmins();
        for (Product atem : adminProducts) {
            if(atem.getCodeProduct().equals(admin)) {
                return atem;
            }
        }
        return null;
    }

    @Override
    public int findIndexEdit(Product adminProduct) {
            List<Product> adminProducts = getAdmins();
            for (int i = 0; i < adminProducts.size(); i++) {
                if (adminProducts.get(i).getCodeProduct().equals(adminProduct.getCodeProduct())) {
                    return i;
                }
            }
            return -1;
    }

    @Override
    public boolean addProduct(Product product) {
        List<Product> adminProducts = getAdmins();
        for (Product atem : adminProducts) {
            if (atem.getCodeProduct().equals(product.getCodeProduct())) {
                System.err.println("Mã sản phẩm trùng lặp!");
                return false;
            }
        }
        adminRepositories.addProduct(product);
        return true;
    }

    @Override
    public void removeProduct(Product product) {
         adminRepositories.removeProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Product> getSpecialOffers() {
        return null;
    }

    @Override
    public List<Product> seachByName(String name) {
        List<Product> adminProducts = getAdmins();
        List<Product> searchAdminProduct = new ArrayList<>();
        String search = name.trim().toLowerCase();
        for (Product adminProduct : adminProducts) {
            if(adminProduct.getNameProduct().toLowerCase().contains(search)) {
                searchAdminProduct.add(adminProduct);
            }
        }
        return searchAdminProduct;
    }

    @Override
    public List<Product> sortByPrice(String price) {
        return null;
    }

    @Override
    public void chat(String message) {
        ChatRepo.writeFileChat(message,true);
    }

    @Override
    public void readChat() {
        ChatRepo.readFileChat();
    }

    public void readInfor() {
        ChatRepo.readFile();
    }

}

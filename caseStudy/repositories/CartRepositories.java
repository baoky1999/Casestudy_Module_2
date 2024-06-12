package Casestudy_Module_2.caseStudy.repositories;

import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.services.iml.CustomerService;

import java.io.*;
import java.util.*;

public class CartRepositories {
    static final String URL_CART = "D:\\Module_2\\Module2\\src\\caseStudy\\data\\GioHang.csv";
    static final String URL_STORIES = "D:\\Module_2\\Module2\\src\\caseStudy\\data\\DanhSachSanPhamDaDuocMua.csv" ;
    CustomerService customerService = new CustomerService();

    private Map<String, Integer> cart;
    public CartRepositories() {
        this.cart = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        cart = main();
        if (cart.containsKey(product.getCodeProduct())) {
            int currentQuantity = cart.get(product.getCodeProduct());
            int newQuantity = currentQuantity + quantity;
            cart.put(product.getCodeProduct(), newQuantity);
            clearFile();
            for (String key: cart.keySet()) {
                product = customerService.seachByCode(key);
                writeFile(product,true);
            }
        } else {
            cart.put(product.getCodeProduct(), quantity);
            writeFile(product, true);
        }

    }

    public double moneyProduct() {
        cart = main();
        Product product;
        int quantily;
        double count = 0;
        for (Object key: cart.keySet()) {
            quantily = cart.get(key);
            product = customerService.seachByCode((String) key);
            count += (product.getPriceProduct() * quantily);
        }
        return count;
    }

    public double moneyProductRevenue() {
        cart = mainRevenue();
        Product product;
        int quantily;
        double count = 0;
        for (Object key: cart.keySet()) {
            quantily = cart.get(key);
            product = customerService.seachByCode((String) key);
            count += (product.getPriceProduct() * quantily);
        }
        return count;
    }

    public Map removeFromCart(String productCode, int quantityToRemove) {
        cart = main();
        if (cart.containsKey(productCode)) {
            int currentQuantity = cart.get(productCode);
            int updatedQuantity = currentQuantity - quantityToRemove;
            if (updatedQuantity <= 0) {
                cart.remove(productCode); // Nếu số lượng sau khi xóa <= 0, loại bỏ sản phẩm khỏi giỏ hàng
            } else {
                cart.put(productCode, updatedQuantity);
            }
        }
        return cart;
    }

    public void displayCartRemove(Map cart) {
        clearFile();
        Product product;
        for (Object key: cart.keySet()) {
            product = customerService.seachByCode((String) key);
            writeFile(product,true);
        }
    }

    public int getQuantily(String productCode) {
        if (cart.containsKey(productCode)) {
            return cart.get(productCode);
        }
        return 0;
    }

    public String toString(Product product) {
        return "Mã sản phẩm: " + product.getCodeProduct() + ":"
                + " Tên sản phẩm: " + product.getNameProduct() + ":" + " Số lượng: " + getQuantily(product.getCodeProduct());

    }

    private void writeFile(Product adminProducts, boolean append) {
        File file = new File(URL_CART);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(toString(adminProducts));
                bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Lỗi ghi File!");
        }
    }

    public void readFile() {
        File file = new File(URL_CART);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

    public static void readFile1() {
        File file = new File(URL_STORIES);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

    public Map main() {

        Map<String, Integer> cart = new HashMap<>();
        String csvFile = URL_CART;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                    if (parts.length == 6) {
                        String key = parts[1].trim(); // Mã sản phẩm
                        int value = Integer.parseInt(parts[5].trim()); // Số lượng

                        cart.put(key, value);

                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public Map mainRevenue() {

        Map<String, Integer> cart = new HashMap<>();
        String csvFile = URL_STORIES;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 6) {
                    String key = parts[1].trim(); // Mã sản phẩm
                    int value = Integer.parseInt(parts[5].trim()); // Số lượng

                    cart.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public static void clearFile() {
        String csvFilePath = URL_CART;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {

            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(URL_CART));
            writer.close();
        } catch (IOException e) {
            System.err.println("Lỗi khi xử lý tệp CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean writeStories() {
        String inputFilePath = URL_CART;
        String outputFilePath = URL_STORIES;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
        return false;
    }
}

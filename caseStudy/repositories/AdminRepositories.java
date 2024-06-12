package Casestudy_Module_2.caseStudy.repositories;

import Casestudy_Module_2.caseStudy.models.AdminProduct;
import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.models.ProductSpecial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositories {
    static final String URL_DATA = "D:\\Module_2\\Module2\\src\\caseStudy\\data\\DanhSachSanPhamTrongKho.csv";

    List<Product> adminProducts = new ArrayList<>();


    public List<Product> getAllAdmin() {
        List<Product> adminProducts = new ArrayList<>();
        File file = new File(URL_DATA);

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tem = line.split(",");
                if (tem.length == 6) {
                    adminProducts.add(new AdminProduct(Integer.parseInt(tem[0]),tem[1],tem[2],tem[3],Integer.parseInt(tem[4]),tem[5]));
                } else {
                    adminProducts.add(new ProductSpecial(Integer.parseInt(tem[0]),tem[1],tem[2],tem[3],Integer.parseInt(tem[4]),tem[5],tem[6]));
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thất File");
        } catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu File");
        }
        return adminProducts;
    }


    public void addProduct(Product adminProduct) {
        adminProducts = getAllAdmin();
        adminProducts.add(adminProduct);
        writeFile(adminProducts, false);
    }

    public void removeProduct(Product adminProduct) {
        List<Product> adminProducts = getAllAdmin();
        int count = adminProducts.size();
        for (int i = 0; i < count; i++) {
            if (adminProducts.get(i).getCodeProduct().equals(adminProduct.getCodeProduct())) {
                adminProducts.remove(i);
                break;
            }
        }
        writeFile(adminProducts, false);
    }

    private void writeFile(List<Product> adminProducts, boolean append) {
        File file = new File(URL_DATA);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Product product : adminProducts) {
                System.out.println(product);
                if (product instanceof AdminProduct) {
                    bufferedWriter.write(toString(product));

                } else if (product instanceof ProductSpecial) {
                    bufferedWriter.write(toString1(product));
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi File!");
        }
    }

    private String toString(Product admins) {
        return admins.getStt() + "," + admins.getCodeProduct() + "," + admins.getNameProduct() + "," + admins.getProducer()
                + "," + admins.getPriceProduct() + "," + admins.getInformationProduct();
    }

    private String toString1(Product admins) {
        return admins.getStt() + "," + admins.getCodeProduct() + "," + admins.getNameProduct() + "," + admins.getProducer()
                + "," + admins.getPriceProduct() + "," + admins.getInformationProduct() + "," + ((ProductSpecial) admins).getSpecial();
    }

    public void editProduct(int index, Product adminProduct) {

        List<Product> adminProducts = getAllAdmin();
        adminProducts.set(index, adminProduct);

        writeFile(adminProducts, false);
    }

}

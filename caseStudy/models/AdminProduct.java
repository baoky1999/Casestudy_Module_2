package caseStudy.models;

public class AdminProduct extends Product{

    public AdminProduct(){}

    public AdminProduct(int stt, String codeProduct, String nameProduct, String producer, int priceProduct, String informationProduct) {
        super(stt, codeProduct, nameProduct, producer, priceProduct, informationProduct);
    }

    public String toString() {
        return "Mã code sản phẩm: " + getCodeProduct() + "\n"
                + "  Tên sản phẩm: " + getNameProduct() + "\n"
                + "  Nhà sản xuất: " + getProducer() + "\n"
                + "  Giá tiền: " + getPriceProduct() + " VNĐ" + "\n"
                + "  Thông tin nổi bật: " + getInformationProduct() + "\n";
    }
}

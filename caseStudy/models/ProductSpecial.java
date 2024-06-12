package Casestudy_Module_2.caseStudy.models;

public class ProductSpecial extends Product{

    private String special;

    public ProductSpecial() {}

    public ProductSpecial(int stt, String codeProduct, String nameProduct, String producer, int priceProduct, String informationProduct, String special) {
        super(stt, codeProduct, nameProduct, producer, priceProduct, informationProduct);
        this.special = special;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String toString() {
        return "Mã code sản phẩm: " + getCodeProduct() + "\n"
                + "  Tên sản phẩm: " + getNameProduct() + "\n"
                + "  Nhà sản xuất: " + getProducer() + "\n"
                + "  Giá tiền: " + getPriceProduct() + " VNĐ" + "\n"
                + "  Thông tin nổi bật: " + getInformationProduct() + "\n"
                + "  Giá khuyến mãi: " + getSpecial() + "\n";
    }
}

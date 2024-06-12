package caseStudy.models;

public abstract class Product {

    private int stt;
    private String codeProduct;
    private String nameProduct;
    private String Producer;
    private int priceProduct;
    private String informationProduct;

    public Product() {
    }

    public Product(int stt, String codeProduct, String nameProduct, String producer, int priceProduct, String informationProduct) {
        this.stt = stt;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.Producer = producer;
        this.priceProduct = priceProduct;
        this.informationProduct = informationProduct;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getInformationProduct() {
        return informationProduct;
    }

    public void setInformationProduct(String informationProduct) {
        this.informationProduct = informationProduct;
    }

    public String toString() {
        return getStt() + "," + getCodeProduct() + "," + getNameProduct() + "," + getProducer() + "," + getPriceProduct() + "," + getInformationProduct();
    }
}

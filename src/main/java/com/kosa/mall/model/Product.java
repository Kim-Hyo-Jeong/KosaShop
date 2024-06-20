package com.kosa.mall.model;

public class Product {
    private int prodNo;
    private String prodName;
    private double prodPrice;
    private String imageUrl;

    // 기본 생성자
    public Product() {
    }

    // 매개변수를 갖는 생성자
    public Product(int prodNo, String prodName, double prodPrice, String imageUrl) {
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.imageUrl = imageUrl;
    }

    // Getter 및 Setter 메서드
    public int getProdNo() {
        return prodNo;
    }

    public void setProdNo(int prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // toString 메서드 (객체 정보를 문자열로 반환)
    @Override
    public String toString() {
        return "Product{" +
                "prodNo=" + prodNo +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
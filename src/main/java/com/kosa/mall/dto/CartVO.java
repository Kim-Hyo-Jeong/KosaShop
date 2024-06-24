package com.kosa.mall.dto;

public class CartVO {
    private String productId;
    private String prodName;
    private double prodPrice;
    private int quantity;
    private String imageUrl;

    public CartVO(String productId, String prodName, double prodPrice, int quantity, String imageUrl) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    // Getter 및 Setter 메서드 추가
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
package com.kosa.mall.dao;

import java.util.HashMap;
import java.util.Map;

import com.kosa.mall.dto.CartVO;

public class CartDAO {
    private Map<String, CartVO> items;

    public CartDAO() {
        items = new HashMap<>();
    }

    public Map<String, CartVO> getItems() {
        return items;
    }

    public void addProduct(String productId, String prodName, double prodPrice, int quantity, String imageUrl) {
        if (items.containsKey(productId)) {
            CartVO item = items.get(productId);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartVO newItem = new CartVO(productId, prodName, prodPrice, quantity, imageUrl);
            items.put(productId, newItem);
        }
    }
    
    public void removeProduct(String productId) {
        items.remove(productId);
    }

    public void updateQuantity(String productId, int quantity) {
        if (items.containsKey(productId)) {
            CartVO item = items.get(productId);
            item.setQuantity(quantity);
        }
    }
    
    public void updateProduct(String productId, int quantity) {
        updateQuantity(productId, quantity);
    }
}

package com.kosa.mall.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void addProduct(String productId, String prodName, double prodPrice, int quantity, String imageUrl) {
        if (items.containsKey(productId)) {
            CartItem item = items.get(productId);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(productId, prodName, prodPrice, quantity, imageUrl);
            items.put(productId, newItem);
        }
    }
    
    public void removeProduct(String productId) {
        items.remove(productId);
    }

    public void updateQuantity(String productId, int quantity) {
        if (items.containsKey(productId)) {
            CartItem item = items.get(productId);
            item.setQuantity(quantity);
        }
    }
    
    public void updateProduct(String productId, int quantity) {
        updateQuantity(productId, quantity);
    }
}

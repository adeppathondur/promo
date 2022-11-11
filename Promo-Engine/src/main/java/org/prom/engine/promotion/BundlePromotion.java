package org.prom.engine.promotion;



import org.prom.engine.model.Cart;
import org.prom.engine.model.Product;
import org.prom.engine.util.PriceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BundlePromotion implements Promotion {
    private List<String> appliedItems = new ArrayList<>();
    private Double promotedPrice;
    private Map<String, Boolean> availabilityCheckMap = new HashMap<>();

    public BundlePromotion(List<String> items, Double promotedPrice) {
        this.appliedItems.addAll(items);
        this.promotedPrice = promotedPrice;
    }

    /**
     * Applies the bundle promotion to a cart and adjusts the cart contents once applied
     * @param cart
     * @return
     */
    @Override
    public Cart applyPromotion(Cart cart) {
        if(!isAvailable(cart)) {
            System.out.println("There is no available item in this cart.");
        }

        Cart promotedCart = new Cart(cart.getContents());
        Map<Product, Integer> cartContents = new HashMap<>(cart.getContents());

        for(String item: appliedItems){
            if(promotedCart.getQuantity(item)==1) {
                cartContents.remove(promotedCart.getEntryByItemName(item));
            }
            else {
                cartContents.putAll(promotedCart.adjustInventory(item,promotedCart.getQuantity(item)-1));
            }
        }
        promotedCart.setContents(cartContents);
        return promotedCart;
    }

    /*
    * Returns true if the bundle promotion is applicable to the current cart contents
    * */
    @Override
    public Boolean isAvailable(Cart cart) {
        appliedItems.forEach(i -> availabilityCheckMap.put(i, false));

        for (Map.Entry<Product, Integer> kv: cart.getContents().entrySet()) {
            if (appliedItems.contains(kv.getKey().getName())) {
                availabilityCheckMap.put(kv.getKey().getName(), true);
            }
        }
        // todo: make sure all applied items occur in the cart.
        return !availabilityCheckMap.containsValue(false);
    }

    /**
     * Returns the discounted price after promotion applied
     * @return
     */
    @Override
    public Double getDiscountedPrice() {
        double itemPrice = 0.0;
        for(String sku: appliedItems)
            itemPrice += PriceList.getPrice(sku);

        return itemPrice - this.promotedPrice;
    }
}

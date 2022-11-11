package org.prom.engine.promotion;


import org.prom.engine.model.Cart;

/**
 * Promotion contract
 */
public interface Promotion {
    // Applies the promotion to the cart and returns the rest of the cart
    Cart applyPromotion(Cart cart);

    // Checks if promotion is available for the cart contents
    Boolean isAvailable(Cart cart);

    // Returns the discounted price after the promotion applied
    Double getDiscountedPrice();
}

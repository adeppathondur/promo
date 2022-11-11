package org.prom.engine.service;



import org.prom.engine.model.Cart;
import org.prom.engine.promotion.Promotion;

import java.util.List;

/**
 * Promotion Service Interface
 */
public interface PromotionService {
    /**
     * Returns the checkout total before applying the promotions.
     * @param cart
     * @return
     */
    public Double getRawPrice(Cart cart);

    /**
     * Returns the price after promotions are applied.
     * @param cart
     * @param promotions
     * @return
     */
    public Double getPromotedPrice(Cart cart, List<Promotion> promotions);
}

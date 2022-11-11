package org.prom.engine;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.prom.engine.model.Product;

public class ProductTest {
    @Test
    public void testProductCreation() {
        Product product = new Product("A", 50);
        Assertions.assertEquals(50, product.getPrice());
        Assertions.assertEquals("A", product.getName());
        Assertions.assertNotNull(product, "Unable to create a product instance.");
    }
}

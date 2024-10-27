package com.hoangiang.nhom5;

import com.hoangiang.nhom5.entites.Order;
import com.hoangiang.nhom5.entites.Product;
import com.hoangiang.nhom5.repository.IApplicationDbContext;
import com.hoangiang.nhom5.service.OrderService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTests {
    private IApplicationDbContext dbContext;
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        dbContext = mock(IApplicationDbContext.class);
        orderService = new OrderService(dbContext);
    }

    @Test
    public void testAddProductToOrder() {
        Order order = new Order();
        Product product1 = new Product(1L, "Sản phẩm A", 1);
        Product product2 = new Product(1L, "Sản phẩm A", 2); // Same product
        Product product3 = new Product(2L, "Sản phẩm B", 2); //

        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        // Print statements for debugging
        System.out.println("Sản phẩm trong giỏ hàng: " + order.getProducts().size());
        System.out.println("Tổng sản phẩm " + order.getProducts().get(1).getName()
                + ": " + order.getProducts().get(1).getQuantity());

        assertEquals(2, order.getProducts().size());
        assertEquals(2, order.getProducts().get(1).getQuantity());
    }

    @Test
    public void testSaveOrder() {
        Order order = new Order();
        Product product1 = new Product(1L, "Sản phẩm A", 3);
        Product product2 = new Product(2L, "Sản phẩm B", 3);
        order.addProduct(product1);
        order.addProduct(product2);

        orderService.saveOrder(order);

        //xác nhận saveOrder được gọi mock dbContext
        verify(dbContext).saveOrder(order);
    }
}
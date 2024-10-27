package com.hoangiang.nhom5.service;

import com.hoangiang.nhom5.entites.Order;
import com.hoangiang.nhom5.entites.Product;
import com.hoangiang.nhom5.repository.IApplicationDbContext;

public class OrderService {
    private IApplicationDbContext dbContext;

    public OrderService(IApplicationDbContext dbContext) {
        this.dbContext = dbContext;
    }

    public void saveOrder(Order order) {
        // Logic to save the order to the database using dbContext
        dbContext.saveOrder(order);

        System.out.println("Đơn hàng đã được lưu với các sản phẩm:");

        for (Product product : order.getProducts()) {
            System.out.println("Tên sản phẩm: " + product.getName() + ", Số lượng: " + product.getQuantity());
        }
    }
}

package com.hoangiang.nhom5.repository;

import com.hoangiang.nhom5.entites.Order;

public interface IApplicationDbContext {
    void saveOrder(Order order);
}

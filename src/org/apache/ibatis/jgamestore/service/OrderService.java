package org.apache.ibatis.jgamestore.service;

import org.apache.ibatis.jgamestore.domain.Order;

import com.ibatis.common.util.PaginatedList;

public interface OrderService {

    public abstract void insertOrder(Order order);

    public abstract Order getOrder(int orderId);

    public abstract PaginatedList getOrdersByUsername(String username);

    public abstract int getNextId(String key);

}
package com.niit.dao;

import com.niit.bean.OrderDetail;

public interface OrderDao {

	public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);

}

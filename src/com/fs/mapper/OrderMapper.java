package com.fs.mapper;

import com.fs.entity.Order;


public interface OrderMapper {
	/*添加订单信息信息*/
	public int addOrderInfo(Order order) throws Exception;
	
	/*根据主键查询某条商品信息记录*/
	public Order findById(int ptid) throws Exception;

	/*删除商品信息记录*/
	public void deleteProductInfo(int ptid) throws Exception;

}

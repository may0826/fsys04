package com.fs.mapper;


import java.util.List;

import com.fs.entity.Product;
import com.fs.entity.Ptype;

public interface PtypeMapper {
	/*添加商品类型信息*/
    public int addPtypeInfo(Ptype ptype) throws Exception;
	
	/*根据主键查询某条商品类型记录*/
	public List<Product> findByPtid(int ptid) throws Exception;

	/*删除商品类型记录*/
	public void deletePtypeInfo(int ptid) throws Exception;

}

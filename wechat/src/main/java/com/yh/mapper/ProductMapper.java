package com.yh.mapper;

import com.yh.domain.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 根据二级类目id查询所包括的所有商品分类(所有已上架的)
     * @param secondTypeId
     * @return
     */
    List<Product> selectAllThirdTypeBySecondTypeId(Integer secondTypeId);

    /**
     * 根据商品id查询商品详情
     * @return
     */
    Product selectProductDetail(Integer id);

}
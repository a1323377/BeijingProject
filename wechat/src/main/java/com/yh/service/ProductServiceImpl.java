package com.yh.service;

import com.yh.domain.Product;
import com.yh.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据二级类目id查询所包括的所有商品分类(所有已上架的)
     * @param secondTypeId
     * @return
     */
    @Override
    public List<Product> selectAllThirdTypeBySecondTypeId(Integer secondTypeId) {
        return productMapper.selectAllThirdTypeBySecondTypeId(secondTypeId);
    }

    /**
     * 根据商品id查询商品详情
     * @return
     */
    @Override
    public Product selectProductDetail(Integer id) {
        return productMapper.selectProductDetail(id);
    }

}

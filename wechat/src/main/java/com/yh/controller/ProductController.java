package com.yh.controller;

import com.yh.domain.Product;
import com.yh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 根据二级类目id查询所包括的所有商品分类(所有已上架的)
     * @param secondTypeId
     * @return
     */
    @RequestMapping(value = "selectAllThirdTypeBySecondTypeId")
    public List<Product> selectAllThirdTypeBySecondTypeId(Integer secondTypeId){
        return productService.selectAllThirdTypeBySecondTypeId(secondTypeId);
    }

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    @RequestMapping("selectProductDetail")
    public Product selectProductDetail(Integer id){
        return  productService.selectProductDetail(id);
    }

}

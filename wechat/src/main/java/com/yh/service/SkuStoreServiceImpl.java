package com.yh.service;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.mapper.SkuStoreMapper;
import com.yh.domain.SkuStore;
import com.yh.service.SkuStoreService;
import java.util.List;
import java.util.Map;
@Service
public class SkuStoreServiceImpl implements SkuStoreService{

    @Resource
    private SkuStoreMapper skuStoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return skuStoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SkuStore record) {
        return skuStoreMapper.insert(record);
    }

    @Override
    public int insertSelective(SkuStore record) {
        return skuStoreMapper.insertSelective(record);
    }

    @Override
    public SkuStore selectByPrimaryKey(Integer id) {
        return skuStoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SkuStore record) {
        return skuStoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SkuStore record) {
        return skuStoreMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, String>> selectSkuOrderByCreateTime() {
        return skuStoreMapper.selectSkuOrderByCreateTime();
    }

    @Override
    public List<Map<String, String>> selectSkuRush() {
        return skuStoreMapper.selectSkuRush();
    }

    @Override
    public Map<String, String> selectSkuDetail(int skuId) {
        return skuStoreMapper.selectSkuDetail(skuId);
    }

    @Override
    public List<Map<String, String>> selectSkuScrollImg(int skuId) {
        return skuStoreMapper.selectSkuScrollImg(skuId);
    }

    @Override
    public List<Map<String, String>> selectSkuByProductId(int productId) {
        return skuStoreMapper.selectSkuByProductId(productId);
    }

    @Override
    public SkuStore selectSku(int skuId) {
        return skuStoreMapper.selectSkuBySkuId(skuId);
    }
}

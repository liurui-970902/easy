package com.liurui.Service.Impl;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liurui.Dao.BaseDao;
import com.liurui.Dao.ProductMapper;
import com.liurui.Service.ProductService;
import com.liurui.pojo.EasybuyCollect;
import com.liurui.pojo.EasybuyOrderDetail;
import com.liurui.pojo.EasybuyProduct;
import com.liurui.utils.Pager;


/**
 * 商品信息业务逻辑层实现类！
 * 
 * @author Administrator
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * 使用Logger记录日志！
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	
	@Autowired
	private ProductMapper promapper;
	
	
	

	@Override
	/**
	 * 获取所有商品信息！
	 * 
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductList() {
		return promapper.getEasybuyProductList();
	}

	@Override
	/**
	 * 获取一级分类总记录数！
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getProductRowCount(int categoryId) {
		return promapper.getProductRowCount(categoryId);
	}

	/**
	 * 获取二级分类总记录数！
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getProductRowCount2(int categoryId) {
		return promapper.getProductRowCount2(categoryId);
	}

	/**
	 * 获取三级分类总记录数！
	 * 
	 * @param categoryId
	 * @return
	 */
	public int getProductRowCount3(int categoryId) {
		return promapper.getProductRowCount3(categoryId);
	}

	@Override
	/**
	 * 获得商品一级分类！
	 * 
	 * @param categoryId
	 * @param pager
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductListByCategoryId(int categoryId, Pager pager,String productName) {
		return promapper.getEasybuyProductListByCategoryId(categoryId, pager, productName);
	}

	/**
	 * 获得商品二级分类！
	 * 
	 * @param categoryId
	 * @param pager
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductListByCategoryId2(int categoryId, Pager pager) {
		return promapper.getEasybuyProductListByCategoryId2(categoryId, pager);
	}

	/**
	 * 获得商品三级分类！
	 * 
	 * @param categoryId
	 * @param pager
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductListByCategoryId3(int categoryId, Pager pager) {
		return promapper.getEasybuyProductListByCategoryId3(categoryId, pager);
	}

	@Override
	/**
	 * 根据ID获取信息！
	 * 
	 * @param tid
	 * @return
	 */
	public EasybuyProduct findById(int id) {
		return promapper.findEasybuyProductById(id);
	}

	@Override
	/**
	 * 查询用户收藏夹！
	 * 
	 * @param list
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductListByUser(List<EasybuyCollect> list) {
		return null;
	}

	@Override
	/**
	 * 订单表！
	 * 
	 * @param list
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductListByOrder(List<EasybuyOrderDetail> list) {
		return null;
	}

	// ***************************
	@Override
	/**
	 * 商品管理！
	 * 
	 * @param pager
	 * @return
	 */
	public List<EasybuyProduct> getEasybuyProductAll(Pager pager) {
		return null;
	}

	@Override
	/**
	 * 获取总记录数！
	 */
	public int getTotalCount() {
		return promapper.findTotalCount();
	}

	@Override
	/**
	 * 根据ID删除指定商品信息！
	 */
	public int delEasybuyProductById(int id) {
		return promapper.deleteEasybuyProductById(id);
	}

	@Override
	/**
	 * 商品上架
	 * 
	 * @param easybuyProduct
	 * @return
	 */
	public int addEasybuyProduct(EasybuyProduct easybuyProduct) {
		return promapper.insertEasybuyProduct(easybuyProduct);
	}

	@Override
	/**
	 * 根据Id查询对应的商品信息！
	 * 
	 * @param id
	 * @return
	 */
	public EasybuyProduct getEasybuyProductById(int id) {
		return promapper.getById(id);
	}

	/**
	 * 显示所有商品信息 (后端显示)
	 */
	public List<EasybuyProduct> getAllProduct(Pager pager) {
		return promapper.getAllProduct(pager);
	}

	/**
	 * 商品修改
	 */
	public int updateEasybuyProduct(EasybuyProduct pro) {
		return promapper.updateEasybuyProduct(pro);
	}

	/**
	 * 获得模糊查询信息条数
	 */
	public int getmohuCount(String proName) {
		return promapper.getmohuCount(proName);
	}

}

package com.liurui.Service.Impl;


import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liurui.Dao.EasybuyCollectMapper;
import com.liurui.Service.CartService;
import com.liurui.pojo.EasybuyCollect;

/**
 * 购物车业务逻辑层实现类！！
 * @author Administrator
 *
 */
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private EasybuyCollectMapper easybuyCollectMapper;
	

    /**
     * 添加收藏！
     */
	@Override
	public int addCollect(int userId, int productId, int productNum, int type) {
		return easybuyCollectMapper.addCollect(userId, productId, productNum, type);
	}

	@Override
	/**
     * 根据ID查询购物车！
     * @param userId
     * @param productId
     * @return
     */
	public List<EasybuyCollect> selectId(int userId) {
		return easybuyCollectMapper.selectId(userId);
	}

	@Override
	/**
     * 查询用户的收藏夹！
     * @param userId
     * @return
     */
	public List<EasybuyCollect> selectByUserId(int userId) {
		return easybuyCollectMapper.selectByUserId(userId);
	}

	/**
	 * 删除
	 */
	public int delCollect(EasybuyCollect easybuyCollect) {
		return easybuyCollectMapper.delCollect(easybuyCollect);
	}

	/**
	 * 判断用户是否重复收藏
	 */
	public int checkCollect(int userId, int productId) {
		return easybuyCollectMapper.checkCollect(userId, productId);
	}

	/**
	 * 购物车商品数量+1
	 */
	public int addNum(int userId, int productId) {
		return easybuyCollectMapper.addNum(userId, productId);
	}

	/**
	 * 购物车商品是否重复
	 */
	public int checkCart(int userId, int productId) {
		return easybuyCollectMapper.checkCart(userId, productId);
	}

	/**
	 * 购物车商品数量-1
	 */
	public int jianNum(int userId, int productId) {
		return easybuyCollectMapper.jianNum(userId, productId);
	}

	/**
	 * 清空该用户所有购物车
	 */
	public int delCart(int userId) {
		return easybuyCollectMapper.delCart(userId);
	}

	
}

package com.liurui.Service.Impl;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liurui.Dao.BaseDao;
import com.liurui.Dao.NewsMapper;
import com.liurui.Service.NewsService;
import com.liurui.pojo.EasybuyNews;
import com.liurui.utils.Pager;

/**
 * 资讯列表业务逻辑层实现类！
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {

	/**
	 * 使用Logger记录日志！
	 */
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	@Autowired
	private NewsMapper newsmapper;
	
	

	@Override
	/**
	 * 获取资讯列表业务！
	 * @param pager
	 * @return
	 */
	public List<EasybuyNews> queryNewsList(Pager pager) {
		return newsmapper.queryNewsList(pager);
	}

	@Override
	/**
	 * 获取资讯列表总记录数业务！
	 * @return
	 */
	public int getTotalCount() {
		return newsmapper.getTotalCount();
	}
	
	/**
	 * 根据ID获取资讯列表详情业务！
	 * @param id
	 * @return
	 */
	public EasybuyNews findNewsById(int id) {
		return newsmapper.getNewsById(id);
	}

}

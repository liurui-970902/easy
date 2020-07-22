package com.liurui.api;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liurui.Dao.NewsMapper;
import com.liurui.Dao.ProductCategoryMapper;
import com.liurui.Dao.ProductMapper;
import com.liurui.Service.NewsService;
import com.liurui.Service.ProductCategoryService;
import com.liurui.Service.ProductService;
import com.liurui.Service.Impl.NewsServiceImpl;
import com.liurui.Service.Impl.ProductCategoryServiceImpl;
import com.liurui.Service.Impl.ProductServiceImpl;
import com.liurui.pojo.EasybuyNews;
import com.liurui.pojo.EasybuyProduct;
import com.liurui.pojo.EasybuyProductCategory;
import com.liurui.utils.Pager;


/**
 * Servlet implementation class IndexServlet
 */
@Controller
 @RequestMapping("IndexServlet/")
public class IndexServlet{
   
	 @Autowired
	 private ProductCategoryService pcsi;
	 @Autowired
	 private NewsService nsi;
	 @Autowired
	 private ProductService psi;
	/**
	 * 主页面加载
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//SqlSession ss = MyBatisUtil.getSqlSession();
		//加载全部商品信息
		List<EasybuyProduct> productList = psi.getEasybuyProductList();
		//创建分页工具对象
		Pager pager = new Pager(nsi.getTotalCount(),5,1);
		List<EasybuyNews> newsList = nsi.queryNewsList(pager);
		//加载分类
		List<EasybuyProductCategory> list = pcsi.getProductCategoryListOne();
		List<EasybuyProductCategory> list2 = pcsi.getProductCategoryListTwo();
		List<EasybuyProductCategory> list3 = pcsi.getProductCategoryListThree();
		//MyBatisUtil.closeSqlSession(ss);
		//存到request作用域中
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("newsList", newsList);
		request.setAttribute("productList", productList);
		
		return "/pre/Index";
	}


}

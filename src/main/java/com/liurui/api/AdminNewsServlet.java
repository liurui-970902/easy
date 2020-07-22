package com.liurui.api;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liurui.Service.NewsService;
import com.liurui.pojo.EasybuyNews;
import com.liurui.utils.Pager;


/**
 * 新闻资讯列表控制层！
 * Servlet implementation class AdminNewsServlet
 */
@Controller
@RequestMapping("AdminNewsServlet/")
public class AdminNewsServlet{
	private static final long serialVersionUID = 1L;
    
	@Autowired
    private NewsService  nsi;
	
	
	
	/**
	 * 获取资讯列表信息！
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryNewsList")
	public String queryNewsList(HttpServletRequest request,Model model, HttpServletResponse response) throws Exception {
		int currentPage = 1;  //默认显示第一页
		//判断是否用户指定参数
		if(null != request.getParameter("currentPage")){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		//得到总记录数
		int count = nsi.getTotalCount();
		//创建pager对象
		Pager pager = new Pager(count,10,currentPage);
		//设置url
		pager.setUrl("/spring/AdminNewsServlet/queryNewsList");
		//得到所有咨询
		List<EasybuyNews> list = nsi.queryNewsList(pager);
		//存储到request中
		model.addAttribute("newsList", list);
		model.addAttribute("pager", pager);
		return "/backend/news/newsList";
	}
	
   
	
	/**
	 * 新闻详情！
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("newsDeatil")
	public String newsDeatil(HttpServletRequest request,HttpServletResponse response)throws Exception{
		int id = Integer.parseInt(request.getParameter("newsId"));
		//得到当前新闻详情
		EasybuyNews news = nsi.findNewsById(id);
		//存储到request中
		request.setAttribute("news", news);
		return "/backend/news/newsDetail";
	}

	


}

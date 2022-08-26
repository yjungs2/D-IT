package com.bnk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
		Item item = ItemDao.getInstance().getItem(itemnumber);
		ItemDao.getInstance().updateRecordCount(itemnumber); // 조회수 업데이트
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}
}
package com.ktds.admin.operation.history.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.admin.operation.history.service.OperationHistoryService;
import com.ktds.admin.operation.history.vo.OperationHistoryListVO;
import com.ktds.admin.operation.history.vo.OperationHistorySearchVO;
import com.ktds.common.util.pager.ClassicPageExplorer;
import com.ktds.common.util.pager.PageExplorer;

@Controller
public class OperationHistoryController {
	
	private OperationHistoryService operationHistoryService;

	public void setOperationHistoryService(OperationHistoryService operationHistoryService) {
		this.operationHistoryService = operationHistoryService;
	}
	
	@RequestMapping("/admin/history")
	public ModelAndView viewHistoryPage(OperationHistorySearchVO historySearchVO){
		OperationHistoryListVO historyList = operationHistoryService.getAllHistory(historySearchVO);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(historyList.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "", "", "searchHistroyForm");
		
		ModelAndView view = new ModelAndView();
		view.addObject("historyList", historyList.getOperationHistoryList());
		view.addObject("page", page);
		view.addObject("searchVO", historySearchVO);
		view.setViewName("admin/history");
		return view;
	}

}

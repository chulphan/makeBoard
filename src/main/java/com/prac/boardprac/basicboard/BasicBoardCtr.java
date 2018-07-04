package com.prac.boardprac.basicboard;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicBoardCtr {
	@Autowired
	private BasicBoardSvc svc;
	
	@RequestMapping(value="basicList")
	public String basicList(ModelMap modelMap) throws Exception {
		List<?> listView = svc.selectBoardList();
		
		modelMap.addAttribute("listView", listView);
		
		return "basicBoard/basicList";
	}
	
	@RequestMapping(value="writeBoardForm")
	public String writeBoardForm() throws Exception {
		
		return "basicBoard/writeBoardForm";
	}
	
	@RequestMapping(value="saveWrite")
	public String saveWrite(@ModelAttribute BasicBoardVO boardInfo) throws Exception {
		
		svc.insertBoard(boardInfo);
		
		return "redirect:/basicList";
		
	}
	
	@RequestMapping(value="basicBoardRead")
	public String basicBoardRead(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String brdno = req.getParameter("brdno");
		BasicBoardVO boardInfo = svc.selectBoard(brdno);
		
		modelMap.addAttribute("boardInfo", boardInfo);
		
		return "basicBoard/boardRead";
	}
	
	@RequestMapping(value="deleteBoard")
	public String deleteBoard(HttpServletRequest req) throws Exception {
		String brdno = req.getParameter("brdno");
		
		svc.deleteBoard(brdno);
		
		return "redirect:/basicList";
	}
	
	@RequestMapping(value="updateBoard")
	public String updateBoard(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String brdno = req.getParameter("brdno");
		
		BasicBoardVO boardInfo = svc.selectBoard(brdno);
		
		modelMap.addAttribute("boardInfo", boardInfo);
		
		return "basicBoard/updateBoard";
	}
	
	@RequestMapping(value="updateBoardSave")
	public String updateBoardSave(@ModelAttribute BasicBoardVO boardInfo) throws Exception {
		
		svc.updateBoard(boardInfo);
		
		return "redirect:/basicList";
	}
}

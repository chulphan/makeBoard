package com.prac.boardprac.basic3board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prac.boardprac.common.SearchVO;

@Controller
public class Board3Controller {
	
	@Autowired
	Board3Service boardSvc;
	
	@RequestMapping(value="/board3List")
	public String boardList(SearchVO searchVO, ModelMap modelMap) throws Exception {
		
		searchVO.pageCalculate( boardSvc.selectBoardCount(searchVO) );
		
		List<?> listView = boardSvc.selectBoardList(searchVO);
		
		modelMap.addAttribute("listView", listView);
		modelMap.addAttribute("searchVO", searchVO);
		
		return "board3/boardList";
	}
	
	@RequestMapping(value="/board3Form")
	public String boardForm(HttpServletRequest req, ModelMap modelMap) throws Exception {
		String brdno = req.getParameter("brdno");
		
		if(brdno != null) {
			Board3VO boardInfo = boardSvc.selectBoardOne(brdno);
			modelMap.addAttribute("boardInfo", boardInfo);
		}
		
		return "board3/boardForm";
	}
	
	@RequestMapping(value="/board3Save")
	public String boardSave(Board3VO boardInfo) throws Exception {
		boardSvc.insertBoard(boardInfo);
		
		return "redirect:/board3List";
	}
	
	@RequestMapping(value="/board3Read")
	public String boardRead(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String brdno = req.getParameter("brdno");
		
		boardSvc.updateBoard3Read(brdno);
		Board3VO boardInfo = boardSvc.selectBoardOne(brdno);
		
		modelMap.addAttribute("boardInfo", boardInfo);
		
		return "board3/boardRead";
	}
	
	@RequestMapping(value="/board3Delete")
	public String boardDelete(HttpServletRequest req) throws Exception {
		String brdno = req.getParameter("brdno");
		
		boardSvc.deleteBoardOne(brdno);
		
		return "redirect:/board3List";
	}
}

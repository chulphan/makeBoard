package com.prac.boardprac.basic2board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prac.boardprac.common.PageVO;

@Controller
public class Basic2BoardCtr {
	@Autowired
	private Basic2BoardSvc boardSvc;
	
	@RequestMapping(value="/board2List")
	public String boardList(PageVO pageVO, ModelMap modelMap) throws Exception {
		
		
		pageVO.pageCalculate(boardSvc.selectBoardCount()); // startRow, endRow
		

		System.out.println(pageVO.getPage());
		System.out.println(pageVO.getTotRow());
		
		List<?> listView = boardSvc.selectBoardList(pageVO);
		
		modelMap.addAttribute("listView", listView);
		modelMap.addAttribute("pageVO", pageVO);
		
		return "basic2Board/basic2BoardList";
	}
	
	@RequestMapping(value="/board2Form")
	public String boardForm(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String brdno = req.getParameter("brdno");
		
		if(brdno != null) {
			
			Basic2BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
			
			modelMap.addAttribute("boardInfo", boardInfo);
			
		}
		
		return "basic2Board/board2Form";
	}
	
	@RequestMapping(value="/board2Save")
	public String boardSave(Basic2BoardVO boardInfo) throws Exception {
		
		if(boardInfo.getBrdno() == null || "".equals(boardInfo.getBrdno())) 
			boardSvc.insertBoard(boardInfo);
		else
			boardSvc.updateBoard(boardInfo);
		
		return "redirect:/board2List";
	}
	
	@RequestMapping(value="/board2Read")
	public String boardRead(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String brdno = req.getParameter("brdno");
		
		boardSvc.updateBoard2Read(brdno);
		Basic2BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
		
		modelMap.addAttribute("boardInfo", boardInfo);
		
		return "basic2Board/board2Read";
	}
	
	@RequestMapping(value="/board2Delete")
	public String boardDelete(HttpServletRequest req) throws Exception {
		
		String brdno = req.getParameter("brdno");
		
		boardSvc.deleteBoardOne(brdno);
		
		return "redirect:/board2List";
	}
}

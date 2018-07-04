package com.prac.boardprac.basic2board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.boardprac.common.PageVO;

@Service
public class Basic2BoardSvc {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("selectBoard2Count");
	}
	
	public List<?> selectBoardList(PageVO param) throws Exception {
		return sqlSession.selectList("selectBoard2List", param);
	}
	
	public Basic2BoardVO selectBoardOne(String param) throws Exception {
		return sqlSession.selectOne("selectBoard2One", param);
	}
	
	public void insertBoard(Basic2BoardVO param) throws Exception {
		sqlSession.insert("insertBoard2", param);
	}
	
	public void updateBoard(Basic2BoardVO param) throws Exception {
		sqlSession.insert("updateBoard2", param);
	}
	
	public void updateBoard2Read(String param) throws Exception {
		sqlSession.insert("updateBoard2Read", param);
	}
	
	public void deleteBoardOne(String param) throws Exception {
		sqlSession.delete("deleteBoard2One", param);
	}
}

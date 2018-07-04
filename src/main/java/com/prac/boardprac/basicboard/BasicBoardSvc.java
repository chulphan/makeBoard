package com.prac.boardprac.basicboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicBoardSvc {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<?> selectBoardList() throws Exception {
		return sqlSession.selectList("selectBoardList");
	}
	
	public void insertBoard(BasicBoardVO param) throws Exception {
		sqlSession.insert("insertBoard", param);
	}
	
	public BasicBoardVO selectBoard(String param) throws Exception {
		return sqlSession.selectOne("selectBoard", param);
	}
	
	public void deleteBoard(String param) throws Exception {
		sqlSession.delete("deleteBoard", param);
	}
	
	public void updateBoard(BasicBoardVO param) throws Exception {
		sqlSession.insert("updateBoard", param);
	}
}

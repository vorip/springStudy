package co.kr.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public <T> T selectOne(String queryId, Object parameter) {
		return sqlSession.selectOne(queryId, parameter);
	}
	public <T> T selectOne(String queryId) {
		return sqlSession.selectOne(queryId);
	}
	
	public <E> List<E> selectList(String queryId, Object parameter) {
		return sqlSession.selectList(queryId, parameter);
	}
	
	public <E> List<E> selectList(String queryId) {
		return sqlSession.selectList(queryId);
	}
	
	public void insert(String queryId, Object parameter) {
		sqlSession.insert(queryId, parameter);
	}
	
	public void update(String queryId, Object parameter) {
		sqlSession.update(queryId, parameter);
	}
	
	public void delete(String queryId, Object parameter) {
		sqlSession.delete(queryId, parameter);
	}
}

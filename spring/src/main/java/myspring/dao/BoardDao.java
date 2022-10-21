package myspring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.Board;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;

	public int insert(Board board) {
		return session.insert("insert", board);
	}
	
	public int getCount() {
		return session.selectOne("count");
	}
	
	public List<Board> getBoardList(int page){
		return session.selectList("list", page);
	}

	public void updatecount(int no) {
		// TODO Auto-generated method stub
		session.update("hit", no);
	}

	public Board getBoard(int no) {
		// TODO Auto-generated method stub
		return session.selectOne("content", no);   // "불러올 ID", 불러올 값
	}

	public int update(Board board) {
		// TODO Auto-generated method stub
		return session.update("update", board);
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		return session.delete("delete", no);
	}
}

package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class BoardDAO extends DAO{
	
	private static BoardDAO boardDao = new BoardDAO();
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		return boardDao;
	}
	
	public List<Board> getBoardList(){
		List<Board> list = new ArrayList<>();
		Board board = null;
		
		try {
			conn();
			String sql = "SELECT * FROM BOARD1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setIndexNo(rs.getInt("index_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setMemberName(rs.getString("member_name"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setMemberId(rs.getInt("member_id"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int updateBoard(Board board) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE INDEX_NO = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getIndexNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
}

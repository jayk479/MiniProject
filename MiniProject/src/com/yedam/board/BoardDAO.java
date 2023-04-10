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
	
	public List<BoardDTO> getBoardList(){
		List<BoardDTO> list = new ArrayList<>();
		BoardDTO board1 = null;
		
		try {
			conn();
			String sql = "SELECT * FROM BOARD1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board1 = new BoardDTO();
				board1.setTitleNo(rs.getInt("title_no"));
				board1.setTitle(rs.getString("title"));
				board1.setContent(rs.getString("content"));
				board1.setWriter(rs.getString("writer"));
				board1.setWriteDate(rs.getDate("write_date"));
				list.add(board1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int updateBoard(BoardDTO board) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE BOARD1 SET TITLE = ?, CONTENT = ? WHERE TITEL_NO = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getTitleNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
}

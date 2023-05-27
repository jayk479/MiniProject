package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{
private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDao;
	}
		
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM MEMBER WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member; 
	}
	
	public int memberAdd(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO MEMBER (member_id, member_name, grade, id, pw) VALUES ((SELECT MAX(member_id)+1 FROM MEMBER), ?, 'NS', ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	

	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		
		try {
			conn();
			String sql = "SELECT member_id, member_name, grade, id FROM MEMBER ORDER BY GRADE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getInt("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setGrade(rs.getString("grade"));
				member.setId(rs.getString("id"));
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int updateMemberGrade(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE MEMBER SET GRADE = ? WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getGrade());
			pstmt.setInt(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
				
		return result;
	}
}

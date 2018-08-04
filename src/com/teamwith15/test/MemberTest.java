package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamwith15.dao.MemberDAO;
import com.teamwith15.dto.MemberDTO;
import com.teamwith15.vo.MemberSimpleVO;

class MemberTest {

	private SqlSessionFactory factory;
	private MemberDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void addMember() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("memberId", "kim");
			map.put("memberPassword", "kim1234");
			MemberDTO m = mapper.searchMember(map);
			m.setMemberId("kim2");
	
			int result = mapper.addAdminMember(m);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void addAdminMember() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("memberId", "kim");
			map.put("memberPassword", "kim1234");
			MemberDTO m = mapper.searchMember(map);
			m.setMemberId("kim2");
	
			int result = mapper.addAdminMember(m);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void updateMemberStatus() {
		try {
			MemberDTO m = new MemberDTO();
	
			int result = mapper.updateMemberStatus("jo");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void updateNonMember() {
		try {
			MemberDTO m = new MemberDTO();
	
			int result = mapper.updateNonMember("jo");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void updateMember() {
		try {
			MemberDTO m = new MemberDTO();
			m.setMemberId("jo");
			m.setMemberPhone("a");
			m.setMemberPublic(1);
			int result = mapper.updateMember(m);
			System.out.println(result);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void updatePassword() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("memberId", "jo");
			map.put("memberPassword", "jo1234");
			map.put("newMemberPassword", "jo123");
			int result = mapper.updatePassword(map);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void searchAll() {
		try {
			List<MemberDTO> list = mapper.searchAll();
			for (MemberDTO mem : list) {
				System.out.println(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void searchMember() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("memberId", "jo");
			map.put("memberPassword", "jo1234");
			MemberDTO m = mapper.searchMember(map);
	
				System.out.println(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void searchMemberWithCondition() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("condition", "member_auth");
			map.put("value", "0");
			List<MemberDTO> m = mapper.searchMemberWithCondition(map);
			
				System.out.println(m.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchMemberByRoleRegion() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("roleId", "role-1");
			map.put("regionId1", "region-1");
			List<MemberSimpleVO> m = mapper.searchMemberByRoleRegion(map);
			
				System.out.println(m.get(0)+","+m.get(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchMemberForSimpleView() {
		try {
			MemberSimpleVO m = mapper.searchMemberForSimpleView("jo");
			
	
				System.out.println(m);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchMemberInfo() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("memberId", "jo");
			map.put("memberPassword", "jo1234");
			MemberDTO m = mapper.searchMemberInfo("jo");
			
	
				System.out.println(m);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchMailOrId() {
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("condition", "member_id");
			map.put("value", "jo");
			String m = mapper.searchMailOrId(map);
	
				System.out.println(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

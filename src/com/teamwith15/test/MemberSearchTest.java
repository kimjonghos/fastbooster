package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.teamwith15.dao.MemberSearchDAO;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.MemberSearchVO;

public class MemberSearchTest {

	private SqlSessionFactory factory;
	private MemberSearchDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberSearchDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WHERE role_id = #{criteria.roleId}
	}
	
	@Test
	void searchMemberAll() {
		try {
			Criteria cri = new Criteria();
			cri.setPage(1);
			cri.setPerPageNum(10);
			cri.addCriteria("roleId", "role-1");
			List<MemberSearchVO> result = mapper.searchMemberAll();
			System.out.println(result.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	void searchRecentMember() {
		try {
			Criteria cri = new Criteria();
			cri.setPage(1);
			cri.setPerPageNum(10);
			cri.addCriteria("roleId", "role-1");
			List<MemberSearchVO> result = mapper.searchRecentMember(cri);
			System.out.println(result.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}

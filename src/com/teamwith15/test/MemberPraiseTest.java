package com.teamwith15.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamwith15.dao.MemberPraiseDAO;
import com.teamwith15.dao.MemberProjectCategoryDAO;
import com.teamwith15.dto.MemberPraiseDTO;

class MemberPraiseTest {
	private SqlSessionFactory factory;
	private MemberPraiseDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberPraiseDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void addMemberPraise() {
		try {
			MemberPraiseDTO m = new MemberPraiseDTO("an","yim","praise-3");
			int result = mapper.addMemberPraise(m);
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void removeMemberPraise() {
		try {
			MemberPraiseDTO m = new MemberPraiseDTO("an","yim","praise-33");
			int result = mapper.removeMemberPraise(m);
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void removeMemberAllPraise() {
		try {
			int result = mapper.removeMemberAllPraise("jo");
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void searchMemberPraise() {
		try {
			//List<MemberPraiseCntVO> list = mapper.searchMemberPraise("jo");
			//System.out.println(list.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void searchAllMemberPraise() {
		try {
			List<MemberPraiseDTO> list = mapper.searchAllMemberPraise();
			System.out.println(list.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}

package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamwith15.dao.MemberProjectCategoryDAO;
import com.teamwith15.dto.MemberProjectCategoryDTO;

class MemberProjectCategoryTest {
	private SqlSessionFactory factory;
	private MemberProjectCategoryDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberProjectCategoryDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void addMemberProjectCategory() {
		try {
			MemberProjectCategoryDTO m = new MemberProjectCategoryDTO("jo","project-category-22");
			int result = mapper.addMemberProjectCategory(m);
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void removeMemberProjectCategory() {
		try {
			MemberProjectCategoryDTO m = new MemberProjectCategoryDTO("jo","project-category-2");
			int result = mapper.removeMemberProjectCategory(m);
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void removeMemberProjectCategoryByMemberId() {
		try {
			MemberProjectCategoryDTO m = new MemberProjectCategoryDTO("jo","project-category-2");
			int result = mapper.removeMemberProjectCategoryByMemberId("jo");
			System.out.println(result);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchProjectCategoryByMember() {
		try {
			List<MemberProjectCategoryDTO> result = mapper.searchProjectCategoryByMember("jo");
			System.out.println(result.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchMemberByProjectCategory() {
		try {
			List<String> a = new ArrayList<String>();
			a.add("project-category-1");
			a.add("project-category-2");
			List<MemberProjectCategoryDTO> result = mapper.searchMemberByProjectCategory(a);
			System.out.println(result.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void searchAllMemberProjectCategory() {
		try {
			List<MemberProjectCategoryDTO> result = mapper.searchAllMemberProjectCategory();
			System.out.println(result.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}

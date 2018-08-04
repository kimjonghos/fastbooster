package com.teamwith15.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamwith15.dao.MainProfileDAO;
import com.teamwith15.vo.MainProfileVO;

class MainProfileTest {
	private SqlSessionFactory factory;
	private MainProfileDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MainProfileDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	void searchAllMainProfile() {
		//List<MainProfileVO> result = mapper.searchAllMainProfile();
		//System.out.println(result.size());
		//assertTrue(result!=null);
	}
	@Test
	void searchMainProfile() {
		//MainProfileVO result = mapper.searchMainProfile("jo");
		//System.out.println(result);
		//assertTrue(result!=null);
	}

}

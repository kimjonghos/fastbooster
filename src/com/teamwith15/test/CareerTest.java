package com.teamwith15.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.teamwith15.dao.CareerDAO;
import com.teamwith15.dto.CareerDTO;

class CareerTest {
	private SqlSessionFactory factory;
	private CareerDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(CareerDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void addCareer() {
		try {
			Date d = new Date(10, 10, 10);
			int result = mapper.addCareer(new CareerDTO("test","jo","a",d,d,"a","a"));
			session.commit();
			System.out.println(result);
			assertTrue(result==1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	void updateCareer() {
		try {
			Date d = new Date(10, 10, 10);
			int result = mapper.updateCareer(new CareerDTO("test","jo","ab",d,d,"ab","ab"));
			assertTrue(result==1);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	void removeCareer() {
		try {
			int result = mapper.removeCareer("career-1");
			assertTrue(result!=0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void removeCareerByMember() {
		try {
			int result = mapper.removeCareerByMember("jo");
			System.out.println(result);
			assertTrue(result!=0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void searchCareer() {
		try {
			List<CareerDTO> result = mapper.searchCareer("jo");
			System.out.println(result.get(0));
			assertTrue(result!=null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void searchAllCareer() {
		try {
			List<CareerDTO> result = mapper.searchAllCareer();
			System.out.println(result.size());
			assertTrue(result!=null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	void getId() {
		try {
			List<String> result = mapper.getId();
			System.out.println(result.size());
			assertTrue(result!=null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

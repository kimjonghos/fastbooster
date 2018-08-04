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

import com.teamwith15.dao.LicenseDAO;
import com.teamwith15.dao.LicenseDAO;
import com.teamwith15.dto.LicenseDTO;

public class LicenseTest {
	private SqlSessionFactory factory;
	private LicenseDAO mapper;
	private SqlSession session;

	@BeforeEach
	void setup() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(LicenseDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void addLicense() {
		try {
			Date d = new Date(10, 10, 10);
			int result = mapper.addLicense(new LicenseDTO("test2","jo","a",d,null));
			session.commit();
			System.out.println(result);
			assertTrue(result==1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	void updateLicense() {
		try {
			Date d = new Date(10, 10, 10);
			int result = mapper.updateLicense(new LicenseDTO("test","jo","a",d,"b"));
			assertTrue(result==1);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	void removeLicense() {
		try {
			int result = mapper.removeLicense("license-1");
			assertTrue(result!=0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void removeLicenseByMember() {
		try {
			int result = mapper.removeLicenseByMember("jo");
			System.out.println(result);
			assertTrue(result!=0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void searchLicense() {
		try {
			List<LicenseDTO> result = mapper.searchLicense("jo");
			System.out.println(result.get(0));
			assertTrue(result!=null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void searchAllLicense() {
		try {
			List<LicenseDTO> result = mapper.searchAllLicense();
			System.out.println(result.size());
			assertTrue(result!=null);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

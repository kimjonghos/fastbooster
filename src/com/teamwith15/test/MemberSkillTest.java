package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.MemberSkillDAO;
import com.teamwith15.dto.MemberSkillDTO;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.MemberSearchVO;

public class MemberSkillTest {

	public static void main(String[] args) {
		SqlSessionFactory factory;
		MemberSkillDAO mapper = null;
		SqlSession session;
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberSkillDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<String> list = new ArrayList<String>();
			list.add("skill-1");
			list.add("skill-2");
			List<MemberSkillDTO> result = mapper.searchMemberBySkill(list);
			System.out.println(result.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			List<MemberSkillDTO> result = mapper.searchAllMemberSkill();
			System.out.println(result.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			List<MemberSkillDTO> result = mapper.searchSkillByMember("jo");
			System.out.println(result.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			MemberSkillDTO m = new MemberSkillDTO("joo","skill-1", 0);
			int result = mapper.reomveMemberSkill(m);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			int result = mapper.reomveMemberAllSkill("jo");
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			MemberSkillDTO m = new MemberSkillDTO("kim","skill-1", 2);

			int result = mapper.updateSkillLevel(m);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			MemberSkillDTO m = new MemberSkillDTO("jo","skill-1", 0);

			int result = mapper.addMemberSkill(m);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}

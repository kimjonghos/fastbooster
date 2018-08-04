package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.MemberTendencyDAO;
import com.teamwith15.dto.MemberTendencyDTO;

public class MemberTendencyTest {

	public static void main(String[] args) {
		SqlSessionFactory factory;
		MemberTendencyDAO mapper = null;
		SqlSession session;
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
			mapper = session.getMapper(MemberTendencyDAO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			List<MemberTendencyDTO> m = new ArrayList<MemberTendencyDTO>();
			MemberTendencyDTO t1 = new MemberTendencyDTO("jo", "tendency-1", 2);
			MemberTendencyDTO t2 = new MemberTendencyDTO("jo", "tendency-2", 2);
			MemberTendencyDTO t3 = new MemberTendencyDTO("jo", "tendency-3", 2);
			MemberTendencyDTO t4 = new MemberTendencyDTO("jo", "tendency-4", 2);
			MemberTendencyDTO t5 = new MemberTendencyDTO("jo", "tendency-6", 2);
			m.add(t1);m.add(t2);m.add(t3);m.add(t4);m.add(t5);
			
			int result = mapper.updateTendencyFigure(t1);
			 result = mapper.addMemberTendency(t5);
			 //result = mapper.removeMemberTendency("jo");
			 List<MemberTendencyDTO> r = mapper.searchAllMemberTendency();
			System.out.println(r.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

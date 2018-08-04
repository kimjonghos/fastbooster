package com.teamwith15.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.MemberSearchDAO;
import com.teamwith15.dto.MemberProjectCategoryDTO;
import com.teamwith15.service.MemberService;
import com.teamwith15.service.ProfileService;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.CareerVO;
import com.teamwith15.vo.MemberSearchVO;

public class MemberSearchTestMain {
	
	public static void main(String[] args) {
		 SqlSessionFactory factory;
		 MemberSearchDAO mapper =null;
		 SqlSession session;
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
		//	WHERE member_public = 0
		try {
			Criteria cri = new Criteria();
			cri.setPage(1);
			cri.setPerPageNum(10);
			cri.addCriteria("roleId", "role-1");
			cri.addCriteria("regionId1", "region-1");
			List<MemberSearchVO> result = mapper.searchMemberByRoleRegion(cri);
			System.out.println(result.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(1);
			cri.setPerPageNum(10);
			List<MemberSearchVO> result = mapper.searchMemberByPraiseCnt(cri);
			System.out.println(result.get(1));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(1);
			cri.setPerPageNum(10);
			cri.addCriteria("memberName", "Áø");
			List<MemberSearchVO> result = mapper.searchMember(cri);
			System.out.println(result.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		ProfileService ps = ProfileService.getInstance();
		//List<CareerVO> r =ps.getMemberCareer("jo");
		//System.out.println("result"+r.size());
		
		
		MemberService ms = MemberService.getInstance();
		try {
			List<String> a = new ArrayList<String>();
			a.add("project-category-1");
			a.add("project-category-2");
			List<String> result = ms.getMemberByProjectCategoryId(a);
			System.out.println(result.size());
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

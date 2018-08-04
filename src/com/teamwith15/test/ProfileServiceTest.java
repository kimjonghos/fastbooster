package com.teamwith15.test;

import java.util.ArrayList;
import java.util.List;

import com.teamwith15.service.ProfileService;
import com.teamwith15.vo.CareerVO;
import com.teamwith15.vo.LicenseVO;
import com.teamwith15.vo.MemberTendencyVO;
import com.teamwith15.vo.MemberVO;

public class ProfileServiceTest {
	public static void main(String[] args) {
		ProfileService ps = ProfileService.getInstance();
try {
		MemberVO member = new MemberVO("test", "tname", "pw",
				"mail", "2018-01-01", null, "0", "ss", 
				"0", "s", null, "1",
				null, null, null);
		System.out.println("1: " + ps.registerAdminMember(member));
		member.setMemberId("test2");
		System.out.println("2: " + ps.registerMember(member));
		System.out.println("3: " + ps.initTendency("test"));
		List<CareerVO> career = new ArrayList<CareerVO>();
		career.add(new CareerVO(null, "test", "sd", null, null, null, null));
		System.out.println("4: " + ps.addMemberCareer(career));
		List<LicenseVO> license = new ArrayList<LicenseVO>();
		license.add(new LicenseVO(null, "test", "ss", null, null));
		System.out.println("5: " + ps.addMemberLicense(license));
		System.out.println("6: " + ps.hideMember("test"));
		System.out.println("7: " + ps.removeMember("test"));
		System.out.println("8: " + ps.removeMemberCareer("test"));
		System.out.println("9: " + ps.removeMemberLicense("test"));
		System.out.println("10: " + ps.removeMemberTendency("test"));
		//System.out.println("11: " + ps.updateMemberInfo(member));
		List<MemberTendencyVO> memberTendency = new ArrayList<MemberTendencyVO>();
		//memberTendency.add(new MemberTendencyVO("oh","tendency-1", "1"));
		//System.out.println("12: " + ps.updateMemberTendency(memberTendency));
		System.out.println("13: " + ps.getMemberCareer("oh"));
		System.out.println("14: " + ps.getMemberInfo("oh"));
		System.out.println("15: " + ps.getMemberLicense("oh"));
		System.out.println("16: " + ps.getMemberTendency("oh"));
}catch (Exception e) {
	// TODO: handle exception
}
	}
}

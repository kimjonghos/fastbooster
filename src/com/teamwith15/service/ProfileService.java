package com.teamwith15.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.teamwith15.dao.CareerDAO;
import com.teamwith15.dao.LicenseDAO;
import com.teamwith15.dao.MemberDAO;
import com.teamwith15.dao.MemberTendencyDAO;
import com.teamwith15.dto.CareerDTO;
import com.teamwith15.dto.LicenseDTO;
import com.teamwith15.dto.MemberDTO;
import com.teamwith15.dto.MemberTendencyDTO;
import com.teamwith15.util.UploadFileUtils;
import com.teamwith15.vo.CareerVO;
import com.teamwith15.vo.LicenseVO;
import com.teamwith15.vo.MemberTendencyVO;
import com.teamwith15.vo.MemberVO;

public class ProfileService {
	private static ProfileService profileService;

	private SqlSessionFactory factory;
	private SqlSession session;

	private CareerDAO careerDAO;
	private LicenseDAO licenseDAO;
	private MemberDAO memberDAO;
	private MemberTendencyDAO memberTendencyDAO;

	private String memberPicPath = "c:/teamwith/image/member";

	static {
		profileService = new ProfileService();
	}

	private ProfileService() {
		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	public static ProfileService getInstance() {
		if (profileService == null) {
			profileService = new ProfileService();
		}
		return profileService;
	}

	public void openSession() {
		session = factory.openSession();
	}

	public void commitSession() {
		session.commit();
	}

	public void closeSession() {
		session.close();
	}

	public List<CareerVO> getMemberCareer(String memberId) throws Exception {
		careerDAO = session.getMapper(CareerDAO.class);
		List<CareerDTO> temp = careerDAO.searchCareer(memberId);
		List<CareerVO> result = new ArrayList<CareerVO>();
		if (temp != null) {
			for (CareerDTO dto : temp) {
				result.add(dto.toVO());
			}
		}
		return result;
	}

	public List<LicenseVO> getMemberLicense(String memberId) throws Exception {
		licenseDAO = session.getMapper(LicenseDAO.class);

		List<LicenseDTO> temp = licenseDAO.searchLicense(memberId);
		List<LicenseVO> result = new ArrayList<LicenseVO>();
		if (temp != null) {
			for (LicenseDTO dto : temp) {
				result.add(dto.toVO());
			}
		}
		return result;
	}

	public MemberVO getMemberInfo(String memberId) throws Exception {
		memberDAO = session.getMapper(MemberDAO.class);

		MemberDTO dto = memberDAO.searchMemberInfo(memberId);
		MemberVO vo = dto.toVO();

		return vo;
	}

	public MemberTendencyVO getMemberTendency(String memberId) throws Exception {
		memberTendencyDAO = session.getMapper(MemberTendencyDAO.class);
		List<MemberTendencyDTO> temp = memberTendencyDAO.searchMemberTendency(memberId);
		MemberTendencyVO result = new MemberTendencyVO(temp);

		return result;
	}

	public int addMemberCareer(List<CareerVO> career) throws Exception {
		if (career == null) {
			return -1;
		}
		careerDAO = session.getMapper(CareerDAO.class);
		int result = -1;

		for (CareerVO c : career) {
			c.setCareerId(generateId(careerDAO.getId(), "career"));
			result = careerDAO.addCareer(c.toDTO());
			if (result != 1) {
				return result;
			}
		}
		return result;
	}

	public int removeMemberCareer(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		careerDAO = session.getMapper(CareerDAO.class);
		int result = -1;

		result = careerDAO.removeCareerByMember(memberId);
		return result;
	}

	public int addMemberLicense(List<LicenseVO> license) throws Exception {
		if (license == null) {
			return -1;
		}
		licenseDAO = session.getMapper(LicenseDAO.class);
		int result = -1;

		for (LicenseVO l : license) {
			l.setLicenseId(generateId(licenseDAO.getId(), "license"));
			result = licenseDAO.addLicense(l.toDTO());
			if (result != 1) {
				return result;
			}
		}
		return result;
	}

	public int removeMemberLicense(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		licenseDAO = session.getMapper(LicenseDAO.class);
		int result = -1;

		result = licenseDAO.removeLicenseByMember(memberId);
		return result;
	}

	public int updateMemberInfo(MemberVO member, Part memberPic) throws Exception {
		if (member == null) {
			return -1;
		}
		memberDAO = session.getMapper(MemberDAO.class);
		int result = -1;
		String picSavedName = UploadFileUtils.uploadFile(memberPicPath, member.getMemberId(), memberPic);
		member.setMemberPic(picSavedName);
		result = memberDAO.updateMember(member.toDTO());
		return result;
	}

	public int updateMemberTendency(MemberTendencyVO memberTendency) throws Exception {
		if (memberTendency == null) {
			return -1;
		}
		memberTendencyDAO = session.getMapper(MemberTendencyDAO.class);
		int result = -1;
		for (MemberTendencyDTO m : memberTendency.toDTO()) {
			result = memberTendencyDAO.updateTendencyFigure(m);
			if (result != 1) {
				return -1;
			}
		}

		return result;
	}

	public int initTendency(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		memberTendencyDAO = session.getMapper(MemberTendencyDAO.class);
		int result = -1;
		for (int i = 1; i < 6; i++) {
			result = memberTendencyDAO.addMemberTendency(new MemberTendencyDTO(memberId, "tendency-" + i, 5));
			if (result != 1) {
				return -1;
			}
		}
		return result;
	}

	public int removeMemberTendency(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		memberTendencyDAO = session.getMapper(MemberTendencyDAO.class);
		int result = -1;
		result = memberTendencyDAO.removeMemberTendency(memberId);
		return result;
	}

	public String registerMember(MemberVO member) {
		if (member == null) {
			return null;
		}
		memberDAO = session.getMapper(MemberDAO.class);
		int result = -1;
		try {
			result = memberDAO.addMember(member.toDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result != -1) {
			return member.getMemberId();
		} else {
			return null;
		}
	}

	public String registerAdminMember(MemberVO member) {
		if (member == null) {
			return null;
		}
		memberDAO = session.getMapper(MemberDAO.class);
		int result = -1;
		try {
			result = memberDAO.addAdminMember(member.toDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result != -1) {
			return member.getMemberId();
		} else {
			return null;
		}
	}

	public int removeMember(String memberId) {
		if (memberId == null) {
			return -1;
		}
		memberDAO = session.getMapper(MemberDAO.class);
		int result = -1;
		try {
			result = memberDAO.updateNonMember(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int hideMember(String memberId) {
		if (memberId == null) {
			return -1;
		}
		memberDAO = session.getMapper(MemberDAO.class);
		int result = -1;
		try {
			result = memberDAO.updateMemberStatus(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private String generateId(List<String> id, String tableName) {
		if (id == null) {
			return tableName + "-" + 1;
		}

		int maxCnt = -1;

		for (String str : id) {
			if (maxCnt < Integer.parseInt(str.split("-")[1])) {
				maxCnt = Integer.parseInt(str.split("-")[1]);
			}
		}

		return tableName + "-" + (maxCnt + 1);
	}

}

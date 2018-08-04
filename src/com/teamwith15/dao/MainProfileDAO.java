package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.vo.MainProfileVO;

public interface MainProfileDAO {
	public MainProfileVO searchMainProfile(String memberId) throws Exception;
	public List<MainProfileVO> searchAllMainProfile() throws Exception;
}

package com.teamwith15.dao;

import java.util.List;

import com.teamwith15.vo.MyApplicationVO;

public interface MyApplicationDAO {
	public List<MyApplicationVO> searchMyApplication(String memberId) throws Exception;
}

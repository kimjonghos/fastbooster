package com.teamwith15.dao;

import java.util.List;
import java.util.Map;

import com.teamwith15.vo.PortfolioSimpleVO;

public interface PortfolioSimpleDAO {
	public List<PortfolioSimpleVO> searchPortfolioSimpleAll() throws Exception;
	public List<PortfolioSimpleVO> searchPortfolioSimpleByMemberId(String memberId) throws Exception;
	
	public List<PortfolioSimpleVO> searchPortfolio(Map<String,Object> params);
}

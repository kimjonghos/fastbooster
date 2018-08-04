package com.teamwith15.dao;

import java.util.List;
import java.util.Map;

import com.teamwith15.dto.PortfolioDTO;
import com.teamwith15.util.Criteria;
import com.teamwith15.vo.PortfolioSimpleVO;

public interface PortfolioDAO {
	public int addPortfolio(PortfolioDTO portfolio);
	public int modifyPortfolio(PortfolioDTO portfolio) ;
	public int removePortfolioByPortfolioId(String portfolioId) ;
	public int removePortfolioByMemberId(String memberId);
	public List<PortfolioDTO> searchAllPortfolioList();
	public PortfolioDTO searchPortfolioByPortfolioId(String portfolioId);
	public List<PortfolioDTO> searchPortfolioByMemberId(String memberId);
	public int searchPortfolioCountByMemberId(String memberId) ;
	public int searchBestPortfolioCountByMemberId(String memberId) ;
	public List<PortfolioSimpleVO> searchPortfolioSimple(Criteria cri) throws Exception;
	public int updatePortfolio(PortfolioDTO portfolio);
	public List<String> getId();
}

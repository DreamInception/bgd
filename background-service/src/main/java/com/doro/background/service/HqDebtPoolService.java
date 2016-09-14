package com.doro.background.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.HqDebt;
import com.doro.background.dal.mapper.HqDebtMapper;
import com.doro.background.dal.mapper.HqDebtPoolMapper;
import com.doro.background.model.HqDebtPoolModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class HqDebtPoolService {

	@Autowired
	private HqDebtPoolMapper hqDebtPoolMapper;
	
	@Autowired
	private HqDebtMapper hqDebtMapper;
	
	public PageReslut getHqDebtPoolList(){
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		List<Map<String, Object>> hqDebtPools = new ArrayList<Map<String,Object>>();
		try {
			params.put(DRConst.COUNT, hqDebtPoolMapper.count(params));
			PageDealUtil.getLimit(params);
			List<Map<String, Object>> list = hqDebtPoolMapper.selectPageList(params);
			Map<String, Object> counts = hqDebtPoolMapper.countDistinct();
			for (Map<String, Object> map : list) {
				long debtId = DRUtil.toLong(map.get("debt_id"));
				HqDebt hqDebt = hqDebtMapper.selectByPrimaryKey(debtId);
				map.put("debt_name", hqDebt.getDebtName());
				hqDebtPools.add(map);
			}
			pageReslut.setResultList(hqDebtPools);
			pageReslut.setResulPages(PageDealUtil.getPageCount(params));
			pageReslut.setParams(counts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;	
	}
	
	public PageReslut getHqDebtPoolListRefresh(int pageNum,HqDebtPoolModel hqDebtPoolModel){
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		List<Map<String, Object>> hqDebtPools = new ArrayList<Map<String,Object>>();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(hqDebtPoolModel)) {
				params.put("startCreateTime",hqDebtPoolModel.getStartCreateTime());
				params.put("endCreateTime",hqDebtPoolModel.getEndCreateTime());
			}
			
			params.put(DRConst.PAGE_KEY_PAGE, pageNum);
			params.put(DRConst.COUNT, hqDebtPoolMapper.count(params));
			PageDealUtil.getLimit(params);
			List<Map<String, Object>> list = hqDebtPoolMapper.selectPageList(params);
			for (Map<String, Object> map : list) {
				long debtId = DRUtil.toLong(map.get("debt_id"));
				HqDebt hqDebt = hqDebtMapper.selectByPrimaryKey(debtId);
				map.put("debt_name", hqDebt.getDebtName());
				hqDebtPools.add(map);
			}
			pageReslut.setResultList(hqDebtPools);
			pageReslut.setResulPages(PageDealUtil.getPageCount(params));
			pageReslut.setParams(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;	
	}
}

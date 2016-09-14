package com.doro.background.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doro.background.dal.entity.ActTargetRateAppend;
import com.doro.background.dal.entity.CmsSysPic;
import com.doro.background.dal.entity.DqTarget;
import com.doro.background.dal.entity.DqTargetDetail;
import com.doro.background.dal.entity.DqTargetRateAppend;
import com.doro.background.dal.mapper.ActTargetRateAppendMapper;
import com.doro.background.dal.mapper.CmsSysPicMapper;
import com.doro.background.dal.mapper.DqTargetDetailMapper;
import com.doro.background.dal.mapper.DqTargetMapper;
import com.doro.background.dal.mapper.DqTargetRateAppendMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.DqTargetModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.IdFactory;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class DqTargetService {

	@Autowired
	private DqTargetMapper dqTargetMapper;
	@Autowired
	private DqTargetDetailMapper dqTargetDetailMapper;
	@Autowired
	private CmsSysPicMapper cmsSysPicMapper;
	@Autowired
	private ActTargetRateAppendMapper actTargetRateAppendMapper;
	@Autowired
	private DqTargetRateAppendMapper dqTargetRateAppendMapper;
	
	public List<Map<String, Object>> getCmsSysPicByPicCode(){
		return cmsSysPicMapper.selectByPicCode("target_ico");
	}
	
	public List<Map<String, Object>> getActTargetRateAppendByValid(){
		return actTargetRateAppendMapper.selectByValid();
	}
	
	public PageReslut getDqTargetList(int pageNum, DqTargetModel dqTargetModel,int audit) {
		Map<String, Object> param = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			if (!DRUtil.isEmptyObject(dqTargetModel)) {
				param.put("targetId", DRUtil.isEmptyObject(dqTargetModel.getTargetId())?null:dqTargetModel.getTargetId());
				param.put("targetName", DRUtil.isEmptyObject(dqTargetModel.getTargetName())?null:dqTargetModel.getTargetName());
				param.put("startCreateTime", DRUtil.isEmptyObject(dqTargetModel.getStartCreateTime())?null:dqTargetModel.getStartCreateTime());
				param.put("endCreateTime", DRUtil.isEmptyObject(dqTargetModel.getEndCreateTime())?null:dqTargetModel.getEndCreateTime());
			}
			param.put(DRConst.PAGE_KEY_PAGE, pageNum);
			PageDealUtil.getLimit(param);
			if(audit==0){
				param.put(DRConst.COUNT, dqTargetMapper.selectPageListCount(param));
				pageReslut.setResultList(dqTargetMapper.selectPageList(param));
			}else{
				param.put(DRConst.COUNT, dqTargetMapper.selectPageAuditListCount(param));
				pageReslut.setResultList(dqTargetMapper.selectPageAuditList(param));
			}
			pageReslut.setResulPages(PageDealUtil.getPageCount(param));
			pageReslut.setParams(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;
	}

	public JsonMessage getDqTarget(Long targetId){
		JsonMessage jsonMessage = new JsonMessage();
		DqTargetModel dqTargetModel = new DqTargetModel();
		if(DRUtil.isEmptyObject(targetId)||targetId<=0){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，标的编号不能为空");
		} else {
			DqTarget dqTarget = dqTargetMapper.selectByPrimaryKey(targetId);
			DqTargetDetail dqTargetDetail = dqTargetDetailMapper.selectByPrimaryKey(targetId);
			DqTargetRateAppend dqTargetRateAppend = dqTargetRateAppendMapper.selectByPrimaryKey(targetId);
			CmsSysPic pic = cmsSysPicMapper.selectByPicUrl(dqTarget.getTargetIcon());
			dqTargetModel.setsTargetId(DRUtil.toStr(targetId));
			dqTargetModel.setTargetName(dqTarget.getTargetName());
			dqTargetModel.setTargetIcon(dqTarget.getTargetIcon());
			dqTargetModel.setTargetAmount(dqTarget.getTargetAmount());
			dqTargetModel.setBuyAmount(BigDecimal.ZERO);
			dqTargetModel.setUnitAmount(dqTarget.getUnitAmount());
			dqTargetModel.setMinAmount(dqTarget.getMinAmount());
			dqTargetModel.setBeginDate(dqTarget.getBeginDate());
			dqTargetModel.setEndDate(dqTarget.getEndDate());
			dqTargetModel.setYearRate(dqTarget.getYearRate());
			dqTargetModel.setDayRate(dqTarget.getDayRate());
			dqTargetModel.setSellerName(dqTargetDetail.getSellerName());
			dqTargetModel.setDqContent(dqTargetDetail.getDqContent());
			dqTargetModel.setEnumDqtargetState(dqTarget.getEnumDqtargetState());
			if(!DRUtil.isEmptyObject(dqTargetRateAppend)){
				dqTargetModel.setActAutoId(dqTargetRateAppend.getActAutoId());
				dqTargetModel.setActName(dqTargetRateAppend.getActName());
			}
			dqTargetModel.setPicRemark(pic.getRemark());
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("success");
			jsonMessage.setData(dqTargetModel);
		}
		return jsonMessage;
	}
	
	@Transactional
	public JsonMessage addDqTarget(DqTargetModel dqTargetModel) throws Exception{
		JsonMessage jsonMessage = new JsonMessage();
			if (DRUtil.isEmptyObject(dqTargetModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的录入出错，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，标的名称不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetIcon())||DRUtil.equals(dqTargetModel.getTargetIcon().trim(), "0".trim())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，图片不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，标的金额不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getUnitAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，单位递增金额不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getMinAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，起购金额不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getBeginDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，起息日不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getEndDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，结息日不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getYearRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，基础年利率不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getDayRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，基础天利率不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getSellerName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，债权方不能为空");
			} else if (DRUtil.isEmptyObject(dqTargetModel.getDqContent())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("定期标的添加出错，内容不能为空");
			} else if (!DRUtil.integerMultiple(dqTargetModel.getTargetAmount(), 100)
					&& !DRUtil.integerMultiple(dqTargetModel.getUnitAmount(), 100)
					&& !DRUtil.integerMultiple(dqTargetModel.getMinAmount(), 100)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("金额必须是整数");
			}
			else if (dqTargetModel.getTargetAmount().subtract(dqTargetModel.getMinAmount()).intValue() < 0) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的金额必须大于起购金额");
			} else if (!DRUtil.integerMultiple(dqTargetModel.getMinAmount(), dqTargetModel.getUnitAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("起购金额必须是单位递增金额的整数倍");
			} else if (!dqTargetModel.getBeginDate().before(dqTargetModel.getEndDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("结息日必须大于起息日");
			} else {
				DqTarget dqTarget = new DqTarget();
				long targetId = IdFactory.hdTargetId.nextId();
				dqTarget.setTargetId(targetId);
				dqTarget.setTargetName(dqTargetModel.getTargetName().trim());
				dqTarget.setTargetIcon(dqTargetModel.getTargetIcon().trim());
				dqTarget.setTargetAmount(dqTargetModel.getTargetAmount());
				dqTarget.setBuyAmount(BigDecimal.ZERO);
				dqTarget.setUnitAmount(dqTargetModel.getUnitAmount());
				dqTarget.setMinAmount(dqTargetModel.getMinAmount());
				dqTarget.setBeginDate(dqTargetModel.getBeginDate());
				dqTarget.setEndDate(dqTargetModel.getEndDate());
				dqTarget.setYearRate(dqTargetModel.getYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				dqTarget.setDayRate(dqTargetModel.getDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				dqTarget.setOnsaleTime(DRDateUtil.parseDate("1970-00-00 00:00:00", DRDateUtil.YYYYMMDDHHMMSS3));
				dqTarget.setFullsaleTime(DRDateUtil.parseDate("1970-00-00 00:00:00", DRDateUtil.YYYYMMDDHHMMSS3));
				dqTarget.setEnumDqtargetState(0);
				long row = dqTargetMapper.insert(dqTarget);
				if (row <= 0) {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("定期标的添加失败，请重新操作");
				} else {
					DqTargetDetail dqTargetDetail = new DqTargetDetail();
					dqTargetDetail.setTargetId(targetId);
					dqTargetDetail.setSellerName(dqTargetModel.getSellerName().trim());
					dqTargetDetail.setDqContent(dqTargetModel.getDqContent().trim());
					int row2 = dqTargetDetailMapper.insert(dqTargetDetail);
					if (row2 > 0) {
						if(!DRUtil.isEmptyObject(dqTargetModel.getActAutoId())&&dqTargetModel.getActAutoId()!=0){
							ActTargetRateAppend actTargetRateAppend = actTargetRateAppendMapper.selectByPrimaryKey(dqTargetModel.getActAutoId());
							DqTargetRateAppend dqTargetRateAppend = new DqTargetRateAppend();
							dqTargetRateAppend.setTargetId(targetId);
							dqTargetRateAppend.setAppendLable(actTargetRateAppend.getAppendLable().trim());
							dqTargetRateAppend.setAppendYearDate(actTargetRateAppend.getAppendYearRate());
							dqTargetRateAppend.setAppendDayRate(actTargetRateAppend.getAppendDayRate());
							dqTargetRateAppend.setAppendDayCount(actTargetRateAppend.getAppendDayCount());
							dqTargetRateAppend.setActAutoId(actTargetRateAppend.getActAutoId());
							dqTargetRateAppend.setActName(actTargetRateAppend.getActName().trim());
							dqTargetRateAppendMapper.insert(dqTargetRateAppend);
						}
						jsonMessage.setFlag(true);
						jsonMessage.setMessage("定期标的添加成功");
						jsonMessage.setData(targetId);
					} else {
						jsonMessage.setFlag(false);
						jsonMessage.setMessage("定期标的添加失败，请重新操作");
					}
				}
			}
		return jsonMessage;
	}
	
	@Transactional
	public JsonMessage updateDqTarget(DqTargetModel dqTargetModel) throws Exception{
		JsonMessage jsonMessage = new JsonMessage();
		if (DRUtil.isEmptyObject(dqTargetModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的录入出错，请仔细核对录入数据");
		} else if(DRUtil.isEmptyObject(dqTargetModel.getEnumDqtargetState())||dqTargetModel.getEnumDqtargetState()!=0){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，该状态下不能修改");
		} else if(DRUtil.isEmptyObject(dqTargetModel.getTargetId())||dqTargetModel.getTargetId()<=0){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，标的编号不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetName())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，标的名称不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetIcon())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，图片不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，标的金额不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getUnitAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，单位递增金额不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getMinAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，起购金额不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getBeginDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，起息日不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，结息日不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getYearRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，基础年利率不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getDayRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，基础天利率不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getSellerName())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，债权方不能为空");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getDqContent())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("定期标的修改出错，内容不能为空");
		} else if (!DRUtil.integerMultiple(dqTargetModel.getTargetAmount(), 100)
				&& !DRUtil.integerMultiple(dqTargetModel.getUnitAmount(), 100)
				&& !DRUtil.integerMultiple(dqTargetModel.getMinAmount(), 100)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("金额必须是整数");
		} else if (dqTargetModel.getTargetAmount().subtract(dqTargetModel.getMinAmount()).intValue() < 0) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("标的金额必须大于起购金额");
		} else if (!DRUtil.integerMultiple(dqTargetModel.getMinAmount(), dqTargetModel.getUnitAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("起购金额必须是单位递增金额的整数倍");
		} else if (!dqTargetModel.getBeginDate().before(dqTargetModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("结息日必须大于起息日");
		} else {
			DqTarget dqTarget = new DqTarget();
			dqTarget.setTargetId(dqTargetModel.getTargetId());
			dqTarget.setTargetName(dqTargetModel.getTargetName().trim());
			dqTarget.setTargetIcon(dqTargetModel.getTargetIcon().trim());
			dqTarget.setTargetAmount(dqTargetModel.getTargetAmount());
			dqTarget.setBuyAmount(BigDecimal.ZERO);
			dqTarget.setUnitAmount(dqTargetModel.getUnitAmount());
			dqTarget.setMinAmount(dqTargetModel.getMinAmount());
			dqTarget.setBeginDate(dqTargetModel.getBeginDate());
			dqTarget.setEndDate(dqTargetModel.getEndDate());
			dqTarget.setYearRate(dqTargetModel.getYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			dqTarget.setDayRate(dqTargetModel.getDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			dqTarget.setOnsaleTime(DRDateUtil.parseDate("1970-00-00 00:00:00", DRDateUtil.YYYYMMDDHHMMSS3));
			dqTarget.setFullsaleTime(DRDateUtil.parseDate("1970-00-00 00:00:00", DRDateUtil.YYYYMMDDHHMMSS3));
			dqTarget.setEnumDqtargetState(0);
			dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
			DqTargetDetail dqTargetDetail = new DqTargetDetail();
			dqTargetDetail.setTargetId(dqTargetModel.getTargetId());
			dqTargetDetail.setSellerName(dqTargetModel.getSellerName().trim());
			dqTargetDetail.setDqContent(dqTargetModel.getDqContent().trim());
			dqTargetDetailMapper.updateByPrimaryKeySelective(dqTargetDetail);
			if(!DRUtil.isEmptyObject(dqTargetModel.getActAutoId())&&dqTargetModel.getActAutoId()!=0){
				dqTargetRateAppendMapper.deleteByPrimaryKey(dqTargetModel.getTargetId());
				ActTargetRateAppend actTargetRateAppend = actTargetRateAppendMapper.selectByPrimaryKey(dqTargetModel.getActAutoId());
				DqTargetRateAppend dqTargetRateAppend = new DqTargetRateAppend();
				dqTargetRateAppend.setTargetId(dqTargetModel.getTargetId());
				dqTargetRateAppend.setAppendLable(actTargetRateAppend.getAppendLable().trim());
				dqTargetRateAppend.setAppendYearDate(actTargetRateAppend.getAppendYearRate());
				dqTargetRateAppend.setAppendDayRate(actTargetRateAppend.getAppendDayRate());
				dqTargetRateAppend.setAppendDayCount(actTargetRateAppend.getAppendDayCount());
				dqTargetRateAppend.setActAutoId(actTargetRateAppend.getActAutoId());
				dqTargetRateAppend.setActName(actTargetRateAppend.getActName().trim());
				dqTargetRateAppendMapper.insert(dqTargetRateAppend);
			}
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("定期标的秀修改成功");
			jsonMessage.setData(dqTargetModel.getTargetId());
		}
	return jsonMessage;
	}
	
	@Transactional
	public JsonMessage updateEnumDqtargetState(DqTargetModel dqTargetModel,int audit) throws Exception{
		JsonMessage jsonMessage = new JsonMessage();
		if (DRUtil.isEmptyObject(dqTargetModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("请仔细核对录入数据");
		} else if (DRUtil.isEmptyObject(dqTargetModel.getTargetId())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("ID不能为空");
		} else if(DRUtil.isEmptyObject(dqTargetModel.getOnsaleTime())&&audit==4){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("预上架时间不能为空");
		} else {
			DqTarget dqTarget = new DqTarget();
			dqTarget.setTargetId(dqTargetModel.getTargetId());
			switch (audit) {
			case 1:
				dqTarget.setEnumDqtargetState(100);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			case 2:
				dqTarget.setEnumDqtargetState(0);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			case 3:
				dqTarget.setEnumDqtargetState(200);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			case 4:
				dqTarget.setOnsaleTime(dqTargetModel.getOnsaleTime());
				dqTarget.setEnumDqtargetState(300);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			case 5:
				dqTarget.setEnumDqtargetState(400);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			case 6:
				dqTarget.setEnumDqtargetState(600);
				dqTargetMapper.updateByPrimaryKeySelective(dqTarget);
				break;
			}
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("操作成功");
		}
		return jsonMessage;
	}
}

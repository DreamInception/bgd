package com.doro.background.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doro.background.dal.entity.ActTargetRateAppend;
import com.doro.background.dal.entity.HqTarget;
import com.doro.background.dal.entity.HqTargetRateAppend;
import com.doro.background.dal.mapper.ActTargetRateAppendMapper;
import com.doro.background.dal.mapper.HqTargetMapper;
import com.doro.background.dal.mapper.HqTargetRateAppendMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.HqTargetModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.IdFactory;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class HqTargetService {
	
	@Autowired
	private HqTargetMapper hqTargetMapper;
	@Autowired
	private HqTargetRateAppendMapper hqTargetRateAppendMapper;
	@Autowired
	private ActTargetRateAppendMapper actTargetRateAppendMapper;
	
	
	/**
	 * 
	* @Title: getActTargetRateAppendByValid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws
	 */
	public List<Map<String, Object>> getActTargetRateAppendByValid(){
		return actTargetRateAppendMapper.selectByValid();
	}
	
	/**
	 * 
	* @Title: getHqTarget 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param targetId
	* @param @return    设定文件 
	* @return HqTargetModel    返回类型 
	* @throws
	 */
	public HqTargetModel getHqTarget(Long targetId){
		HqTargetModel hqTargetModel = new HqTargetModel();
		if(!DRUtil.isEmptyObject(targetId)){
			HqTarget hqTarget = hqTargetMapper.selectByPrimaryKey(targetId);
			HqTargetRateAppend hqTargetRateAppend = hqTargetRateAppendMapper.selectByPrimaryKey(targetId);
			hqTargetModel.setTargetId(targetId);
			hqTargetModel.setTargetName(hqTarget.getTargetName());
			hqTargetModel.setTargetAmount(hqTarget.getTargetAmount());
			hqTargetModel.setTargetYearRate(hqTarget.getTargetYearRate());
			hqTargetModel.setTargetDayRate(hqTarget.getTargetDayRate());
			if(!DRUtil.isEmptyObject(hqTargetRateAppend)){
				hqTargetModel.setActAutoId(hqTargetRateAppend.getActAutoId());
				hqTargetModel.setActName(hqTargetRateAppend.getActName());
			}
			hqTargetModel.setsTargetId(DRUtil.toStr(targetId));
		}
		return hqTargetModel;
	}
	
	/**
	 * @Title: getHqTargetList @Description: TODO(分页列表的查询) @param @param
	 * param @param @return 设定文件 @return PageReslut 返回类型 @throws
	 */
	public PageReslut getHqTargetList(int pageNum,HqTargetModel hqTargetModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(hqTargetModel)) {
				params.put("targetId", hqTargetModel.getTargetId());
				params.put("targetName", hqTargetModel.getTargetName());
			}
			params.put(DRConst.PAGE_KEY_PAGE, pageNum);
			params.put(DRConst.COUNT, hqTargetMapper.selectPageListCount(params));
			PageDealUtil.getLimit(params);
			pageReslut.setResultList(hqTargetMapper.selectPageList(params));
			pageReslut.setResulPages(PageDealUtil.getPageCount(params));
			pageReslut.setParams(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;
	}
	
	/**
	 * 
	* @Title: addHqTarget 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param hqTargetModel
	* @param @return    设定文件 
	* @return JsonMessage    返回类型 
	* @throws
	 */
	@Transactional
	public JsonMessage addHqTarget(HqTargetModel hqTargetModel){
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(hqTargetModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的添加错误，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getTargetName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的添加错误，标的名称不能为空");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getTargetAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的添加错误，标的金额不能为空");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getTargetYearRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的添加错误，基础年利率不能为空");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getTargetDayRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("标的添加错误，基础天利率不能为空");
			} else {
				// 添加数据
				HqTarget hqTarget = new HqTarget();
				long targetId = IdFactory.targetIdWorker.nextId();
				hqTarget.setTargetId(targetId);
				hqTarget.setTargetName(hqTargetModel.getTargetName());
				hqTarget.setTargetAmount(hqTargetModel.getTargetAmount());
				hqTarget.setTargetBidAmount(BigDecimal.ZERO);
				hqTarget.setTargetYearRate(hqTargetModel.getTargetYearRate());
				hqTarget.setTargetDayRate(hqTargetModel.getTargetDayRate());
				hqTarget.setEnumTargetState(0);
				hqTarget.setOnsaleTime(DRDateUtil.parseDate("1970-00-00 00:00:00", DRDateUtil.YYYYMMDDHHMMSS3));
				int row = hqTargetMapper.insert(hqTarget);
				if (row > 0) {
					if(!DRUtil.isEmptyObject(hqTargetModel.getActAutoId())&&hqTargetModel.getActAutoId()>0){
						ActTargetRateAppend actTargetRateAppend = actTargetRateAppendMapper.selectByPrimaryKey(hqTargetModel.getActAutoId());
						HqTargetRateAppend hqTargetRateAppend = new HqTargetRateAppend();
						hqTargetRateAppend.setTargetId(targetId);
						hqTargetRateAppend.setActAutoId(hqTargetModel.getActAutoId());
						hqTargetRateAppend.setActName(actTargetRateAppend.getActName());
						hqTargetRateAppend.setAppendDayCount(actTargetRateAppend.getAppendDayCount());
						hqTargetRateAppend.setAppendDayRate(actTargetRateAppend.getAppendDayRate().setScale(6,BigDecimal.ROUND_DOWN));
						hqTargetRateAppend.setAppendLable(actTargetRateAppend.getAppendLable());
						hqTargetRateAppend.setAppendYearDate(actTargetRateAppend.getAppendYearRate().setScale(6,BigDecimal.ROUND_DOWN));
						hqTargetRateAppendMapper.insert(hqTargetRateAppend);
					}
					jsonMessage.setFlag(true);
					jsonMessage.setMessage("标的添加成功");
					jsonMessage.setData(targetId);
				} else {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("标的添加失败，请重新操作");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("系统异常，请检查录入数据或者联系管理员");
			return jsonMessage;
		}
		return jsonMessage;
	}

	/**
	 * 
	* @Title: updateEnumTargetState 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param hqTargetModel
	* @param @return    设定文件 
	* @return JsonMessage    返回类型 
	* @throws
	 */
	public JsonMessage updateEnumTargetState(HqTargetModel hqTargetModel){
		JsonMessage jsonMessage = new JsonMessage();
		try {
			if (DRUtil.isEmptyObject(hqTargetModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getTargetId())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("ID不能为空");
			} else if (DRUtil.isEmptyObject(hqTargetModel.getEnumTargetState())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("是否上架不能为空");
			} else {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("enumTargetState", hqTargetModel.getEnumTargetState());
				param.put("targetId", hqTargetModel.getTargetId());
				hqTargetMapper.updateEnumTargetState(param);
				jsonMessage.setFlag(true);
				jsonMessage.setMessage("操作成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("操作失败");
		}
		return jsonMessage;
	}
}
package com.doro.background.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.ActTargetRateAppend;
import com.doro.background.dal.mapper.ActTargetRateAppendMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActTargetRateAppendModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class ActTargetRateService {

	@Autowired
	ActTargetRateAppendMapper actTargetRateAppendMapper;

	/**
	 * 
	 * @Title: addActTargetRateAppend @Description:
	 *         TODO(这里用一句话描述这个方法的作用) @param @param
	 *         actTargetRateAppendModel @param @return 设定文件 @return JsonMessage
	 *         返回类型 @throws
	 */
	public JsonMessage addActTargetRateAppend(ActTargetRateAppendModel actTargetRateAppendModel) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(actTargetRateAppendModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getActName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，活动名称不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendLable())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息标签不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendYearRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息年利率不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendDayRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息天利率不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendDayCount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息有效天数不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getBeginDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，开始有效期不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getEndDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，截止有效期不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getIsOnsale())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，是否上架不能为空");
			} else {
				// 添加数据
				ActTargetRateAppend actTargetRateAppend = new ActTargetRateAppend();
				actTargetRateAppend.setActName(actTargetRateAppendModel.getActName().trim());
				actTargetRateAppend.setAppendLable(actTargetRateAppendModel.getAppendLable().trim());
				actTargetRateAppend.setAppendYearRate(actTargetRateAppendModel.getAppendYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				actTargetRateAppend.setAppendDayRate(actTargetRateAppendModel.getAppendDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				actTargetRateAppend.setAppendDayCount(actTargetRateAppendModel.getAppendDayCount());
				actTargetRateAppend.setBeginDate(actTargetRateAppendModel.getBeginDate());
				actTargetRateAppend.setEndDate(actTargetRateAppendModel.getEndDate());
				actTargetRateAppend.setIsOnsale(actTargetRateAppendModel.getIsOnsale());
				int actAutoId = actTargetRateAppendMapper.insert(actTargetRateAppend);
				if (actAutoId > 0) {
					jsonMessage.setFlag(true);
					jsonMessage.setMessage("活动添加成功");
					jsonMessage.setData(actAutoId);
				} else {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("活动添加失败，请重新操作");
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
	 * @Title: updateActTargetRateAppend @Description: 修改活动数据 @param @param
	 *         actTargetRateAppendModel @param @return 设定文件 @return JsonMessage
	 *         返回类型 @throws
	 */
	public JsonMessage updateActTargetRateAppend(ActTargetRateAppendModel actTargetRateAppendModel) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(actTargetRateAppendModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getActName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，活动名称不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendLable())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息标签不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendYearRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息年利率不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendDayRate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息天利率不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getAppendDayCount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，加息有效天数不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getBeginDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，开始有效期不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getEndDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，截止有效期不能为空");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getIsOnsale())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("活动添加错误，是否上架不能为空");
			} else {
				// 添加数据
				ActTargetRateAppend actTargetRateAppend = new ActTargetRateAppend();
				actTargetRateAppend.setActName(actTargetRateAppendModel.getActName().trim());
				actTargetRateAppend.setAppendLable(actTargetRateAppendModel.getAppendLable().trim());
				actTargetRateAppend.setAppendYearRate(actTargetRateAppendModel.getAppendYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				actTargetRateAppend.setAppendDayRate(actTargetRateAppendModel.getAppendDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
				actTargetRateAppend.setAppendDayCount(actTargetRateAppendModel.getAppendDayCount());
				actTargetRateAppend.setBeginDate(actTargetRateAppendModel.getBeginDate());
				actTargetRateAppend.setEndDate(actTargetRateAppendModel.getEndDate());
				actTargetRateAppend.setIsOnsale(actTargetRateAppendModel.getIsOnsale());

				actTargetRateAppendMapper.update(actTargetRateAppend);
				jsonMessage.setFlag(true);
				jsonMessage.setMessage("活动修改成功");
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
	 * @Title: updateOnsale @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 * onsale @param @return 设定文件 @return JsonMessage 返回类型 @throws
	 */
	public JsonMessage updateOnsale(ActTargetRateAppendModel actTargetRateAppendModel) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			if (DRUtil.isEmptyObject(actTargetRateAppendModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getActAutoId())) {

			} else if (DRUtil.isEmptyObject(actTargetRateAppendModel.getIsOnsale())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("是否上架不能为空");
			} else {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("isOnsale", actTargetRateAppendModel.getIsOnsale());
				param.put("actAutoId", actTargetRateAppendModel.getActAutoId());
				actTargetRateAppendMapper.updateOnsale(param);
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

	/**
	 * 
	* @Title: getActTargetRateAppendList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param actTargetRateAppendModel
	* @param @return    设定文件 
	* @return PageReslut    返回类型 
	* @throws
	 */
	public PageReslut getActTargetRateAppendList(int pageNum,ActTargetRateAppendModel actTargetRateAppendModel) {
		Map<String, Object> param = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(actTargetRateAppendModel)) {
				if(!DRUtil.isEmptyObject(actTargetRateAppendModel.getActAutoId())){
					param.put("actAutoId",actTargetRateAppendModel.getActAutoId());
				}
				if(!DRUtil.isEmptyObject(actTargetRateAppendModel.getActName())){
					param.put("actName",actTargetRateAppendModel.getActName());
				}
			}
			param.put(DRConst.PAGE_KEY_PAGE, pageNum);
			param.put(DRConst.COUNT, actTargetRateAppendMapper.selectPageListCount(param));
			PageDealUtil.getLimit(param);
			pageReslut.setResultList(actTargetRateAppendMapper.selectPageList(param));
			pageReslut.setResulPages(PageDealUtil.getPageCount(param));
			pageReslut.setParams(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;
	}
}

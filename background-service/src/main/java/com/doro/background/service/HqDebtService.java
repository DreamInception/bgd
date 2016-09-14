package com.doro.background.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doro.background.dal.entity.HqDebt;
import com.doro.background.dal.entity.HqDebtPool;
import com.doro.background.dal.mapper.HqDebtMapper;
import com.doro.background.dal.mapper.HqDebtPoolMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.HqDebtModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.IdFactory;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class HqDebtService {

	@Autowired
	private HqDebtMapper hqDebtMapper;
	
	@Autowired
	private HqDebtPoolMapper hqDebtPoolMapper;
	/**
	 * 
	* @Title: getHqDebtList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param param
	* @param @return    设定文件 
	* @return PageReslut    返回类型 
	* @throws
	 */
	public PageReslut getHqDebtList(HqDebtModel hqDebtModel,int audit){
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(hqDebtModel)) {
				params.put("debtId", hqDebtModel.getDebtId());
				params.put("debtName", hqDebtModel.getDebtName());
			}
			if(audit==0){
				params.put(DRConst.COUNT, hqDebtMapper.selectPageListCount(params));
				PageDealUtil.getLimit(params);
				pageReslut.setResultList(hqDebtMapper.selectPageList(params));
				pageReslut.setResulPages(PageDealUtil.getPageCount(params));
				pageReslut.setParams(params);
			}else{
				params.put(DRConst.COUNT, hqDebtMapper.selectPageAuditListCount(params));
				PageDealUtil.getLimit(params);
				pageReslut.setResultList(hqDebtMapper.selectPageAuditList(params));
				pageReslut.setResulPages(PageDealUtil.getPageCount(params));
				pageReslut.setParams(params);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageReslut;
	}
	
	public JsonMessage addHqDebt(HqDebtModel hqDebtModel){
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(hqDebtModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权名称不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getEnumDebtType())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权类型 不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权金额不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getRepayDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，还款日期不能为空");
			} else if((hqDebtModel.getRepayDate().before(new Date()))){
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，还款日期不能小于当前日期");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtLevel())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，优先级不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtFrom())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权来源不能为空");
			} else {
				// 添加数据
				HqDebt hqDebt = new HqDebt();
				hqDebt.setDebtId(IdFactory.debtId.nextId());
				hqDebt.setDebtName(hqDebtModel.getDebtName());
				hqDebt.setEnumDebtType(hqDebtModel.getEnumDebtType());
				hqDebt.setDebtAmount(hqDebtModel.getDebtAmount());
				hqDebt.setDebtLevel(hqDebtModel.getDebtLevel());
				hqDebt.setRepayDate(hqDebtModel.getRepayDate());
				hqDebt.setDebtFrom(hqDebtModel.getDebtFrom());
				int debtId = hqDebtMapper.insert(hqDebt);
				
				if (debtId > 0) {
					jsonMessage.setFlag(true);
					jsonMessage.setMessage("债权添加成功");
					jsonMessage.setData(debtId);
				} else {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("债权添加失败，请重新操作");
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
	
	@Transactional(rollbackFor={Exception.class, RuntimeException.class})
	public JsonMessage enumDebtState(HqDebtModel hqDebtModel,int audit) throws Exception{
		JsonMessage jsonMessage = new JsonMessage();
		try {
			if (DRUtil.isEmptyObject(hqDebtModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtId())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("ID不能为空");
			} else {
				HqDebt hqDebt = new HqDebt();
				switch (audit) {
				case 1:
					hqDebt.setDebtId(hqDebtModel.getDebtId());
					hqDebt.setEnumDebtState(100);
					hqDebtMapper.updateByPrimaryKeySelective(hqDebt);
					break;
				case 2:
					hqDebt.setDebtId(hqDebtModel.getDebtId());
					hqDebt.setEnumDebtState(0);
					hqDebtMapper.updateByPrimaryKeySelective(hqDebt);
					break;
				case 3:
					hqDebt.setDebtId(hqDebtModel.getDebtId());
					hqDebt.setEnumDebtState(200);
					hqDebtMapper.updateByPrimaryKeySelective(hqDebt);
					hqDebt = hqDebtMapper.selectByPrimaryKey(hqDebt.getDebtId());
					HqDebtPool hqDebtPool = new HqDebtPool();
					hqDebtPool.setDebtId(hqDebt.getDebtId());
					hqDebtPool.setSellUserId((long)0);
					hqDebtPool.setBuyAmount(hqDebt.getDebtAmount());
					hqDebtPool.setCurrentAmount(hqDebt.getDebtAmount());
					hqDebtPool.setEnumDebtType(hqDebt.getEnumDebtType());
					hqDebtPool.setRepayDate(hqDebt.getRepayDate());
					hqDebtPool.setDebtLevel(hqDebt.getDebtLevel());
					hqDebtPoolMapper.insert(hqDebtPool);
					break;
				}
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
	
	public JsonMessage modifyHqDebt(HqDebtModel hqDebtModel){
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(hqDebtModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，请仔细核对录入数据");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权名称不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getEnumDebtType())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权类型 不能为空");
			} else if(hqDebtModel.getEnumDebtType()!=200||hqDebtModel.getEnumDebtType()!=300){
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，该状态下不可以修改");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtAmount())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权金额不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getRepayDate())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，还款日期不能为空");
			} else if((hqDebtModel.getRepayDate().before(new Date()))){
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，还款日期不能小于当前日期");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtLevel())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，优先级不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtFrom())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权来源不能为空");
			} else if (DRUtil.isEmptyObject(hqDebtModel.getDebtId())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("债权添加错误，债权ID不能为空");
			}
			else {
				// 添加数据
				HqDebt hqDebt = new HqDebt();
				hqDebt.setDebtId(hqDebtModel.getDebtId());
				hqDebt.setDebtName(hqDebtModel.getDebtName());
				hqDebt.setEnumDebtType(hqDebtModel.getEnumDebtType());
				hqDebt.setDebtAmount(hqDebtModel.getDebtAmount());
				hqDebt.setDebtLevel(hqDebtModel.getDebtLevel());
				hqDebt.setRepayDate(hqDebtModel.getRepayDate());
				hqDebt.setDebtFrom(hqDebtModel.getDebtFrom().trim());
				int debtId = hqDebtMapper.updateByPrimaryKeySelective(hqDebt);
				
				if (debtId > 0) {
					jsonMessage.setFlag(true);
					jsonMessage.setMessage("债权添加成功");
					jsonMessage.setData(debtId);
				} else {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("债权添加失败，请重新操作");
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
}

package com.doro.background.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.SysAdmin;
import com.doro.background.dal.mapper.SysAdminMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.SysAdminModel;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.MD5Util;
import com.doro.component.utils.common.WebUtil;

@Service
public class SysAdminService {

	@Autowired
	private SysAdminMapper sysAdminMapper;

	/**
	 * 用户注册
	 * @param sysAdminModel
	 * @return
	 */
	public JsonMessage register(SysAdminModel sysAdminModel) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			// 校验传入的参数
			if (DRUtil.isEmptyObject(sysAdminModel)) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("注册错误,请仔细核对用户名或者密码");
			} else if (DRUtil.isEmptyObject(sysAdminModel.getAdminName())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("注册错误,用户名不能为空");
			} else if (DRUtil.isEmptyObject(sysAdminModel.getAdminPwd())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("注册错误,密码不能为空");
			} else if (DRUtil.isEmptyObject(sysAdminModel.getConfirmAdminPwd())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("注册错误,确认密码不能为空");
			} else if (!DRUtil.equals(sysAdminModel.getAdminPwd(), sysAdminModel.getConfirmAdminPwd())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("注册错误,两次输入的密码不一致");
			} else {
				// 校验用户是否已经被注册
				SysAdmin sysAdmin = null;
				sysAdmin = sysAdminMapper.selectByAdminName(sysAdminModel.getAdminName());
				// 用户不存在，可以注册
				if (DRUtil.isEmptyObject(sysAdmin)) {
					// 添加用户
					sysAdmin = new SysAdmin();
					sysAdmin.setAdminName(sysAdminModel.getAdminName());
					sysAdmin.setAdminPwd(MD5Util.getMD5String(sysAdminModel.getAdminPwd()+MD5Util.SECRET_KEY));
					int adminId = sysAdminMapper.insert(sysAdmin);
					// 检验是否注册成功
					boolean success = adminId > 0 ? true : false;
					if (success) {
						jsonMessage.setFlag(true);
						jsonMessage.setMessage("注册成功,进入登陆页面");
					} else {
						jsonMessage.setFlag(false);
						jsonMessage.setMessage("注册失败,请重新注册");
					}
				} else {
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("注册失败,用户已存在");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonMessage;
	}
	
	/**
	 * 用户登陆
	 * @param sysAdminModel
	 * @return
	 */
	public JsonMessage sysAdminLogin(SysAdminModel sysAdminModel){
		JsonMessage jsonMessage = new JsonMessage();
		
		try {
			//校验传入的参数
			if(DRUtil.isEmptyObject(sysAdminModel)){
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("登陆错误,请仔细核对用户名或者密码");
			}else if(DRUtil.isEmptyObject(sysAdminModel.getAdminName())){
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("登陆错误,用户名不能为空");
			}else if (DRUtil.isEmptyObject(sysAdminModel.getAdminPwd())) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("登陆错误,密码不能为空");
			}else{
				SysAdmin sysAdmin = null;
				sysAdmin = sysAdminMapper.selectByAdminName(sysAdminModel.getAdminName());
				if(DRUtil.isEmptyObject(sysAdmin)){
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("登陆错误,用户不存在");
				}else if(MD5Util.checkPassword(sysAdmin.getAdminPwd(), MD5Util.getMD5String(sysAdminModel.getAdminPwd()+MD5Util.SECRET_KEY))){
					jsonMessage.setFlag(false);
					jsonMessage.setMessage("登陆错误,密码不正确");
				}else{
					jsonMessage.setFlag(true);
					jsonMessage.setMessage("登陆成功，跳转下一页面");
					WebUtil.getHttpSession().setAttribute("adminName", sysAdmin.getAdminName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonMessage;	
	}
	
	/**
	 * 用户退出
	 * @param sysAdminModal
	 * @return
	 */
	public String sysAdminLogout(){
		String userName = DRUtil.toStr(WebUtil.getHttpSession().getAttribute("adminName"));
		if(!DRUtil.isEmptyObject(userName)){
			WebUtil.getHttpSession().removeAttribute("adminName");
		}
		return "redirect:/login.do";	
	}
}

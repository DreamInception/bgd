package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.SysAdmin;

public interface SysAdminMapper {

	public SysAdmin selectByAdminName(String adminName);
	
	public int insert(SysAdmin sysAdmin);
}

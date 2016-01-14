package com.hotent.core.api.org;

import java.util.List;

import com.hotent.core.api.org.model.ISysUser;

public interface ISysUserService {
	
	
	ISysUser getById(Long userId);
	
	
	List<ISysUser> getByGroup(Long groupId,String groupType);
}

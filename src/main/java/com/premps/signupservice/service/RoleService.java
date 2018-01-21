package com.premps.signupservice.service;

import com.premps.signupservice.model.Role;

public interface RoleService {

	Role findOne(Long roleId);

	void saveRole(Role role);
}

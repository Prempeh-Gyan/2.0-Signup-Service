package com.premps.signupservice.service;

import com.premps.signupservice.model.CustomGrantedAuthority;

public interface PrivilegeService {

	CustomGrantedAuthority fineOneByName(String name);

	void savePrivilege(CustomGrantedAuthority privilege);
}

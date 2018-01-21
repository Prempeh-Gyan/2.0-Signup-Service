package com.premps.signupservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.premps.signupservice.model.Role;
import com.premps.signupservice.repository.RoleRepository;
import com.premps.signupservice.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role findOne(Long roleId) {
		return roleRepository.findOne(roleId);
	}

}

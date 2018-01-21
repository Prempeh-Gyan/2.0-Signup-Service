package com.premps.signupservice.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.premps.signupservice.model.User;
import com.premps.signupservice.service.ClientService;
import com.premps.signupservice.service.RoleService;
import com.premps.signupservice.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class SignupController {

	private final @NotNull UserService userService;

	private final @NotNull RoleService roleService;

	private final @NotNull ClientService clientService;

	@StreamListener(Sink.INPUT)
	public void registerNewUser(User user) {
		log.info("Message recieved from gateKeeper: user is: {} ", user.getFirstName());
		if (!(isDuplicateMember(user, userService.findByEmail(user.getEmail())))) {
			long roleId = 2l;
			user.setRole(roleService.findOne(roleId));
			userService.saveUser(user);
		}
	}

	private boolean isDuplicateMember(User user, User dbUser) {
		if (user != null && dbUser != null) {
			if (user.getFirstName().equalsIgnoreCase(dbUser.getFirstName())
					&& user.getLastName().equalsIgnoreCase(dbUser.getLastName())
					&& user.getEmail().equalsIgnoreCase(dbUser.getEmail())) {
				return true;
			}
		}
		return false;
	}
}

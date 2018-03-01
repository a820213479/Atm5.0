package com.feicui.atm.controller;

import com.feicui.atm.entity.User;

public abstract class AbstractController {

	public abstract void execute();
	public abstract void execute(User user);

}

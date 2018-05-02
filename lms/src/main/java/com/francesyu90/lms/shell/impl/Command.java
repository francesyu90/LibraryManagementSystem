package com.francesyu90.lms.shell.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Controller;

import com.francesyu90.lms.service.IGeneralService;
import com.francesyu90.lms.shell.ICommand;

@ShellComponent
@Controller
public class Command implements ICommand {
	
	@Autowired
	public IGeneralService generalService;

	@Override
	@ShellMethod(value = "displays all libraries")
	public void list() {
		this.generalService.list();
	}

	@Override
	@ShellMethod(value = "creates a library")
	public void create() {
		this.generalService.create();
	}

	@Override
	@ShellMethod(value = "deletes a library")
	public void delete() {
		System.out.println("delete: not yet implemented");
	}

}

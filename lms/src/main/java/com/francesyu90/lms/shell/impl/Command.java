package com.francesyu90.lms.shell.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Controller;

import com.francesyu90.lms.service.ILibraryService;
import com.francesyu90.lms.shell.ICommand;

@ShellComponent
@Controller
public class Command implements ICommand {
	
	@Autowired
	public ILibraryService libraryService;

	@Override
	@ShellMethod(value = "displays all libraries")
	public void list() {
		System.out.println("list: not yet implemented");
	}

	@Override
	@ShellMethod(value = "creates a library")
	public void create() {
		this.libraryService.createLibrary();
	}

	@Override
	@ShellMethod(value = "deletes a library")
	public void delete() {
		System.out.println("delete: not yet implemented");
	}

}

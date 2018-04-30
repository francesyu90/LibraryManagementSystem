package com.example.lms.shell.impl;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.example.lms.shell.CommandInterface;

@ShellComponent
public class Command implements CommandInterface {

	@Override
	@ShellMethod(value = "list: displays all libraries")
	public void list() {
		System.out.println("list: not yet implemented");
	}

	@Override
	@ShellMethod(value = "create: creates a library")
	public void create() {
		System.out.println("create: not yet implemented");
	}

	@Override
	@ShellMethod(value = "delete: deletes a library")
	public void delete() {
		System.out.println("delete: not yet implemented");
	}
	
	
}

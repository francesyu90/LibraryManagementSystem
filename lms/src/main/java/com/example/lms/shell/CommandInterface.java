package com.example.lms.shell;

import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public interface CommandInterface {
	
	public void list();
	
	public void create();
	
	public void delete();

}

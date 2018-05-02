package com.francesyu90.lms.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Controller;

@ShellComponent
@Controller
public interface ICommand {
	
	public void list();
	
	public void create();
	
	public void delete();

}

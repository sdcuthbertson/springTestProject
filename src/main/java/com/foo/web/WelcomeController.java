package com.foo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foo.web.service.ITestService;

@Controller
public class WelcomeController {
	
	@Autowired
	private ITestService testService;
	
	@ModelAttribute
	public void formBacking(ModelMap map){
		map.put("model", new WelcomeModel());
	}
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String onWelcome(@ModelAttribute("model") WelcomeModel model){
		model.setForename("Joe");
		model.setSurname("Bloggs");
		model.setMessage(testService.doSomething());
		return "index";
	}

	@RequestMapping(value ="/success", method = RequestMethod.GET)
	public String onSuccess(){
		return "success";
	}
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public String onWelcomePost(HttpServletRequest req, BindingResult result, @ModelAttribute("model") WelcomeModel model){
		
		if(result.hasErrors()){
			return "index";
		}
		
		return "redirect:/success";
	}
}

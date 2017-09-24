package services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "/card", "/list" })
	public String index() {
	    return "forward:/index.html";
	}
	
}
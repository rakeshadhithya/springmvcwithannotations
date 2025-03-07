package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HomeController extends AbstractController {

    //always keep default constructor when dealing with autowired
	public HomeController(){}

    @SuppressWarnings("null")
    @Override
    @RequestMapping("/home")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return new ModelAndView("homepage", "message", "Welcome to Employee Registry App!");
    }
    
}

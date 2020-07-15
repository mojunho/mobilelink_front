package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = {"", "/"})
public class LoginController {

    @Resource
    UserService userService;

    /**
     * 기본 페이지
     */
    @RequestMapping(method= RequestMethod.GET)
    public String login(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "login";
    }

}

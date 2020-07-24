package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    BoardService boardService;

    // 로그인 페이지, 시작 페이지 ---------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String login(HttpSession httpSession) throws Exception{
        httpSession.invalidate();
        return "views/login";
    }

    // 로그인 처리 후 홈페이지로 이동 / 홈버튼 -----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "homeMain", method = RequestMethod.GET)
    public String homeMain(Model model, HttpSession httpSession) throws Exception {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("userEntity");
        if (userEntity != null) {
            model.addAttribute("id", userEntity.getId());
            model.addAttribute("userName", userEntity.getName());
            return "views/index";
        }
        return "views/login";
    }

    // 로그아웃 ----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "logout" , method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        UserEntity userEntity = (UserEntity)httpSession.getAttribute("userEntity");
        if (userEntity != null) {
            httpSession.invalidate();
        }
        return "redirect:/";
    }

    // 회사 소개 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "company", method = RequestMethod.GET)
    public String company() throws Exception{
        return "views/common/company";
    }

    // 알림 설정 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "alarm", method = RequestMethod.GET)
    public String alarm() throws Exception{
        return "views/common/alarm";
    }

    // 마이 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "mypage", method = RequestMethod.GET)
    public String mypage() throws Exception{
        return "views/common/mypage";
    }

    // 이용약관 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "companyUse", method = RequestMethod.GET)
    public String companyUse() throws Exception{
        return "views/common/company_use";
    }

    // 개인정보 취급 페이지 ---------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "companyPerson", method = RequestMethod.GET)
    public String companyPerson() throws Exception{
        return "views/common/company_person";
    }

}

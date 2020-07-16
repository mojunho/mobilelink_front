package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.service.BoardService;
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
    @Resource
    BoardService boardService;

    /**
     * 기본 페이지
     */
//    @RequestMapping(method= RequestMethod.GET)
//    public String testLogin(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        UserEntity user = userService.selectMember();
//        model.addAttribute("id", user.getId());
//        model.addAttribute("name", user.getName());
//        model.addAttribute("login", user.getLogin());
//        model.addAttribute("password", user.getPassword());
//        model.addAttribute("phonenumber", user.getPhonenumber());
//        model.addAttribute("status", user.getStatus() == 1 ? "일반회원" : "사업자회원");
//        model.addAttribute("createdDate" , user.getCreatedDate());
//        BoardEntity board = boardService.selectOneBoard();
//        model.addAttribute("boardId", board.getId());
//        model.addAttribute("title", board.getTitle());
//        model.addAttribute("content", board.getContent());
//        model.addAttribute("regDate", board.getRegDate());
//        return "views/test_login";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/login";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/index";
    }
}

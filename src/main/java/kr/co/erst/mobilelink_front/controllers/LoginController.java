package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.BoardService;
import kr.co.erst.mobilelink_front.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
//@RequestMapping(value = {"", "/"})
public class LoginController {
    @Resource
    UserService userService;
    @Resource
    BoardService boardService;

    // 로그인 페이지, 시작 페이지
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String login(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "views/login";
    }
    // 로그인 처리 후 홈페이지로 이동
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginCheck(String login, String password, Model model, HttpSession httpSession) throws Exception {
        System.out.println("@@@ login == " + login);
        System.out.println("@@@ password == " + password);
        HashMap<String, Object> test = new HashMap<String, Object>();
        test.put("login", login);
        test.put("password", password);

        UserEntity userEntity = userService.selectForPassword(test);
//        UserEntity userEntity = userService.selectById(userId);
        if (userEntity != null) {
            httpSession.setAttribute("userEntity", userEntity);
            model.addAttribute("msg", "login pass");
            model.addAttribute("id", userEntity.getId());
            model.addAttribute("userName", userEntity.getName());
            return "views/index";
        } else {
            model.addAttribute("msg", "login fail");
            return "views/login";
        }
    }

    // 홈버튼
    @RequestMapping(value = "homeMain", method = RequestMethod.GET)
    public String homeMain(Model model, HttpSession httpSession) throws Exception {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("userEntity");
        model.addAttribute("id", userEntity.getId());
        model.addAttribute("userName", userEntity.getName());
        return "views/index";
    }

    // 게시판 페이지
    @RequestMapping(value = "sktBoard", method = RequestMethod.GET)
    public String sktBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/skt_board";
    }
    @RequestMapping(value = "ktBoard", method = RequestMethod.GET)
    public String ktBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/kt_board";
    }
    @RequestMapping(value = "lgtBoard", method = RequestMethod.GET)
    public String lgtBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/lgt_board";
    }
    @RequestMapping(value = "internetBoard", method = RequestMethod.GET)
    public String internetBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/internet_board";
    }
    @RequestMapping(value = "lifeMachineBoard", method = RequestMethod.GET)
    public String lifeMachineBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/life_machine_board";
    }
    @RequestMapping(value = "eventBoard", method = RequestMethod.GET)
    public String eventBoard(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/event_board";
    }

    // 게시판 상세보기 페이지
    @RequestMapping(value = "sktView", method = RequestMethod.GET)
    public String sktView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/skt_view";
    }
    @RequestMapping(value = "ktView", method = RequestMethod.GET)
    public String ktView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/kt_view";
    }
    @RequestMapping(value = "lgtView", method = RequestMethod.GET)
    public String lgtView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/lgt_view";
    }
    @RequestMapping(value = "internetView", method = RequestMethod.GET)
    public String internetView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/internet_view";
    }
    @RequestMapping(value = "lifeMachineView", method = RequestMethod.GET)
    public String lifeMachineView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/life_machine_view";
    }
    @RequestMapping(value = "eventView", method = RequestMethod.GET)
    public String eventView(final Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "views/boards/boardview/event_view";
    }
}

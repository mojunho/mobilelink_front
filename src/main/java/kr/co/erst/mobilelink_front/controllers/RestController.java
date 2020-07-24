package kr.co.erst.mobilelink_front.controllers;

import kr.co.erst.mobilelink_front.entities.RestEntity;
import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {

    @Resource
    UserService userService;

    // 로그인 alert 프로세스---------------------------------------------------------------------------------------------------------------------------------------
    @ResponseBody
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public Map loginProcess(@RequestBody RestEntity restEntity, HttpSession httpSession) {
        System.out.println("@@@ login : "+restEntity.getLogin());
        System.out.println("@@@ password : "+restEntity.getPassword());
        HashMap res = new HashMap();
        try {
            UserEntity user = userService.selectCheckForlogin(restEntity.getLogin());
            if (user != null) {
                if (!user.getPassword().equals(restEntity.getPassword())) {
                    res.put("msg", "비밀번호를 확인해주세요.");
                } else  {
                    httpSession.setAttribute("userEntity", user);
                    res.put("msg", "로그인 되었습니다.");
                }
            } else {
                res.put("msg", "아이디를 확인해주세요.");
            }
        } catch (Exception e) {
            res.put("msg", "에러");
            e.printStackTrace();
        }
        return res;
    }
}

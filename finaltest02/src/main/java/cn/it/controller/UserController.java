package cn.it.controller;

import cn.it.domain.Condition;
import cn.it.domain.PageBean;
import cn.it.domain.User;
import cn.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(User user, Integer ck, HttpSession session, HttpServletResponse response) {
        User u = userService.login(user);
        if (u == null) {
            return "loginError";
        }
        Cookie cookieName = new Cookie("username", u.getUsername());
        Cookie cookiePassword = new Cookie("password", u.getPassword());
        if (ck != null && ck == 1) {
            cookieName.setMaxAge(7 * 60 * 60 * 24);
            cookiePassword.setMaxAge(7 * 60 * 60 * 24);
        } else {
            cookieName.setMaxAge(0);
            cookiePassword.setMaxAge(0);
        }
        cookieName.setPath("/");
        cookiePassword.setPath("/");
        response.addCookie(cookieName);
        response.addCookie(cookiePassword);
        session.setAttribute("user", u);
        return "index1";
    }

    @RequestMapping("/findAll")
    public String findAll( Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "list";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletResponse response, HttpServletRequest request) throws IOException {
        userService.addUser(user);
        return "redirect:/user/findUserByCondition";
        //response.sendRedirect(request.getContextPath()+"/user/findUserByCondition");
    }

    @RequestMapping("/findUserByCondition")
    public String findUserByCondition(Model model, @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, Condition condition) {
        PageBean<User> pageBean = userService.findUserByCondition(condition, pageNum);
        List<User> list = pageBean.getList();
        for (User user : list) {
            System.out.println(user.getId());
        }
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("condition",condition);
        return "list";
    }

    @RequestMapping("/delUser")
    public String delUser(Integer id) throws IOException {
        //response.sendRedirect(request.getContextPath()+"/user/findUserByCondition");
        userService.delUser(id);
        return "redirect:/user/findUserByCondition";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Model model,Integer id,User user){
        userService.updateUser(user);
        return "redirect:/user/findUserByCondition";
    }


}

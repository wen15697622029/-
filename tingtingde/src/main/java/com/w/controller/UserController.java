package com.w.controller;

import com.w.model.Recruit_Information;
import com.w.model.User;
import com.w.service.Recruit_InformationService;
import com.w.service.UserService;
import com.w.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
     private Recruit_InformationService recruit_informationService;
    @RequestMapping("/checkName")
    public void checkName(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(user.getUname());
        response.setContentType("text/html;charset=utf-8");
        User user1 = userService.getUserByName(user);
        if (user1==null){
            request.setAttribute("error","可以注册");
        }else{
            response.getWriter().print("该用户已存在");
        }
    }
    @RequestMapping("/register")
    public String register(User user, HttpSession session, Model model) throws Exception{
        User user1 = userService.getUserByName(user);
        if (null==user1){
            userService.addUser(user);
            return "../../login";
        }
        model.addAttribute("str","该用户名已存在");
        return "../../register";
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model) throws Exception{
        User user1 = userService.getUserByNamePass(user);
        if (null!=user1){
            session.setAttribute("user",user1);
           return "redirect:user";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../login";
    }
    @RequestMapping("/")
    public String begin(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "../../start";
    }
    @RequestMapping("/index")
    public String index(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "../../start ";
    }
    @RequestMapping("/user")
    public String user(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "user";
    }
}

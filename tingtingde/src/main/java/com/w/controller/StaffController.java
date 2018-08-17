package com.w.controller;

import com.w.model.*;
import com.w.service.*;
import com.w.util.DoPage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */
@Controller
public class StaffController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JobService jobService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private StaffService staffService;
    @Resource
    private Recruit_InformationService recruit_informationService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private CultivateService cultivateService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RapService rapService;
    @Resource
    private PayService payService;
    @RequestMapping("/staffLogin")
    public String staffLogin(Staff staff, HttpSession session, Model model) throws Exception{
        staff = staffService.getStaffByNamePass(staff);
        if (null!=staff){
            session.setAttribute("staff",staff);
            return "redirect:staff";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../staffLogin";
    }
    @RequestMapping("/staff")
    public String staff(@RequestParam(value = "sstate",defaultValue = "1")int sstate,@RequestParam(value = "did",defaultValue = "0")int did,@RequestParam(value = "jid",defaultValue = "0")int jid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=staffService.getStaffByDidJidState(did,jid,sstate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Staff> staffs = staffService.queryCurrentPageStaffByDidJidState(did,jid,sstate,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("sstate",sstate);
        request.setAttribute("did",did);
        request.setAttribute("jid",jid);
        request.setAttribute("staffs",staffs);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staff";
    }
    @RequestMapping("/staffDetail")
    public String staffDetail() throws Exception{
        return "staffDetail";
    }
    @RequestMapping("/updateDetail")
    public String updateDetail() throws Exception{
        return "updateDetail";
    }
    @RequestMapping("/updateD")
    public String updateD(Staff staff,HttpSession session) throws Exception{
        staffService.updateStaff(staff);
        staff=staffService.getStaffBySid(staff.getSid());
        session.setAttribute("staff",staff);
        return "redirect:staffDetail";
    }
    @RequestMapping("/cultivateMessage")
    public String cultivateMessage(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=cultivateService.getCountBySid(staff.getSid());
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates=cultivateService.getCultivateBySid(staff.getSid(),begin,end);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "cultivateMessage";
    }
    @RequestMapping("/attendanceMessage")
    public String attendanceMessage(@DateTimeFormat(pattern="yyyy-MM-dd")Date adate, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request, HttpSession session) throws Exception{
        if (adate==null){
            adate=new Date();
        }
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=attendanceService.getCountMonthBySid(staff.getSid(),adate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances=attendanceService.queryCountMonthBySid(staff.getSid(),adate,begin,end);
        request.setAttribute("attendances",attendances);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("adate",adate);
        request.setAttribute("totalPages",totalPages);
        return "attendanceMessage";
    }
    @RequestMapping("/on")
    public void on(HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = (Staff) session.getAttribute("staff");
        Attendance attendance = new Attendance();
        attendance.setStaff(staff);
        int count = attendanceService.getCountDayBySid(staff.getSid());
        if (count!=0){
            response.getWriter().print("该天已打上班卡");
        }else{
            attendanceService.addAttendance(attendance);
            response.getWriter().print("打上班卡成功");
        }
    }
    @RequestMapping("/off")
    public void off(HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = (Staff) session.getAttribute("staff");
        Attendance attendance = new Attendance();
        attendance.setStaff(staff);
        int count = attendanceService.getCountDayBySid(staff.getSid());
        if (count==0){
            response.getWriter().print("该天未打上班卡，请联系管理员");
            return;
        }else {
            attendance = attendanceService.getAttendanceBySid(staff.getSid());
            if (attendance.getAstate() == 0) {//第一次打下班卡
                attendanceService.off(attendance.getAid());//打下班卡
                attendance = attendanceService.getAttendanceBySid(staff.getSid());//获取打卡记录
                double onMinutes = attendanceService.getOnMinutes(staff.getSid());//上班打卡
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//下班打卡
                if (onMinutes >= 0) {//上班打卡9:00之前
                    if (offMinutes >= 0) {//下班打卡18:00之后
                        if (offMinutes <= 30) {//下班打卡18:30之前
                            attendance.setAstate(1);//正常上班打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("正常下班打卡");
                            return;
                        } else {//下班打卡18:30之后 加班
                            attendance.setAstate(2);//正常加班打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("正常加班打卡");
                            return;
                        }
                    } else if (offMinutes > -180) {//下班打卡18:00之前 15:00之后 早退
                        attendance.setAstate(3);//早退打卡
                        attendanceService.updateAttendance(attendance);
                        Rap rap = new Rap(-100, staff, "早退");
                        rapService.addRap(rap);
                        response.getWriter().print("早退打卡");
                        return;
                    } else {//下班打卡15:00之前 旷工
                        attendance.setAstate(7);//旷工打卡
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("早退超3小时旷工打卡");
                        return;
                    }
                } else if (onMinutes > -180) {//上班打卡9:00之后 12:00之前 迟到
                    if (offMinutes >= 0) {//下班打卡18:00之后
                        if (offMinutes <= 30) {//下班打卡18:30之前
                            attendance.setAstate(4);//迟到打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            rapService.addRap(rap);
                            response.getWriter().print("迟到打卡");
                            return;
                        } else {//下班打卡18:30之后 加班
                            attendance.setAstate(5);//迟到加班打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            rapService.addRap(rap);
                            response.getWriter().print("迟到加班打卡");
                            return;
                        }
                    } else if (offMinutes > -180) {//下班打卡18:00之前 15:00之前 早退
                        if ((onMinutes + offMinutes) <= -180) {
                            attendance.setAstate(7);//迟到早退旷工打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("迟到早退超3小时旷工打卡");
                            return;
                        } else {
                            attendance.setAstate(6);//迟到加早退打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            Rap rap1 = new Rap(-100, staff, "早退");
                            rapService.addRap(rap);
                            rapService.addRap(rap1);
                            response.getWriter().print("迟到加早退打卡");
                            return;
                        }
                    } else {//下班打卡15:00之前 旷工
                        attendance.setAstate(7);//早退超3小时旷工打卡
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("早退超3小时旷工打卡");
                        return;
                    }
                } else if(offMinutes>30){
                    attendance.setAstate(8);//迟到超3小时旷工加班打卡
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("迟到超3小时旷工加班打卡");
                    return;
                }else{//上班打卡12:00之后 旷工
                    attendance.setAstate(7);//迟到超3小时旷工旷工打卡
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("迟到超3小时旷工打卡");
                    return;
                }
            } else if (attendance.getAstate() == 1) {
                attendance.setAstate(2);//变成加班打卡
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getAid());//打加班卡
                response.getWriter().print("正常加班打卡");
                return;
            } else if (attendance.getAstate() == 2) {
                attendanceService.off(attendance.getAid());//打加班卡
                response.getWriter().print("正常加班时间更新成功");
                return;
            } else if (attendance.getAstate() == 4) {
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//下班打卡
                if (offMinutes>30) {
                    attendance.setAstate(5);//迟到变迟到加班
                    attendanceService.updateAttendance(attendance);
                    attendanceService.off(attendance.getAid());//打加班卡
                    response.getWriter().print("迟到加班打卡");
                    return;
                }else{
                    response.getWriter().print("未到加班时间");
                    return;
                }

            } else if (attendance.getAstate() == 5) {
                attendanceService.off(attendance.getAid());//打加班卡
                response.getWriter().print("迟到加班时间更新成功");
                return;
            } else if (attendance.getAstate() == 7) {
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//下班打卡
                if (offMinutes>30){
                    attendance.setAstate(8);//旷工变旷工加班
                    attendanceService.updateAttendance(attendance);
                    attendanceService.off(attendance.getAid());//打加班卡
                    response.getWriter().print("旷工加班打卡");
                    return;
                }else{
                    response.getWriter().print("早退旷工不能加班");
                    return;
                }
            }else if (attendance.getAstate() == 8) {
                attendanceService.off(attendance.getAid());//打加班卡
                response.getWriter().print("旷工加班时间更新成功");
                return;
            } else {
                response.getWriter().print("打卡异常，请联系管理员");
                return;
            }
        }
    }
    @RequestMapping("/rapMessage")
    public String rapMessage(@DateTimeFormat(pattern="yyyy-MM-dd")Date radate,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        if (radate==null){
            radate=new Date();
        }
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=rapService.getCountMonthBySid(staff.getSid(),radate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Rap> raps=rapService.queryCountMonthBySid(staff.getSid(),radate,begin,end);
        request.setAttribute("raps",raps);
        request.setAttribute("radate",radate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "rapMessage";
    }
    @RequestMapping("/payMessage")
    public String payMessage(@DateTimeFormat(pattern="yyyy-MM-dd")Date pdate, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request, HttpSession session) throws Exception{
        if (pdate==null){
            pdate=new Date();
        }
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=payService.getCountBySid(staff.getSid(),pdate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays=payService.queryCountBySid(staff.getSid(),pdate,begin,end);
        request.setAttribute("pays",pays);
        request.setAttribute("pdate",pdate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "payMessage";
    }
    @RequestMapping("/affirm")
    public void affirm(int pid,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        payService.updatePayPstate(pid,1);
        response.getWriter().print("薪资确认成功");
    }
    @RequestMapping("/reconsider")
    public void reconsider(int pid,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        payService.updatePayPstate(pid,2);
        response.getWriter().print("薪资复议申请成功");
    }
}


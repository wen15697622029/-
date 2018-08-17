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
        model.addAttribute("str","�û������������");
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
            response.getWriter().print("�����Ѵ��ϰ࿨");
        }else{
            attendanceService.addAttendance(attendance);
            response.getWriter().print("���ϰ࿨�ɹ�");
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
            response.getWriter().print("����δ���ϰ࿨������ϵ����Ա");
            return;
        }else {
            attendance = attendanceService.getAttendanceBySid(staff.getSid());
            if (attendance.getAstate() == 0) {//��һ�δ��°࿨
                attendanceService.off(attendance.getAid());//���°࿨
                attendance = attendanceService.getAttendanceBySid(staff.getSid());//��ȡ�򿨼�¼
                double onMinutes = attendanceService.getOnMinutes(staff.getSid());//�ϰ��
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//�°��
                if (onMinutes >= 0) {//�ϰ��9:00֮ǰ
                    if (offMinutes >= 0) {//�°��18:00֮��
                        if (offMinutes <= 30) {//�°��18:30֮ǰ
                            attendance.setAstate(1);//�����ϰ��
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�����°��");
                            return;
                        } else {//�°��18:30֮�� �Ӱ�
                            attendance.setAstate(2);//�����Ӱ��
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�����Ӱ��");
                            return;
                        }
                    } else if (offMinutes > -180) {//�°��18:00֮ǰ 15:00֮�� ����
                        attendance.setAstate(3);//���˴�
                        attendanceService.updateAttendance(attendance);
                        Rap rap = new Rap(-100, staff, "����");
                        rapService.addRap(rap);
                        response.getWriter().print("���˴�");
                        return;
                    } else {//�°��15:00֮ǰ ����
                        attendance.setAstate(7);//������
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("���˳�3Сʱ������");
                        return;
                    }
                } else if (onMinutes > -180) {//�ϰ��9:00֮�� 12:00֮ǰ �ٵ�
                    if (offMinutes >= 0) {//�°��18:00֮��
                        if (offMinutes <= 30) {//�°��18:30֮ǰ
                            attendance.setAstate(4);//�ٵ���
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            rapService.addRap(rap);
                            response.getWriter().print("�ٵ���");
                            return;
                        } else {//�°��18:30֮�� �Ӱ�
                            attendance.setAstate(5);//�ٵ��Ӱ��
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            rapService.addRap(rap);
                            response.getWriter().print("�ٵ��Ӱ��");
                            return;
                        }
                    } else if (offMinutes > -180) {//�°��18:00֮ǰ 15:00֮ǰ ����
                        if ((onMinutes + offMinutes) <= -180) {
                            attendance.setAstate(7);//�ٵ����˿�����
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�ٵ����˳�3Сʱ������");
                            return;
                        } else {
                            attendance.setAstate(6);//�ٵ������˴�
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            Rap rap1 = new Rap(-100, staff, "����");
                            rapService.addRap(rap);
                            rapService.addRap(rap1);
                            response.getWriter().print("�ٵ������˴�");
                            return;
                        }
                    } else {//�°��15:00֮ǰ ����
                        attendance.setAstate(7);//���˳�3Сʱ������
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("���˳�3Сʱ������");
                        return;
                    }
                } else if(offMinutes>30){
                    attendance.setAstate(8);//�ٵ���3Сʱ�����Ӱ��
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("�ٵ���3Сʱ�����Ӱ��");
                    return;
                }else{//�ϰ��12:00֮�� ����
                    attendance.setAstate(7);//�ٵ���3Сʱ����������
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("�ٵ���3Сʱ������");
                    return;
                }
            } else if (attendance.getAstate() == 1) {
                attendance.setAstate(2);//��ɼӰ��
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getAid());//��Ӱ࿨
                response.getWriter().print("�����Ӱ��");
                return;
            } else if (attendance.getAstate() == 2) {
                attendanceService.off(attendance.getAid());//��Ӱ࿨
                response.getWriter().print("�����Ӱ�ʱ����³ɹ�");
                return;
            } else if (attendance.getAstate() == 4) {
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//�°��
                if (offMinutes>30) {
                    attendance.setAstate(5);//�ٵ���ٵ��Ӱ�
                    attendanceService.updateAttendance(attendance);
                    attendanceService.off(attendance.getAid());//��Ӱ࿨
                    response.getWriter().print("�ٵ��Ӱ��");
                    return;
                }else{
                    response.getWriter().print("δ���Ӱ�ʱ��");
                    return;
                }

            } else if (attendance.getAstate() == 5) {
                attendanceService.off(attendance.getAid());//��Ӱ࿨
                response.getWriter().print("�ٵ��Ӱ�ʱ����³ɹ�");
                return;
            } else if (attendance.getAstate() == 7) {
                double offMinutes = attendanceService.getOffMinutes(staff.getSid());//�°��
                if (offMinutes>30){
                    attendance.setAstate(8);//����������Ӱ�
                    attendanceService.updateAttendance(attendance);
                    attendanceService.off(attendance.getAid());//��Ӱ࿨
                    response.getWriter().print("�����Ӱ��");
                    return;
                }else{
                    response.getWriter().print("���˿������ܼӰ�");
                    return;
                }
            }else if (attendance.getAstate() == 8) {
                attendanceService.off(attendance.getAid());//��Ӱ࿨
                response.getWriter().print("�����Ӱ�ʱ����³ɹ�");
                return;
            } else {
                response.getWriter().print("���쳣������ϵ����Ա");
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
        response.getWriter().print("н��ȷ�ϳɹ�");
    }
    @RequestMapping("/reconsider")
    public void reconsider(int pid,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        payService.updatePayPstate(pid,2);
        response.getWriter().print("н�ʸ�������ɹ�");
    }
}


package com.w.controller;

import com.w.model.*;
import com.w.service.*;
import com.w.util.DateAndString;
import com.w.util.DoPage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by destiny on 2018/7/18/0018.
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;
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
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, HttpSession session, Model model) throws Exception{
        admin = adminService.getAdminByNamePass(admin);
        if (null!=admin){
            session.setAttribute("admin",admin);
            return "redirect:admin";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../adminLogin";
    }
    @RequestMapping("/admin")
    public String admin(@RequestParam(value = "sstate",defaultValue = "1")int sstate,
                        @RequestParam(value = "did",defaultValue = "0")int did,
                        @RequestParam(value = "jid",defaultValue = "0")int jid,
                        @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                        HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=staffService.getStaffByDidJidState(did,jid,sstate);
        List<Job> jobs=jobService.getJobByDid(did);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Staff> staffs = staffService.queryCurrentPageStaffByDidJidState(did,jid,sstate,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("sstate",sstate);
        request.setAttribute("jobs",jobs);
        request.setAttribute("did",did);
        request.setAttribute("jid",jid);
        request.setAttribute("staffs",staffs);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "admin";
    }
    @RequestMapping("/ri")
    public String ri(@RequestParam(value = "ristate",defaultValue = "1")int ristate,
                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                     HttpServletRequest request,HttpSession session) throws Exception{
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(ristate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations =
                recruit_informationService.queryCurrentPageRecruit_InformationByRiState(ristate,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("ristate",ristate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "ri";
    }
    @RequestMapping("/recall")
    public void recall(@RequestParam(value = "riid",defaultValue = "0")int riid,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(riid);
        recruitInformation.setRistate(0);
        recruitInformation.setRidate(null);
        recruit_informationService.updateRecruit_Information(recruitInformation);
        response.getWriter().print("撤回成功");
    }
    @RequestMapping("/issue")
    public void issue(@RequestParam(value = "riid",defaultValue = "0")int riid, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(riid);
        recruitInformation.setRistate(1);
        recruit_informationService.updateRecruit_Information(recruitInformation);
        response.getWriter().print("发布成功");
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "riid",defaultValue = "0")int riid, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        recruit_informationService.deleteRecruit_Information(riid);
        response.getWriter().print("删除成功");
    }
    @RequestMapping("/alter")
    public String alter(@RequestParam(value = "riid",defaultValue = "0")int riid, HttpServletRequest request) throws Exception{
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(riid);
        List<Department> departments = departmentService.getDepartment();
        List<Job> jobs = jobService.getJob();
        request.setAttribute("departments",departments);
        request.setAttribute("jobs",jobs);
        request.setAttribute("recruitInformation",recruitInformation);
        return "alter";
    }
    @RequestMapping("/addRi")
    public String addRi(HttpServletRequest request) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        List<Job> jobs = jobService.getJob();
        request.setAttribute("departments",departments);
        request.setAttribute("jobs",jobs);
        return "alter";
    }
    @RequestMapping("/update")
    public String update(Recruit_Information recruit_information, HttpServletRequest request) throws Exception{
        if(recruit_information.getRiid()==0){
            recruit_informationService.addRecruit_Information(recruit_information);
        }else{
            recruit_informationService.updateRecruit_Information(recruit_information);
        }
        return "redirect:ri";
    }
    @RequestMapping("/r")
    public String r(@RequestParam(value = "ristate",defaultValue = "1")int ristate,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(ristate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(ristate,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("ristate",ristate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "r";
    }
    @RequestMapping("/check")
    public String check(@RequestParam(value = "riid",defaultValue = "0")int riid,
                        @RequestParam(value = "rstate",defaultValue = "0")int rstate,
                        @RequestParam(value = "currentPage",defaultValue = "1")
                                    int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 1;
        int totalRows=recruitService.getRecruitByRiidRstate(riid,rstate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit> recruits = recruitService.queryCurrentPageRecruitByRiidRstate(riid,rstate,begin,end);
        if (!recruits.isEmpty()){
            Recruit recruit = recruits.get(0);
            if (recruit.getRstate()==0){
                recruit.setRstate(1);//取出的标记为已读
                recruitService.updateRecruit(recruit);
            }
        }
        Recruit_Information recruitInformation=recruit_informationService.getRecruit_InformationByRiid(riid);
        request.setAttribute("recruits",recruits);
        request.setAttribute("recruitInformation",recruitInformation);
        request.setAttribute("rstate",rstate);
        request.setAttribute("riid",riid);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "check";
    }
    @RequestMapping("/refuse")
    public String refuse(int riid,int rid) throws Exception{
        Recruit recruit = recruitService.getRecruitByRid(rid);
        recruit.setRstate(3);
        recruitService.updateRecruit(recruit);
        return "redirect:check?riid="+riid;
    }
    @RequestMapping("/interview")
    public String interview(int rid, HttpServletRequest request) throws Exception{
        Recruit recruit = recruitService.getRecruitByRid(rid);
        List<Staff> staffs=staffService.getStaffsByDidJidState(recruit.getRecruitInformation().getDepartment().getDid(),0,1);
        request.setAttribute("recruit",recruit);
        request.setAttribute("staffs",staffs);
        return "interview";
    }
    @RequestMapping("/addInterview")
    public String addInterview(String midate,int rid,Interview interview, HttpServletRequest request) throws Exception{
        midate=midate.replaceAll("T"," ");
        Date idate= DateAndString.dateToStringTime(midate);
        Recruit recruit = recruitService.getRecruitByRid(rid);
        recruit.setRstate(2);
        recruitService.updateRecruit(recruit);//更新为面试
        interview.setIdate(idate);
        interview.setUser(recruit.getResume().getUser());//设置用户
        interview.setRecruit_information(recruit.getRecruitInformation());//招聘信息
        interviewService.addInterview(interview);
        int riid = recruit.getRecruitInformation().getRiid();
        return "redirect:check?riid="+riid;
    }
    @RequestMapping("/interviewManage")
    public String interviewManage(@RequestParam(value = "istate",defaultValue = "1")int istate,int riid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=interviewService.getInterviewByRiid(riid,istate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews = interviewService.queryCurrentPageInterviewByRiid(riid,istate,begin,end);
        request.setAttribute("interviews",interviews);
        request.setAttribute("riid",riid);
        request.setAttribute("istate",istate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "interviewManage";
    }
    @RequestMapping("/hire")
    public void hire(int iid, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Interview interview =  interviewService.getInterviewByIid(iid);
        int riid = interview.getRecruit_information().getRiid();
        int uid = interview.getUser().getUid();
        User user=userService.getUserById( uid );
        Recruit recruit=recruitService.getRecruitByUidRiid(uid,riid);
        Recruit_Information recruitInformation = recruit.getRecruitInformation();
        Resume resume = recruit.getResume();
        Staff staff=new Staff(user.getUname(),user.getUpass(),recruitInformation.getDepartment(),recruitInformation.getJob(),0,resume.getRename(),
                resume.getResex(),resume.getReidcardno(),resume.getRebirthday(),resume.getRephone(),
                resume.getReemail(),resume.getReaddress(),resume.getRepost(),resume.getReeducation(),
                resume.getRecollege(),resume.getRemajor(),resume.getRegraduate(),resume.getReintro());
        staffService.addStaff(staff);
        interview.setIstate(3);
        interviewService.updateInterview(interview);
        response.getWriter().print("录用成功");
    }
    @RequestMapping("/loadJob")
    @ResponseBody
    public Object loadJob(int did, HttpServletResponse response) throws Exception{
        List<Job> jobList = jobService.getJobByDid(did);
        return jobList;
    }
    @RequestMapping("/load")
    @ResponseBody
    public Object load(int jid, HttpServletResponse response) throws Exception{
        Job job = jobService.getJobByJid(jid);
        return job;
    }
    @RequestMapping("/organizationalManagement")
    public String organizationalManagement(HttpServletRequest request) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        request.setAttribute("departments",departments);
        return "organizationalManagement";
    }
    @RequestMapping("/deld")
    public void deld(int did,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=staffService.countStaffByDid(did);//获取该部门人数
        if (count==0){//没有人删除
            jobService.deleteJobByDid(did);//删除该部门下职位
            departmentService.deleteDepartment(did);//删除该部门
            response.getWriter().print("部门删除成功");
        }else{
            response.getWriter().print("该部门还有员工，不能删除");
        }
    }
    @RequestMapping("/delj")
    public void delj(int jid,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=staffService.countStaffByJid(jid);//获取该职位人数
        if (count==0){//没有人删除
            jobService.deleteJobByJid(jid);//删除该职位
            response.getWriter().print("职位删除成功");
        }else{
            response.getWriter().print("该职位还有员工，不能删除");
        }
    }
    @RequestMapping("/addd")
    public void addd(String dname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        departmentService.addDepartment(dname);
        response.getWriter().print("添加部门成功");
    }
    @RequestMapping("/updated")
    public void updated(int did,String dname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        departmentService.updateDepartment(did,dname);
        response.getWriter().print("修改部门成功");
    }
    @RequestMapping("/addj")
    public void addj(int did,double jsalary,String jname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        jobService.addJob(did,jname,jsalary);
        response.getWriter().print("添加职位成功");
    }
    @RequestMapping("/updatej")
    public void updatej(int jid,double jsalary,String jname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        jobService.updateJob(jid,jname,jsalary);
        response.getWriter().print("修改职位成功");
    }
    @RequestMapping("/dimission")
    public void dimission(int sid,String sintro,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = staffService.getStaffBySid(sid);
        staff.setDepartment(new Department(0));
        staff.setJob(new Job(0));
        staff.setSintro(sintro);
        staff.setSstate(2);
        staffService.updateStaff(staff);
        response.getWriter().print("离职办理成功");
    }
    @RequestMapping("/positive")
    public void positive(int sid,String sintro,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        double months = staffService.getMonthsBySid(sid);
        if (months>=1){
            Staff staff = staffService.getStaffBySid(sid);
            staff.setSintro(sintro);
            staff.setSstate(1);
            staffService.updateStaff(staff);
            response.getWriter().print("转正办理成功");
        }else{
            response.getWriter().print("试用期不足一个月不能转正");
        }
    }
    @RequestMapping("/change")
    public void change(int sid,int did,int jid,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = staffService.getStaffBySid(sid);
        staff.getDepartment().setDid(did);
        staff.getJob().setJid(jid);
        staffService.updateStaff(staff);
        response.getWriter().print("转岗办理成功");
    }
    @RequestMapping("/cultivate")
    public String cultivate(@RequestParam(value = "cstate",defaultValue = "1")int cstate,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 5;
        int totalRows=cultivateService.getCultivateByCstate(cstate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates = cultivateService.queryCurrentPageCultivateByCstate(cstate,begin,end);
        List<Department> departments=departmentService.getDepartment();
        request.setAttribute("departments",departments);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("cstate",cstate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "cultivate";
    }
    @RequestMapping("/addcultivate1")
    public String addcultivate1(HttpServletRequest request) throws Exception{
        List<Department> departments=departmentService.getDepartment();
        request.setAttribute("departments",departments);
        return "addCultivate";
    }
    @RequestMapping("/addcultivate")
    public String addcultivate(Cultivate cultivate,String begintime,String endtime,HttpServletRequest request) throws Exception{
        begintime=begintime.replaceAll("T"," ");
        Date cbegintime= DateAndString.dateToStringTime(begintime);
        endtime=endtime.replaceAll("T"," ");
        Date cendtime= DateAndString.dateToStringTime(endtime);
        cultivate.setCbegintime(cbegintime);
        cultivate.setCendtime(cendtime);
        int cid=cultivate.getCid();
        if (cid==0){
            cultivateService.addCultivate(cultivate);
        }else{
            cultivateService.updateCultivate(cultivate);
        }

        return "redirect:cultivate";
    }
    @RequestMapping("/issueCultivate")
    public void issueCultivate(int cid,int did,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if (did==0){
            Calendar calendar=Calendar.getInstance();
            int day=calendar.get(calendar.DAY_OF_MONTH);
            if (day!=1){
                response.getWriter().print("每月1号才可以发布新人培训");
                return;
            }
            List<Staff> staffs = staffService.getStaffBySstate(0);
            for (Staff staff:staffs) {
                double months=staffService.getMonthsBySid(staff.getSid());
                if (months<1){
                    staffService.addCultivate(staff.getSid(),cid);
                }
            }
        }else{
            List<Staff> staffs = staffService.getStaffByDid(did);
            for (Staff staff:staffs) {
                staffService.addCultivate(staff.getSid(),cid);
            }
        }
        Cultivate cultivate = cultivateService.getCultivateByCid(cid);
        cultivate.setCstate(1);
        cultivate.setCissuetime(new Date());
        cultivateService.updateCultivate(cultivate);
        response.getWriter().print("培训发布成功");
    }
    @RequestMapping("/recallCultivate")
    public void recallCultivate(int cid,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        double minutes = cultivateService.getMinutesByCid(cid);
        if(minutes>10){
            response.getWriter().print("已发布10分钟，不能撤回");
        }else {
            staffService.deleteCultivate(cid);
            Cultivate cultivate = new Cultivate();
            cultivate.setCstate(0);
            cultivate.setCid(cid);
            cultivateService.updateCultivate(cultivate);
            response.getWriter().print("培训撤回成功");
        }
    }
    @RequestMapping("/updateCultivate1")
    public String updateCultivate1(int cid,HttpServletRequest request) throws Exception{
        Cultivate cultivate = cultivateService.getCultivateByCid(cid);
        request.setAttribute("cultivate",cultivate);
        return "addCultivate";
    }
    @RequestMapping("/staffAttendance")
    public String staffAttendance(@DateTimeFormat(pattern="yyyy-MM-dd")Date adate, int sid, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        if (adate==null){
            adate=new Date();
        }
        int pageSize = 10;
        int totalRows=attendanceService.getCountMonthBySid(sid,adate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances = attendanceService.queryCountMonthBySid(sid,adate,begin,end);
        request.setAttribute("attendances",attendances);
        request.setAttribute("sid",sid);
        request.setAttribute("adate",adate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staffAttendance";
    }
    @RequestMapping("/staffCultivate")
    public String staffCultivate(int sid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=cultivateService.getCountBySid(sid);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates = cultivateService.getCultivateBySid(sid,begin,end);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("sid",sid);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staffCultivate";
    }
    @RequestMapping("/staffInformation")
    public String staffInformation(int sid,HttpServletRequest request) throws Exception{
        Staff staff = staffService.getStaffBySid(sid);
        request.setAttribute("staff",staff);
        return "staffInformation";
    }
    @RequestMapping("/attendanceInformation")
    public String attendanceInformation(@DateTimeFormat(pattern="yyyy-MM-dd")Date adate,@RequestParam(value = "did",defaultValue = "0")int did,@RequestParam(value = "jid",defaultValue = "0")int jid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        if (adate==null){
            adate = new Date();
        }
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        List<Job> jobs=jobService.getJobByDid(did);
        int totalRows=attendanceService.getCountDayByDidJid(did,jid,adate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances = attendanceService.queryCurrentPageStaffDayByDidJid(did,jid,adate,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("did",did);
        request.setAttribute("jobs",jobs);
        request.setAttribute("jid",jid);
        request.setAttribute("adate",adate);
        request.setAttribute("attendances",attendances);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "attendanceInformation";
    }
    @RequestMapping("/rap")
    public String rap(@DateTimeFormat(pattern="yyyy-MM-dd")Date radate,@RequestParam(value = "did",defaultValue = "0")int did,@RequestParam(value = "jid",defaultValue = "0")int jid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        if (radate==null){
            radate=new Date();
        }
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        List<Job> jobs=jobService.getJobByDid(did);
        int totalRows=rapService.getCountDayByDidJid(did,jid,radate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Rap> raps = rapService.queryCurrentPageStaffDayByDidJid(did,jid,radate,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("did",did);
        request.setAttribute("jobs",jobs);
        request.setAttribute("radate",radate);
        request.setAttribute("jid",jid);
        request.setAttribute("raps",raps);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "rap";
    }
    @RequestMapping("/pay")
    public String pay(@DateTimeFormat(pattern="yyyy-MM-dd")Date pdate, @RequestParam(value = "did",defaultValue = "0")int did, @RequestParam(value = "jid",defaultValue = "0")int jid, @RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request, HttpSession session) throws Exception{
        if (pdate==null){
            pdate=new Date();
        }
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        List<Job> jobs=jobService.getJobByDid(did);
        int totalRows=payService.getPayByDidJid(did,jid,pdate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays = payService.queryCurrentPagePayByDidJid(did,jid,pdate,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("did",did);
        request.setAttribute("jobs",jobs);
        request.setAttribute("jid",jid);
        request.setAttribute("pdate",pdate);
        request.setAttribute("pays",pays);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "pay";
    }
    @RequestMapping("/payCalculation")//工资结算
    public void payCalculation(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(calendar.DAY_OF_MONTH);
        if (day!=1){
            response.getWriter().print("每月1号才可以结算上个月工资");
            return;
        }
        int count = payService.getCountMonthPay();
        if (count!=0){
            response.getWriter().print("该月已经结算上个月工资");
            return;
        }
        List<Staff> staffs = staffService.getStaffBySstate(0);//结算试用期工资
        for (Staff staff:staffs) {
            double pbase = 0.0;//试用期8折
            double pperformance = staff.getJob().getJsalary()*0.3;//绩效工资*0.3
            double povertime = 0.0;//加班费
            double overtime = 0.0;//加班费
            double prap = 0.0;//奖惩
            double pss = staff.getJob().getJsalary()*(-0.25);//社保扣0.25
            double ppay = 0.0;//
            int count1 = attendanceService.getCountLastMonthBySid(staff.getSid());//正常上班1，加班2，早退3，迟到4 ，迟到加班5，迟到早退 6都算正常上班天数
            if(count1<22){
                pbase=(staff.getJob().getJsalary()*0.8)/22*count1;//按实际按天数算工资
            }else if (count1==22){
                pbase=staff.getJob().getJsalary()*0.8;//工资8折
            }else{
                pbase=staff.getJob().getJsalary()*0.8;//工资8折
                overtime=8*60*(count1-22);//多出上班天数算加班每天8小时
            }
            List<Attendance> attendances = attendanceService.getAttendanceLastMonthBySid(staff.getSid());//获取上个月加班的考勤 加班2，迟到加班5，旷工加班8
            for (Attendance attendance:attendances) {
                double offMinutes = attendanceService.getOffMinutesByAid(attendance.getAid());//每一条加班记录的加班时间
                if (offMinutes>0){
                    overtime+=offMinutes;//加上每一条加班记录的加班时间
                }
            }
            povertime=overtime/60*50;//加班费每小时50
            List<Rap> raps = rapService.getRapLastMonthBySid(staff.getSid());
            for (Rap rap:raps) {
                prap+=rap.getRamoney();//加上每一条奖惩记录
            }
            ppay=pbase+pperformance+povertime+prap+pss;
            Pay pay = new Pay(staff,pbase,pperformance,povertime,prap,pss,ppay,0);
            payService.addPay(pay);
        }
        List<Staff> staffs1 = staffService.getStaffBySstate(1);//结算正式员工工资
        for (Staff staff:staffs1) {
            double pbase = 0.0;//
            double pperformance = staff.getJob().getJsalary()*0.3;//绩效工资*0.3
            double povertime = 0.0;//加班费
            double overtime = 0.0;//加班时间
            double prap = 0.0;//奖惩
            double pss = staff.getJob().getJsalary()*(-0.25);//社保扣0.25
            double ppay = 0.0;//
            int count1 = attendanceService.getCountLastMonthBySid(staff.getSid());//正常上班1，加班2，早退3，迟到4 ，迟到加班5，迟到早退 6都算正常上班天数
            if(count1<22){
                pbase=staff.getJob().getJsalary()/22*count1;//按实际按天数算工资
            }else if (count1==22){
                pbase=staff.getJob().getJsalary();//工资8折
            }else{
                pbase=staff.getJob().getJsalary();//工资8折
                overtime=8*60*(count1-22);//多出上班天数算加班每天8小时
            }
            List<Attendance> attendances = attendanceService.getAttendanceLastMonthBySid(staff.getSid());//获取上个月加班的考勤 加班2，迟到加班5，旷工加班8
            for (Attendance attendance:attendances) {
                double offMinutes = attendanceService.getOffMinutesByAid(attendance.getAid());//每一条加班记录的加班时间
                if (offMinutes>0){
                    overtime+=offMinutes;//加上每一条加班记录的加班时间
                }
            }
            povertime=overtime/60*50;//加班费每小时50
            List<Rap> raps = rapService.getRapLastMonthBySid(staff.getSid());
            for (Rap rap:raps) {
                prap+=rap.getRamoney();//加上每一条奖惩记录
            }
            ppay=pbase+pperformance+povertime+prap+pss;
            Pay pay = new Pay(staff,pbase,pperformance,povertime,prap,pss,ppay,0);
            payService.addPay(pay);
        }
        response.getWriter().print("结算上月薪资成功");
    }
    @RequestMapping("/right")
    public void right(int pid,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        payService.updatePayPstate(pid,1);
        response.getWriter().print("薪资复议无误");
    }
    @RequestMapping("/dispose")
    public void dispose(int pid,int sid,double ramoney,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        payService.updatePayPstate(pid,1);
        Rap rap = new Rap(ramoney,new Staff(sid),"薪资复议结果");
        rapService.addRap(rap);
        response.getWriter().print("薪资复议处理完毕");
    }
    @RequestMapping("/checkDname")
    public void checkDname(String dname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count = departmentService.getCountByDname(dname);
        if (count!=0){
            response.getWriter().print("重名");
        }
    }
    @RequestMapping("/checkJname")
    public void checkJname(String jname,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count = jobService.getCountByJname(jname);
        if (count!=0){
            response.getWriter().print("重名");
        }
    }
    @RequestMapping("/staffPay")
    public String staffPay(@DateTimeFormat(pattern="yyyy-MM-dd")Date pdate,int sid,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        if (pdate==null){
            pdate=new Date();
        }
        int pageSize = 10;
        int totalRows=payService.getCountBySid(sid,pdate);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays = payService.queryCountBySid(sid,pdate,begin,end);
        request.setAttribute("pays",pays);
        request.setAttribute("sid",sid);
        request.setAttribute("pdate",pdate);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staffPay";
    }
}


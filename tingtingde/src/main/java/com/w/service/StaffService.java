package com.w.service;


import com.w.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface StaffService {

    int getStaffByDidJidState(@Param("did") int did, @Param("jid") int jid, @Param("sstate") int sstate);

    List<Staff> queryCurrentPageStaffByDidJidState(int did, int jid, int sstate, int begin, int end);

    List<Staff> getStaffsByDidJidState(@Param("did") int did, @Param("jid") int jid, @Param("sstate") int sstate);

    int addStaff(Staff staff);

    int updateStaff(Staff staff);
    int countStaffByDid(int did);

    int countStaffByJid(int jid);

    Staff getStaffBySid(int sid);

    double getMonthsBySid(int sid);

    int addCultivate(int sid,int cid);

    List<Staff> getStaff();

    List<Staff> getStaffBySstate(int sstate);

    List<Staff> getStaffByDid(int did);

    int deleteCultivate(int cid);

    Staff getStaffByNamePass(Staff staff);
}

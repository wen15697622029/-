package com.w.service.impl;

import com.w.dao.StaffMapper;
import com.w.model.Staff;
import com.w.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public int getStaffByDidJidState(int did, int jid, int sstate) {
        return staffMapper.getStaffByDidJidState(did,jid,sstate);
    }

    @Override
    public List<Staff> queryCurrentPageStaffByDidJidState(int did, int jid, int sstate, int begin, int end) {
        return staffMapper.queryCurrentPageStaffByDidJidState(did,jid,sstate,begin,end);
    }

    @Override
    public List<Staff> getStaffsByDidJidState(int did, int jid, int sstate) {
        return staffMapper.getStaffsByDidJidState(did,jid,sstate);
    }

    @Override
    public int addStaff(Staff staff) {
        return staffMapper.addStaff(staff);
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateStaff(staff);
    }

    @Override
    public int countStaffByDid(int did) {
        return staffMapper.countStaffByDid( did );
    }

    @Override
    public int countStaffByJid(int jid) {
        return staffMapper.countStaffByDid( jid );
    }

    @Override
    public Staff getStaffBySid(int sid) {
        return staffMapper.getStaffBySid( sid );
    }

    @Override
    public double getMonthsBySid(int sid) {
        return staffMapper.getMonthsBySid( sid );
    }

    @Override
    public int addCultivate(int sid, int cid) {
        return staffMapper.addCultivate( sid, cid );
    }

    @Override
    public List<Staff> getStaff() {
        return staffMapper.getStaff();
    }

    @Override
    public List<Staff> getStaffBySstate(int sstate) {
        return staffMapper.getStaffBySstate( sstate );
    }

    @Override
    public List<Staff> getStaffByDid(int did) {
        return staffMapper.getStaffByDid( did );
    }

    @Override
    public int deleteCultivate(int cid) {
        return staffMapper.deleteCultivate( cid );
    }

    @Override
    public Staff getStaffByNamePass(Staff staff) {
        return staffMapper.getStaffByNamePass( staff );
    }
}

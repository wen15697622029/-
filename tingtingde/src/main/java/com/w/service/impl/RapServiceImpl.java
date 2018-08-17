package com.w.service.impl;

import com.w.dao.RapMapper;
import com.w.model.Rap;
import com.w.service.RapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class RapServiceImpl implements RapService{
    @Resource
    private RapMapper rapMapper;

    @Override
    public int addRap(Rap rap) {
        return rapMapper.addRap( rap );
    }

    @Override
    public int getCountMonthBySid(int sid, Date radate) {
        return rapMapper.getCountMonthBySid( sid, radate );
    }

    @Override
    public List<Rap> queryCountMonthBySid(int sid, Date radate, int begin, int end) {
        return rapMapper.queryCountMonthBySid( sid, radate, begin, end );
    }

    @Override
    public int getCountDayByDidJid(int did, int jid, Date radate) {
        return rapMapper.getCountDayByDidJid( did, jid, radate );
    }

    @Override
    public List<Rap> queryCurrentPageStaffDayByDidJid(int did, int jid, Date radate, int begin, int end) {
        return rapMapper.queryCurrentPageStaffDayByDidJid( did, jid, radate, begin, end );
    }

    @Override
    public List<Rap> getRapLastMonthBySid(int sid) {
        return rapMapper.getRapLastMonthBySid( sid );
    }


}

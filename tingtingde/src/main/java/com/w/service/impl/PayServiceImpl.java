package com.w.service.impl;

import com.w.dao.PayMapper;
import com.w.model.Pay;
import com.w.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class PayServiceImpl implements PayService{
    @Resource
    private PayMapper payMapper;

    @Override
    public int getCountMonthPay() {
        return payMapper.getCountMonthPay();
    }

    @Override
    public int getPayByDidJid(int did, int jid, Date pdate) {
        return payMapper.getPayByDidJid( did, jid, pdate );
    }

    @Override
    public List<Pay> queryCurrentPagePayByDidJid(int did, int jid, Date pdate, int begin, int end) {
        return payMapper.queryCurrentPagePayByDidJid( did, jid, pdate, begin, end );
    }

    @Override
    public int addPay(Pay pay) {
        return payMapper.addPay( pay );
    }

    @Override
    public int getCountBySid(int sid, Date pdate) {
        return payMapper.getCountBySid( sid, pdate );
    }

    @Override
    public List<Pay> queryCountBySid(int sid, Date pdate, int begin, int end) {
        return payMapper.queryCountBySid( sid, pdate, begin, end );
    }

    @Override
    public int updatePayPstate(int pid, int pstate) {
        return payMapper.updatePayPstate( pid, pstate );
    }
}

package com.w.dao;


import com.w.model.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface PayMapper {
    int getCountMonthPay();

    int getPayByDidJid(@Param("did")int did, @Param("jid")int jid, @Param("pdate")Date pdate);

    List<Pay> queryCurrentPagePayByDidJid(@Param("did")int did, @Param("jid") int jid, @Param("pdate")Date pdate, @Param("begin") int begin, @Param("end") int end);

    int addPay(Pay pay);

    int getCountBySid(@Param("sid")int sid,@Param("pdate")Date pdate);

    List<Pay> queryCountBySid(@Param("sid")int sid,@Param("pdate")Date pdate,@Param("begin") int begin, @Param("end")int end);

    int updatePayPstate(int pid, int pstate);
}

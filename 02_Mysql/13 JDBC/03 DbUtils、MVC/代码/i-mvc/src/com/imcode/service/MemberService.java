package com.imcode.service;

import com.imcode.util.DBUtil;

public class MemberService {


    /**
     * 用户注册
     * @param mobile
     * @param password
     */
    public void regirster(String mobile, String password) {
        String sql = "insert into i_member(id,mobile,password) values(SEQ_MEMBER_ID.nextval,?,?)";
        DBUtil.update(sql, mobile, password);
    }




    
}

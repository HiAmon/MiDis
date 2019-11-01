package com.amon.wfx.selfmedia.member.service.impl;

import com.amon.wfx.selfmedia.member.dao.MemberDAO;
import com.amon.wfx.selfmedia.member.pojos.Member;
import com.amon.wfx.selfmedia.member.service.IMemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MemberService implements IMemberService {

    @Autowired
    MemberDAO memberDAO;

    public void checkLogin(String data) throws Exception{

        String[] arr = data.split("&");
        String user_ck = arr[0].split("=")[1];
        String ismobile = arr[1].split("=")[1];
        String user_type = arr[2].split("=")[1];
        String username = arr[3].split("=")[1];
        String password = arr[4].split("=")[1];
        String captcha = arr[5].split("=")[1];
        String remember = arr[6].split("=")[1];

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

    }

    public Member register(Member member) throws Exception{

        String memberId = String.valueOf(Math.random()).substring(2,12);
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        member.setMemberId(memberId);
        member.setRegisterTime(createTime);
        //密码MD5加密
        member.setPassword(new SimpleHash("MD5",member.getPassword()).toHex());

        memberDAO.addMember(member);
        return member;
    }




}

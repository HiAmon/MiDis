package com.amon.wfx.selfmedia.member.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDAOTest {
    @Autowired
    MemberDAO memberDAO;

    @Test
    public void queryMemberByAccount() {

        System.out.println(memberDAO.queryMemberByAccount("lucky520"));
    }


    @Test
    public void testq() {

        System.out.println(String.valueOf(Math.random()).substring(2,12));
    }




}

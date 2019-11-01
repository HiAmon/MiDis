package com.amon.wfx.selfmedia.member.dao;

import com.amon.wfx.selfmedia.member.pojos.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {

    Member queryMemberByAccount(String account);

    void addMember(Member member);
}

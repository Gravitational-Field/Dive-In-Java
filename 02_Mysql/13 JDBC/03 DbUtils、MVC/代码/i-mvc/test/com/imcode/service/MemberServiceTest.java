package com.imcode.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    public void regirster() {
        memberService.regirster("1388", "123333");
    }
}
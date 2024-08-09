package com.ll.mb.global.initData;

import com.ll.mb.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private final MemberService memberService;
    
    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work1();
        };
    }
    
    @Transactional
    public void work1() {
        if (memberService.findByUsername("admin").isPresent()) return;
        
        memberService.join("admin","1234");
        memberService.join("user1","1234");
        memberService.join("user2","1234");
    }
}

package com.study.pr10memberadminapi.repository;

import com.study.pr10memberadminapi.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class MemberRepository {
    public static List<Member> memberList = new ArrayList<>();
}

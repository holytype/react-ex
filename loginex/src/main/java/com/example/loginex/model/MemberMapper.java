package com.example.loginex.model;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<Member> selectAll();

    Optional<Member> findByEmail(String email);

    Member save(Member member);

}
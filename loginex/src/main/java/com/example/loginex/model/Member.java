package com.example.loginex.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Member {
    String name;
    String email;
    String profile;
    String memberKey;
    String role;
}

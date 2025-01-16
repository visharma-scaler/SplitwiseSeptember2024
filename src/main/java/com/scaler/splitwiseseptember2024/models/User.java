package com.scaler.splitwiseseptember2024.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String password;
}

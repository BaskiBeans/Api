package com.example.Api.DTO;

import java.util.List;

import com.example.Api.Model.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResDTO{

    public String username;

    public String phone;

    public String country;

    public List <UserModel> userList;

}
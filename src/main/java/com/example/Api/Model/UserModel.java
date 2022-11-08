package com.example.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

	public int id;
	
    public String username;

    public String phone;

    public String country;
    
}

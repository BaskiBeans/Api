package com.example.Api.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Api.DAO.Mapper.UserMapper;
import com.example.Api.DTO.UserReqDTO;
import com.example.Api.Model.UserModel;

@Repository
public class UserDAO {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<UserModel> getUserList(UserReqDTO userReqDTO){
		return userMapper.getUserList(userReqDTO);
		
	}
	
	public int updateUser(UserReqDTO userReqDTO) {
		return userMapper.updateUser(userReqDTO);
	}
	
	public int insertUser(UserReqDTO userReqDTO) {
	    return userMapper.insertUser(userReqDTO);
	           
	}
	

}

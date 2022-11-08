package com.example.Api.DAO.Mapper;

import com.example.Api.DAO.SQL.UserProvider;
import com.example.Api.DTO.UserReqDTO;
import com.example.Api.Model.UserModel;
import org.apache.ibatis.annotations.*;


import com.example.Api.DTO.UserResDTO;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {

    @SelectProvider(type= UserProvider.class, method = "getUser")
    @Results({

        @Result(column="id", property = "id", jdbcType = JdbcType.BIGINT),
        @Result(column="username", property = "username", jdbcType = JdbcType.VARCHAR),
        @Result(column="phone", property = "phone", jdbcType = JdbcType.VARCHAR),
        @Result(column="country", property = "country", jdbcType = JdbcType.VARCHAR),
    })
    List<UserModel> getUserList(UserReqDTO userReqDTO);

    @UpdateProvider(type=UserProvider.class, method = "updateUser")
    Integer updateUser(UserReqDTO userReqDTO);

    @InsertProvider(type=UserProvider.class, method = "insertUser")
    Integer insertUser(UserReqDTO userReqDTO);




    //UserResDTO gResDTO

}

/*
 * 	@SelectProvider(type=LookupProvider.class, method="getComponent")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="full_component_name", property="fullComponentName", jdbcType=JdbcType.VARCHAR),
    })
	LookupResDTO getComponent(LookupReqDTO lookupReqDTO);
 */
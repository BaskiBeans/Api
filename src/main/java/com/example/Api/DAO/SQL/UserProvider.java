package com.example.Api.DAO.SQL;

import org.apache.ibatis.jdbc.SQL;

import com.example.Api.DTO.UserReqDTO;

public class UserProvider {
    
    public String getUser(UserReqDTO userReqDTO){
        return new SQL() {
            {
                SELECT("username, phone, country");
				FROM("user");

                WHERE("id = #{id}");

            }
        }.toString();
    }
    
    public String updateUser(UserReqDTO userReqDTO) {
    	return new SQL() {
         {  UPDATE("user");
    		
    		SET("username = #{username}");
    		SET("phone = #{phone}");
    		SET("country = #{country}");
    		
    		WHERE("id = #{id}");
    	}
      }.toString();
    }
    
    public String insertUser(UserReqDTO userReqDTO) {
        return new SQL() {
            {
            INSERT_INTO("user");
            VALUES("username","#{username}");
            VALUES("phone","#{phone}");
            VALUES("country","#{country}");
         
            }
        }.toString();
        
    }
}


/*
 * public String getComponent(LookupReqDTO lookupReqDTO) {
		return new SQL() {
			{
				SELECT("id, code, name, full_component_name");
				FROM("app_monitoring_component_lookup");
				
				WHERE("record_status = "+ DbValueConst.RECORD_STATUS_PENDING_STR);

				if (lookupReqDTO.getId() != null) {
					AND();
					WHERE("id = #{id}");
				}
				if (StringUtils.isNotBlank(lookupReqDTO.getCode())) {
					AND();
					WHERE("code = #{code}");
				}
				if (StringUtils.isNotBlank(lookupReqDTO.getName())) {
					AND();
					WHERE("name = #{name}");
				}
			}
		}.toString();
	}
	
 */

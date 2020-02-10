package com.sicc.stream.mapper;

import org.springframework.stereotype.Repository;
import com.sicc.stream.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Repository
@Mapper
public interface UserMapper {

	public int insertUser(UserVO userVO);
	public int deleteUser(String UserId);
	public UserVO selectUser(String UserId);
}

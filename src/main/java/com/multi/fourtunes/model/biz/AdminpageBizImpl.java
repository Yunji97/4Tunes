package com.multi.fourtunes.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.fourtunes.model.dao.UserDao;
import com.multi.fourtunes.model.dto.UserDto;

@Service
public class AdminpageBizImpl implements AdminpageBiz{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserDto> selectList() {
		return userDao.selectList();
	}

	@Override
	public String selectGrade(int user_no) {
		return userDao.selectGrade(user_no);
	}

	@Override
	public int updateGradePaid(int user_no) {
		return userDao.updateGradePaid(user_no);
	}

	@Override
	public int updateGradeFree(int user_no) {
		return userDao.updateGradeFree(user_no);
	}

	@Override
	public int deleteUser(int user_no) {
		return userDao.deleteUser(user_no);
	}

	@Override
	public List<UserDto> searchUser(String name) {
		return userDao.searchUser(name);
	}

}
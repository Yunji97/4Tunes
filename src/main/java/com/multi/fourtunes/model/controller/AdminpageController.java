package com.multi.fourtunes.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.fourtunes.model.biz.AdminpageBiz;
import com.multi.fourtunes.model.dto.UserDto;

@Controller
@RequestMapping("/adminpage")
public class AdminpageController {
	
		@Autowired
		private AdminpageBiz adminpageBiz;
		
		// 회원정보 조회로 이동
		@GetMapping("/user")
		public String gotoAdminpageUser(Model model) {
			List<UserDto> userList = adminpageBiz.selectList();
			model.addAttribute("userList", userList);
			
			return "adminpage_user";
		}
	
		@GetMapping("/update/{user_no}")
		public String updateUserGrade(@PathVariable int user_no) {
			// 해당 회원의 등급을 조회함
			String grade = adminpageBiz.selectGrade(user_no);
			
			if(grade.equals("FREE")) {  // 조회한 회원등급이 free이면 paid로 변경
				adminpageBiz.updateGradePaid(user_no);
			} else {  // 조회한 회원등급이 paid이면 free로 변경
				adminpageBiz.updateGradeFree(user_no);
			}
			
			return "redirect:/adminpage/user";
		}
		
		@GetMapping("/delete/{user_no}")
		public String deleteUser(@PathVariable int user_no) {
			adminpageBiz.deleteUser(user_no);
			
			return "redirect:/adminpage/user";
		}
		
		@GetMapping("/search")
		public String searchUser(@RequestParam("username") String name, Model model) {
			List<UserDto> userList = adminpageBiz.searchUser(name);
			//System.out.println("userList: " + userList);
			model.addAttribute("searchUserList", userList);
			
			return "adminpage_searchuser";
		}
		
		// 게시글 관리로 이동
		@GetMapping("/community")
		public String gotoAdminpageCommunity() {
			return "adminpage_community";
		}
		
		// 댓글 관리로 이동
		@GetMapping("/comment")
		public String gotoAdminpageComment() {
			return "adminpage_comment";
		}

}
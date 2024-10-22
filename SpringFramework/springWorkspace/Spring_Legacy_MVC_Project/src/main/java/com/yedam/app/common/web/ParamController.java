package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.common.service.UserVO;

@Controller
public class ParamController {
	// Content-type : application/x-www-form-urlencoded
	// QueryString(질의문자열) : key=value&key=value ...
	// Method : 상관없음
	// => GET(검색, 단건조회), <form/>
	// QueryString => 커맨드 객체 ( 어노테이션 X, 객체 )
	@RequestMapping(path = "comobj", 
				method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(UserVO userVO) {
		String result = "";
		result += "Path : /comboj \n";
		result += "\t user_id : " + userVO.getUserId();
		result += "\t user_name : " + userVO.getUserName();
		result += "\t comments : " + userVO.getComments();
		result += "\t joinDate : " + userVO.getJoinDate();
		return result;
	}
	
	
	// QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path = "reqparm", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(String userName, @RequestParam String userId, @RequestParam(name = "msg", defaultValue="No Comments", required = true) String comments) {
		String result = "";
		result += "Path : /reqparm \n";
		result += "\t user_id : " + userId;
		result += "\t user_name : " + userName;
		result += "\t comments : " + comments;
		return result;
	}
	
	// JSON
	// Content-type : application/json
	// JSON (Javascript Object Notation) : 객체 or 배열
	//				{ "name" : "value", "name" : "value", ...}
	//				[ {}, {}, {}, ...]
	// Method : POST, PUT
	// => AJAX
	@PostMapping("resbody")
	@ResponseBody
	public String requetsBody(@RequestBody UserVO userVO) {
		String result = "";
		result += "Path : /comboj \n";
		result += "\t user_id : " + userVO.getUserId();
		result += "\t user_name : " + userVO.getUserName();
		result += "\t comments : " + userVO.getComments();
		return result;
	}
	
	@PostMapping("jsonList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<UserVO> userList) {
		String result = "";
		result += "Path : /jsonList \n";
		for (UserVO userVO : userList) {
			result += "\t user_id : " + userVO.getUserId();
			result += "\t user_name : " + userVO.getUserName();
			result += "\t comments : " + userVO.getComments();			
		}
		return result;
	}
	
	// Content-type과 상관없음
	// Method도 상관없음
	// 단, 단일값 처리 가능
	// => 다른 Content-type에 추가적인 값이 필요한 경우
	@RequestMapping("path/{id}") // path/Hong, path/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " + id;
		return result;
	}
}

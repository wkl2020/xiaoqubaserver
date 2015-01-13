package com.jun.xiaoquren.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.jun.xiaoquren.model.ParkingStallInfo;

@Component("parkingStallInfoValidation")
public class ParkingStallInfoValidation {
	
	public boolean supports(Class<?> klass) {
		return ParkingStallInfo.class.isAssignableFrom(klass);
	}
	
	public void validate(Object target, Errors errors) {
		ParkingStallInfo registration = (ParkingStallInfo) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"NotEmpty.registration.title",
				"标题不能为空.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content",
				"NotEmpty.registration.content",
				"内容不能为空.");
		
		String title = registration.getTitle();
		if ((title.length()) > 200) {
			errors.rejectValue("title",
				"lengthOfTitle.registration.title",
				"标题不能多于200个字符.");
		}
		
		String content = registration.getContent();
		if ((content.length()) < 10) {
			errors.rejectValue("content",
				"lengthOfContent.registration.content",
				"标题不能少于10个字符.");
		}
	}

}

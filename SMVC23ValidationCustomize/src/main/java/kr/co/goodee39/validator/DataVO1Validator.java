package kr.co.goodee39.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.goodee39.vo.DataVO1;

public class DataVO1Validator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DataVO1.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//  rejectIfEmpty = 값이 없으면 발동
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		
		
		DataVO1 vo1 = (DataVO1)target;
		// vo를 받아 실질적으로 각각의 조건을 커스터마이징
		String data2 = vo1.getData2();
		String data3 = vo1.getData3();
		
		if(data2.length() > 10) {
			errors.rejectValue("data2", "error4");
		}
		
		if(data3.contains("@") == false) {
			errors.rejectValue("data3", "error5");
		}
	}

}

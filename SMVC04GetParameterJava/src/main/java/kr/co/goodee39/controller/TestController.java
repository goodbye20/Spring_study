package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3[] = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for(String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
				
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3[] = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for(String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
	}
	
	// webRequest
	// Spring에서 지원하는 request type
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3[] = request.getParameterValues("data3");
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for(String string : data3) {
			System.out.println("data3 : "+string);
		}
		
		return "result";
	}
	
	// @pathVariable
	// 우리가 서버로 넘긴 경로로 파타미터를 받을 수 있고록 도와주는 어노테이션
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1,
						@PathVariable int data2,
						@PathVariable int data3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data2 : "+data3);
		
		int add = data1 + data2 + data3;
		System.out.println("add : "+add);
		
		return "result";
	}
	
	// @RequestParam : request.getParameter로 받은 데이터를 변수화 하여 인자로 받을 수 있도록 하는 어노테이이션
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int[] data3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for(int i : data3) {
			System.out.println("data3 : "+i);
		}
		
		return "result";
	}
	
	// 보내는 데이터명과 받고자하는 데이터명과 이름이 다를 경우
	// RequestParam 의 value 속성으로 변수를 일치시킬수 있다. 
	@GetMapping("/test6")
	public String test6(@RequestParam (value = "data1") int data1,
						@RequestParam (value = "data2") int data2,
						@RequestParam (value = "data3") int[] value3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		
		for(int i : value3) {
			System.out.println("data3 : "+i);
		}
		
		return "result";
	}
	
	// required = false : 굳이 해당 데이터가 필요하지 않을 경우 null값으로 형을 잡아준다.
	// DefaultValue = 해당 값의 default를 지정한다. 데이터가 오지 않았을 경우 해당
	//       			Default값으로 데이터를 전송받는다.
	@GetMapping("/test7")
	public String test7(@RequestParam  int data1,
						@RequestParam (required = false) String data2,
						@RequestParam (defaultValue = "0")  int data3) {
		
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data2 : "+data3);
		
		
		
		return "result";
	}
	
}
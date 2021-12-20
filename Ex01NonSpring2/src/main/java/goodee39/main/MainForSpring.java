package main.java.goodee39.main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.goodee39.module.ChangePasswordService;
import main.java.goodee39.module.Member;
import main.java.goodee39.module.MemberDao;
import main.java.goodee39.module.MemberRegisterService;
import main.java.goodee39.module.RegisterRequest;

public class MainForSpring {

	private static ClassPathXmlApplicationContext ctx = null;
		
	public static void main(String[] args) {
		
		ctx = new ClassPathXmlApplicationContext("main/java/goodee39/main/beans.xml");
	
		// 싱글톤 확인(객체 예시 생성 후 확인)
		// 결국 같은 객체다
//		MemberDao dao1 =
//				ctx.getBean("memberDao", MemberDao.class);
//		MemberDao dao2 =
//				ctx.getBean("memberDao", MemberDao.class);
//		System.out.println(dao1==dao2);
		
		
//		Member mem1 = ctx.getBean("member", Member.class);
//		mem1.setEmail("aaa@bbb.com");
//		Member mem2 = ctx.getBean("member", Member.class);
//		System.out.println(mem2.getEmail());
		
		
		Scanner scan = new Scanner(System.in);
	      while(true) {
	         System.out.println("명령어를 입력하세요");
	         String command = scan.nextLine();
	         if(command.equalsIgnoreCase("exit")) {
	            System.out.println("종료합니다");
	            return;
	         }else if(command.startsWith("new")){
	        	 // split => 문자열을 쪼개줌
	            processNewCommand(command.split(" "));
	            continue;
	         }else if(command.startsWith("change")) {
	            processChangeCommand(command.split(" "));
	            continue;
	         }
	         printHelp();
	      }
	   }


		//알람 출력
		private static void printHelp() {
		   System.out.println();
		   System.out.println("잘못된 명령입니다 다시 명령어를 입력하세요.");
		   System.out.println();
		   System.out.println();
		   System.out.println();
		}
		
		// 패스워드 변경시 실행되는 메서드
		/*
		 * 반드시 4개의 데이터가 존재해야 한다.
		 * -형식 change [email] [oldpassword] [newpassword]
		 * */
		private static void processChangeCommand(String[] arg) {
		   if(arg.length != 4) {
		      printHelp();
		      return;
		   }
//		   ChangePasswordService cps = assembler.getPwdSvc();
		   ChangePasswordService cps =
				   ctx.getBean("changePwdSrc", ChangePasswordService.class);
				   
		   cps.changePassword(arg[1], arg[2], arg[3]);
		   System.out.println("암호를 변경했습니다.");
		}
		
			// 회원 등록 시 실행되는 메서드
			/*
		 * 반드시 5개의 데이터가 존재해야 한다.
		 * -형식 new [email] [name] [password] [confirmpassword]
		 * */
		private static void processNewCommand(String[] arg) {
		   if(arg.length != 5) {
		      printHelp();
		      return;
		   }
		   
//		   MemberRegisterService regSvc = assembler.getRegSvc();
		   MemberRegisterService regSvc =
				   ctx.getBean("changeRsgSrc", MemberRegisterService.class);
		   
		   RegisterRequest req = new RegisterRequest();
		   req.setEmail(arg[1]);
		   req.setName(arg[2]);
		   req.setPassword(arg[3]);
		   req.setConfirmpassword(arg[4]);
		   if(!req.isPasswordEqualToConfirmPassword()) {
		      System.out.println("암호가 일치하지 않습니다");
		      return;
		   }else {
		      regSvc.regist(req);
		      System.out.println("등록되었습니다.");
		   }
		   
		}
		
		}
		
		

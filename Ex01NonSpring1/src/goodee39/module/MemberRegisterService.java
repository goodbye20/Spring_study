package goodee39.module;

import java.util.Date;

// 비지니스 로직 : 멤버를 입력해주는 로직
/*
 * - MVC패턴중 service에 해당
 * - 받은 멤버를 DB에 등록해주는 역할
 * */
public class MemberRegisterService {
	private MemberDao memberDAO;
	public MemberRegisterService() {
		// TODO Auto-generated constructor stub
	}
	public MemberRegisterService(MemberDao memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDAO.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("이미 맴버가 존재합니다");
		}else {
			Member newMember = new Member(
					req.getEmail(),
					req.getPassword(),
					req.getName(),
					new Date());
			memberDAO.insert(newMember);
		}
		
	}
}

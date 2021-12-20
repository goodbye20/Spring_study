package goodee39.module;

// 비지니스 로직 : 패스워드를 갱신하는 로직
/*
 * - (구)패스워드를 새 패스워드로 교체할 때 사용하는 로직
 * */

public class ChangePasswordService {
	private MemberDao memberDAO;

	public ChangePasswordService(MemberDao memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDAO.selectByEmail(email);
		
		if(member == null) {
			System.out.println("해당되는 멤버가 존재하지 않습니다");
		}else {
			member.changePassword(oldPassword, newPassword);
			memberDAO.update(member);
		}
	}
}


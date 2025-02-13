package jdbcboard.test;

import jdbcboard.service.MemberService;
import jdbcboard.service.impl.MemberServiecImpl;

public class MemberServiceTest {

	public static void main(String[] args) {

		MemberService memberService = new MemberServiecImpl();

//		Member member = new Member("hong2", "홍길동2", "홍장군", "1234", "hong@hong.com", "010-1234-5678", "N");
//
//		int result = memberService.insertMember(member);
//		if(result > 0) {
//			System.out.println("입력성공!");
//		}
		
//		memberService.updateMember(new Member("hong", "new홍길동","new홍장군", "5678", "newhong@hong.com", "010-1111-2222", "N"));
		
//		memberService.deleteMember("hong2");
		
		System.out.println(memberService.selectMember());
		System.out.println(memberService.getMember("hong"));
		
	} // main

} // class

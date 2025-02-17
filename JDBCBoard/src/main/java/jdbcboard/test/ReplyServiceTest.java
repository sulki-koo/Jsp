package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;
import jdbcboard.service.impl.ReplyServiceImpl;

public class ReplyServiceTest {

	public static void main(String[] args) {

		ReplyService replyService = ReplyServiceImpl.getReplyServiceImpl();

		// insert
//		Reply reply = new Reply(0, "댓글1", null, "N", "hong3", 7);
//		int result = replyService.insertReplyr(reply);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}

		// update
//		Reply reply = new Reply(2, "new댓글1", null, "N", "hong", 4);
//		int result = replyService.updateReply(reply);
//		if(result > 0) {
//			System.out.println("수정성공");
//		}

		// delete
//		int result = replyService.deleteReply(3);
//		if (result > 0) {
//			System.out.println("삭제성공");
//		}

		// select
		List<Reply> replyList = replyService.selectReply();
		for (Reply reply1 : replyList) {
			System.out.println(reply1);
		}

		// get
//		Reply reply = replyService.getReply(5);
//		System.out.println(reply);

	}

}

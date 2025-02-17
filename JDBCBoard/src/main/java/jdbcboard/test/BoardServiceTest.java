package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Board;
import jdbcboard.service.BoardService;
import jdbcboard.service.impl.BoardServiceImpl;

public class BoardServiceTest {

	public static void main(String[] args) {

		BoardService boardService = BoardServiceImpl.getBoardServiceImpl();

		// insert
//		Board board = new Board(0, "자유게시판", 0);
//		Board board = new Board(1, "놀이게시판", 0);
//		Board board = new Board(2, "보드게시판", 0);
//		Board board = new Board(3, "유머게시판", 0);
//		int result = boardService.insertBoard(board);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}

		// update
		Board board = new Board(23, "삐리링11", 0);
		int result = boardService.updateBoard(board);
		if(result > 0) {
			System.out.println("수정성공");
		}

		// delelte
//		int result = boardService.deleteBoard(2);
//		if (result > 0) {
//			System.out.println("삭제성공");
//		}

		// selete
		List<Board> boardList = boardService.selectBoard();
		for (Board board1 : boardList) {
			System.out.println(board1);
		}

		// get
//		Board baord = boardService.getBoard(1);
//		System.out.println(baord);

	}

}

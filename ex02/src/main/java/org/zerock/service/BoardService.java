package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService { // 비즈니스계층이라서 고객이랑 의사소통하는 용어를 사용해야 함
	
	Long register(BoardVO board);
	BoardVO get(Long bno);
	
	int modify(BoardVO board);
	
	int remove(Long bno);
	
	 List<BoardVO> getList();
	
}

package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> getList();
	
	void insert(BoardVO board);
	void insertSelectKey(BoardVO vo);
	
	//등록
	BoardVO read(Long bno);
	
	//수정과 삭제는 int 타입을 주로 사용
	//삭제
	int delete(Long bno);
	
	//수정
	int update(BoardVO board);
}

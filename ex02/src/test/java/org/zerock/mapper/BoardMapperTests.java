package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void testGetList() {
		log.info("---------------");
		boardMapper.getList();
	}

	@Test
	public void testInsert() {
		log.info("------testInsert-----");
		BoardVO vo = new BoardVO();
		vo.setTitle("제목테스트 ");
		vo.setContent("내용테스트 ");
		vo.setWriter("tester");

		boardMapper.insert(vo);
		log.info("---------------------------");
		log.info("after insert " + vo.getBno());
	}

	@Test
	public void testInsertSelectKey() {
		log.info("------testInsertSelectKey-----");
		BoardVO vo = new BoardVO();
		vo.setTitle("제목테스트 ");
		vo.setContent("내용테스트 ");
		vo.setWriter("tester");

		boardMapper.insertSelectKey(vo);
		log.info("after insert selectKey " + vo.getBno());
	}

	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(3L); // 3번데이터 가져오기
		log.info(vo);
	}

	@Test
	public void testDelete() {
		int count = boardMapper.delete(1L); // 1번데이터 삭제하기
		log.info("count:" + count);
	}

	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(7L);				//7번 데이터 수정하기
		vo.setTitle("Updated Title");
		vo.setContent("Update content");
		vo.setWriter("유저테스트  user00");
		log.info("count:" + boardMapper.update(vo));
	}
}

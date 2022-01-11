package org.zerock.service;

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
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	@Test
	public void testPrint() {
		
		log.info("서비스 테스트: " + service);
		// BoardServiceImpl(mapper=org.apache.ibatis.binding.MapperProxy@988246e)
	} 
	
	@Test
	public void testGetList() {
		service.getList().forEach(
				board-> log.info(board));
	}
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle(" 제목 테스트 ");
		vo.setContent(" 내용 테스트 ");
		vo.setWriter("tester");
		 
		Long bno = service.register(vo);
		log.info("bno 값은 ...: " + bno);
	}
}

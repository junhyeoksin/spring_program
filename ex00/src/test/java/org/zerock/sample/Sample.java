package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  //테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Sample {
	@Autowired
	private Restaurant restaurant;
	@Autowired   //context 에 있으면 주입
	private SampleHotel hotel;
	
	@Test
	public void testHotel() {
		log.info(hotel);
	}
 
	@Test
	public void test1() {   
		System.out.println("test1............");
		log.info("test1................");
		log.info(restaurant); //Restaurant(chef=Chef())
	}
}

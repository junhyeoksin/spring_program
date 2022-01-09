package org.zerock.mapper;
import org.apache.ibatis.annotations.Select;


//org.zerock.mapper.TimeMapper.getTime2
public interface TimeMapper {
	
	@Select("select sysdate from dual")  
	public String getTime();	//어노테이션을 사용하여 sql문 정의 
	 
	String getTime2();		//TimeMapper.xml 에 sql문 정의 
} 

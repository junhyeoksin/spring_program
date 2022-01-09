package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
 
@Component
@ToString
@RequiredArgsConstructor 
public class Restaurant {
	  
	//생성자 주입 : @AllArgsConstructor 주입 
	//setter 주입 : @Setter(onMethod_ = {@Autowired })
	//필드 주입 : @Autowired
	// final 필드 : 타입 final @RequiredArgsConstructor 
 
	private final  Chef chef;
}

package org.zerock.sample;

import org.springframework.stereotype.Component;

@Component
public class SampleHotel {
//필드주입
//생성자주입 
//final 주입
	//생성자주입  !
	private Chef chef;

	public SampleHotel(Chef chef) {
		super();
		this.chef = chef;
	}

	@Override
	public String toString() {
		return "SampleHotel [chef=" + chef + "]";
	}
	
}

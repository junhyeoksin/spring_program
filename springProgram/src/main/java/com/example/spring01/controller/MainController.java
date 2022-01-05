package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.PointDTO;

@Controller  //컨트롤러 bean으로 등록
public class MainController {
	// http://localhost//springProgram/
	@RequestMapping("/")  //  url과 method 등록 
	public String main(Model model) { 
		model.addAttribute("message", "메인 페이지 입니다. ");  //key, value
		return "main";
	}
	@RequestMapping("multi_table.do")
	public String gugu() {
		return "test/multi_table";  //view/test/multi_table.jsp
	}
	@RequestMapping("table_result.do")
	public String gugu_result
	(@RequestParam(defaultValue = "3")int num, Model model ) {
		String result ="";
		for(int i =1; i<9; i++) {
			result += num + "x" + i +  "=" + num * i +"<br>";
		}
		model.addAttribute("result", result);
		return "test/table_result";
	}
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	//@RequestMapping 개별변수
	//@ModelAttribute 객체
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMat());
		String avg = String.format("%.2f", dto.getTotal()/3.0);
		dto.setAverage(Double.parseDouble(avg));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
}
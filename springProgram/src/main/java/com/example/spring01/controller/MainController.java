package com.example.spring01.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.PointDTO;
import com.example.spring01.model.ProductDTO;

@Controller // 컨트롤러 bean으로 등록
public class MainController {
	// http://localhost//springProgram/
	@GetMapping("/") // url과 method 등록
	public String main(Model model) {
		model.addAttribute("message", "메인 페이지 입니다. "); // key, value
		return "main";
	}

	@GetMapping("multi_table.do")
	public String gugu() {
		return "test/multi_table"; // view/test/multi_table.jsp
	}

	@PostMapping("table_result.do")
	public String gugu_result(@RequestParam(defaultValue = "3") int num, Model model) {
		String result = "";
		for (int i = 1; i < 9; i++) {
			result += num + "x" + i + "=" + num * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/table_result";
	}

	@GetMapping("point.do")
	public String point() {
		return "test/point";
	}
	// @RequestMapping 개별변수
	// @ModelAttribute 객체

	@PostMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
		String avg = String.format("%.2f", dto.getTotal() / 3.0);
		dto.setAverage(Double.parseDouble(avg));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}

	@RequestMapping("move.do")
	public String move() throws Exception {
		// 주소창으로 url 을 보냄, url에 한글, 특수문자가 제한되 있다.
		String name = URLEncoder.encode("철수", "utf-8");
		// 3바이트 한글을 재조합함
		return "redirect:/result.do?name = " + name + "&age=20";
	}

	@RequestMapping("result.do")
	public String result(Model model, @RequestParam(defaultValue = "NoName") String name,
			@RequestParam(defaultValue = "10") int age) throws Exception {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println("name값확인:" + name + " " + "age값확인: " + age);
		return "test/result";
	}

	// ModelAndView
	// Model 데이터 저장소
	// view 출력페이지
	@RequestMapping("mav.do")
	public ModelAndView mav() {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", new ProductDTO("pen", 1000));
		// new ModelAndView (view, key, value)
		return new ModelAndView("test/mav_result", "map", map);
	}

	// ajax
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax"; // ajax.jap로 포워드

	}// ajax.jsp 로 포워드되서 background-> dto 데이터를 반환

	// @ResponseBody 데이터 자체를 리턴 => JSON 형식
	// {"name":"TV", "price" , 50000}
	@RequestMapping("background.do")
	public @ResponseBody ProductDTO background() {
		ProductDTO dto = new ProductDTO("TV", 500000);
		// DTO를 return 즉 데이터 자체를 리턴한다. @ResponseBody
		return dto;

	}
	//로그인 기능 
	@RequestMapping("login.do")
	public String login() {
		return "test/login";
	}

	@RequestMapping("login_result.do")
	public String login_result(String id, String pw, Model model) {
		String resultMsg= "";
		if(id.equals("kim")&&pw.equals("1234")){  //사용자가 입력한 아이디와 비밀번호 
			resultMsg = "환영합니다.";					
			
		}else {
			resultMsg ="아이디 또는 비밀번호가 틀렸습니다. ";
		}
		model.addAttribute("resultMsg", resultMsg);  //model 에저장
		return "test/login_result";					//출력 페이지에 전
	}
}

package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample/*")
@Log4j
@Controller
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic......");
	}
	
	@GetMapping("/basicGET")
	public void basicGet() {
		log.info("basic get......");
	}
	
	@GetMapping("/ex01")
	public void ex01(SampleDTO dto) {
		log.info(dto);
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids" + ids);
		return "ex02List";
		
	}
	@GetMapping("/ex02Bean")
	public String ex02Bean(@ModelAttribute("sample") SampleDTOList list, Model model) {
		log.info(list);
		model.addAttribute("result", "success"); 
		return "sample/ex02Bean";
	}
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload...");
	}
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("exUploadPost...데스트");
			
			log.info(file.getOriginalFilename());  //파일명
			log.info(file.getSize());				//데이터크기
			log.info(file.getContentType());		//타입
		});
	}
	
	
	
	
	
}

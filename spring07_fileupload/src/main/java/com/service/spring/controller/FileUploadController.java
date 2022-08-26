package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.model.UploadDataVO;

@Controller
public class FileUploadController {
	@RequestMapping("fileupload.do")
	public ModelAndView upload(UploadDataVO vo, HttpServletRequest request) throws Exception{
		
		// 1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 가장 먼저 받아온다.
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile..."+mFile);
		
		// 2. 업로드된 파일이 있다면...업로드된 파일 정보를 받아보자... (파일 이름, 용량)
		if(mFile.isEmpty()!=true) { // 업로드된 파일이 있다면...
			System.out.println("파일의 사이즈 "+mFile.getSize());
			System.out.println("업로드한 파일명 "+mFile.getOriginalFilename());
			System.out.println("getName()??? "+mFile.getName());
		}
		
		// 3. 업로드한 파일을 우리가 지정한 경로에 이동 (이떄 copy본을 보낼 것이다.)
		// 먼저 context path 경로를 받아와야 한다.
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root "+root);
		String path = root+"upload\\";
		
		// 4. 위에서 만든 path 안에 이동하고자 하는 파일을 생성
		File copyFile = new File(path+mFile.getOriginalFilename());
		
		// 5. 생성한 파일(copyFile)을 이동시킴...
		mFile.transferTo(copyFile); // 우리가 업로드한 파일의 copy본이 해당 경로에 저장된다...이동한다 TransferTo
		System.out.println("path "+path);
		
		return new ModelAndView("upload_result", "uploadFile", mFile.getOriginalFilename());
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) {
		System.out.println("filename "+filename);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"upload\\";
		
		// 다운로드 코드 추가...
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map); // BeanNameViewResolver에서 handling
	}
}
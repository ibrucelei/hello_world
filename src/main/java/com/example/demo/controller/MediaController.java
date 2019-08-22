package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.anno.EntityLog;
import com.example.demo.constant.OperateType;
import com.example.demo.domain.Media;
import com.example.demo.domain.User;
import com.example.demo.mapper.file.MediaMapper;
import com.example.demo.security.MyUserDetails;

@Controller
@RequestMapping("/media")
public class MediaController {
	@Autowired
	private MediaMapper mediaMapper;
	
	@RequestMapping("/get")
	@ResponseBody
	@EntityLog(desc = "查询全部media", entity = Media.class, operateType = OperateType.QUERY)
	public List<Media> getState() {
		List<Media> medias=mediaMapper.getAll();
		return medias;
	}
	/**
	 * remark:上次文件，需要定义path,type,
	 * type:file.doc/pdf/video/audio...
	 * @param media
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/add")
	public String add(Media media,MultipartFile file)  {
		String contentType=file.getContentType();
		System.out.println(contentType);
		String fileName=file.getOriginalFilename();
		String type=fileName.substring(fileName.lastIndexOf("."));
		media.setContentType("file"+type);
		//Calendar calendar=Calendar.getInstance();
		//calendar.setTime(new Date());
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String path="D:\\Java\\eclipse\\upload\\"+fileName.substring(0,fileName.lastIndexOf("."))+sdf.format(new Date())+type;
		File destFile=new File(path);
		if(!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		media.setPath(path);
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "404";
		} catch (IOException e) {
			e.printStackTrace();
			return "404";
		}finally{
			
		}
		int result=mediaMapper.insert(media);
		if(result==1)return "redirect:/media/toAdd";
		return "404";
	}
	
	@RequestMapping("/toAdd")
	public String index(Model model,HttpServletRequest request) {
		//String userId=request.getSession().getAttribute("userId").toString();
		SecurityContext ctx = SecurityContextHolder.getContext();
	    Authentication auth = ctx.getAuthentication();
	    MyUserDetails user = (MyUserDetails) auth.getPrincipal();
	    
		model.addAttribute("userId", user.getUser().getId());
		model.addAttribute("userName", user.getUsername());
		return "media.html";
	}
	@RequestMapping("/query")
	@ResponseBody
	public List<Media> query() {
		List<Media> medias=mediaMapper.getAll();
		return medias;
	}
}

package upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired
	@Qualifier("service3")
	UploadService service;
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "/upload/uploadForm";
	}
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String uploadResult(@ModelAttribute("vo") UploadVO vo) throws IllegalStateException, IOException {
		
		
		
		//전송 파일 2개 객체 생성
		MultipartFile multi1 = vo.getFile1();
		MultipartFile multi2 = vo.getFile2();
		//파일명 추출
		String filename1 = multi1.getOriginalFilename();
		String filename2 = multi2.getOriginalFilename();

		String ext1 = filename1.substring(filename1.lastIndexOf("."));
		String ext2 = filename2.substring(filename2.lastIndexOf("."));

		filename1 = getUuid()+ext1;
		filename2 = getUuid()+ext2;
		
		//서버 c:/kdigital2/upload 폴더에 받아온 파일들을 저장
		String savePath = "c:/kdigital2/upload/";
		File file1 = new File(savePath + filename1);
		File file2 = new File(savePath + filename2);

		//저장
		multi1.transferTo(file1);
		multi2.transferTo(file2);
		
		vo.setFilename1(filename1);
		vo.setFilename2(filename2);
		
		service.fileInsert(vo);
		
		return "/upload/uploadresult";
	}
	
	@RequestMapping(value = "/myfilelist", method = RequestMethod.GET)
	public String myfilelist() {
		
		return "/upload/myfilelist";
	}

	@RequestMapping(value = "/myfilelist", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
	public ModelAndView myfileResult(String name) {
		
		List<UploadVO> vo = service.fileList(name);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("name", name);
		mv.setViewName("/upload/myfileresult");
		
		return mv;
	}
	
	public String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
	}
	
	
}

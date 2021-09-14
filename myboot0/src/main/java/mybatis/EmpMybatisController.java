package mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmpMybatisController {
	
	@Autowired
	EmpService service2;
	
	@RequestMapping("/emplist")
	public ModelAndView emplist() {
		
		ModelAndView mv = new ModelAndView();
		List<EmpVO> list = service2.getEmpList();
		
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist");
		
		return mv;
	}
	
	@RequestMapping(value="/empdeptform", method=RequestMethod.GET)
	public String empdeptlist() {
		
		return "/mybatis/empdeptform";
	}
	
	@RequestMapping(value="/empdeptlist", method=RequestMethod.POST, produces = {"application/json;charset=utf-8"})
	public ModelAndView emplistpost(int[] id, @ModelAttribute("pw") String pw) {
		
		ModelAndView mv = new ModelAndView();
		List<EmpVO> vo = service2.empDeptList(id);
		
		
		mv.addObject("empone", vo);
		mv.setViewName("/mybatis/empdeptlist");
		
		return mv;
	}
	
	
}

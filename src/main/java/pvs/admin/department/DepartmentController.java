package pvs.admin.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pvs.admin.state.IStateService;
import pvs.admin.state.StateEntity;
import pvs.admin.status.IStatusService;
import pvs.admin.status.StatusEntity;

@Controller
@RequestMapping("/department")
public class DepartmentController {


	@Autowired
	IDepartmentService deptservice;
	
	@Autowired
	IStatusService statusservice;

	@GetMapping("")
	public ModelAndView deptReport() {
		ModelAndView mav = new ModelAndView();

		List<DepartmentEntity> list = deptservice.getAllColumns();

		mav.addObject("depts", list);

		mav.addObject("page", "/admin/department/dept-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-dept")
	public ModelAndView addDept() {
		ModelAndView mav = new ModelAndView();

		DepartmentEntity entity = new DepartmentEntity();
		mav.addObject("dept", entity);

		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("statuses",list);
		
		mav.addObject("page", "/admin/department/add-dept");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(@ModelAttribute DepartmentEntity dept) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("dept", dept);
		if (deptservice.checkDeptName(dept.getDeptName())) {
			hasErrors = true;
			mav.addObject("deptNameError", "Duplicate Record!");
		}if (deptservice.checkDeptCode(dept.getDeptCode())) {
			hasErrors = true;
			mav.addObject("deptCodeError", "Duplicate Record!");
		}

		if (hasErrors) {
			List<StatusEntity> list = statusservice.getAllColumns();
			mav.addObject("statuses",list);
			
			mav.addObject("page", "/admin/department/add-dept");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		deptservice.addDept(dept);

		mav.setViewName("redirect:/department");
		return mav;
	}

	@GetMapping("/update-dept")
	public ModelAndView editDeptType(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();

		DepartmentEntity dept = deptservice.getDeptById(id);
		mav.addObject("dept", dept);

		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("statuses",list);
		
		mav.addObject("page", "/admin/department/update-dept");
		mav.setViewName("/admin/admin-page");

		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateDept(@ModelAttribute("dept") DepartmentEntity dept,RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		
		boolean hasErrors = false;
		
		if(deptservice.checkDeptNameAndId(dept.getId(), dept.getDeptName().trim())) {
			hasErrors = true;
			mav.addObject("deptNameError","Duplicate record!");
		}if(deptservice.checkDeptCodeAndId(dept.getId(), dept.getDeptCode().trim())) {
			hasErrors = true;
			mav.addObject("deptCodeError","Duplicate record!");
		}
		if(hasErrors) {
			List<StatusEntity> list = statusservice.getAllColumns();
			mav.addObject("statuses",list);
			
			mav.addObject("page","/admin/department/update-dept");
			mav.setViewName("/admin/admin-page");
			return mav;
		}
		
		deptservice.addDept(dept);
		 redirectAttributes.addFlashAttribute("message", "Department updated successfully!");
		
		mav.setViewName("redirect:/department");
		return mav;
	}

	
}

package controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DepartmentDAO;
import entity.Department;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping("/")
	public String index(@RequestParam(value = "value", required = false) String id, Model model) {
		if (id == null) {
			id = "Le Thanh Hoang";
		}
		model.addAttribute("index", id);
		return "index";
	}
	
	@RequestMapping({ "/deptList" })
	public String deptList(Model model) {
		departmentDAO.createDepartment("Dept Name", "Dept Location");

		List<Department> list = departmentDAO.listDepartment();
		for (Department dept : list) {
			System.out.println("Dept No " + dept.getDeptNo());
		}
		model.addAttribute("departments", list);
		return "deptList";
	}
}

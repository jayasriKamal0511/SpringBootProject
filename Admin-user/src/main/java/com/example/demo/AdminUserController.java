package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminUserController {
	
	@Value("${app.name}")
    private String name;
	
	@Value("${button.search}")
    private String search;
    
    @Value("${showAll.search}")
    private String showAllSearch;
    
    @Value("${app.name}")
    private String UserId;
	
	@Value("${app.FirstUserName}")
    private String FirstUserName;
    
    @Value("${app.LastUserName}")
    private String LastUserName;
    
    @Value("${app.AccountStatus}")
    private String AccountStatus;
    
    @Value("${app.AccessDetails}")
    private String AccessDetails;
    
    @Value("${app.Delete}")
    private String Delete;
    
    @Value("${app.Edit}")
    private String Edit;
	
	@Autowired
	private AdminUserDetailServiceImpl adminUserDetailServiceImpl;
	
	@RequestMapping(value="/adminUserDetails", method = RequestMethod.GET)
	public List<AdminUserEntity> getAdminUserDetails() {
		
		
		return adminUserDetailServiceImpl.getAdminUserDetails();

	}
	
	@RequestMapping(value="AdminUser", method = RequestMethod.GET)
	public String getUserDetails(ModelMap modelMap) {
		modelMap.put("adminUserDetails", adminUserDetailServiceImpl.getAdminUserDetails());
		return "AdminUser";
	}
	
	@RequestMapping(value = "deleteAdminUser/{id}",method=RequestMethod.GET)
	public String deleteUserDetails(@PathVariable int id) {
		
		adminUserDetailServiceImpl.deleteUserDetails(id);
		return "redirect:/AdminUser";
	}
	
	@RequestMapping(value="/editDetails/{id}")    
    public String edit(@PathVariable int id, Model m){    
		Optional<AdminUserEntity> adminUser=adminUserDetailServiceImpl.editAdminDetails(id);    
        m.addAttribute("command",adminUser);  
        return "AdminUserEdit";    
    }    
	
	@RequestMapping(value="/editAdminDetailsSave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("admin") AdminUserEntity adminUser){    
		adminUserDetailServiceImpl.update(adminUser);    
        return "redirect:/AdminUser";    
    } 
	

	@RequestMapping(value="/filterAdminDetails",method=RequestMethod.GET)
    public String filteredAdminDetails(ModelMap model, @Param("keyword") String keyword,@Param("AccountStatus") String AccountStatus) {
        List<AdminUserEntity> listProducts = adminUserDetailServiceImpl.filterAdminDetails(keyword);
        List<AdminUserEntity>statusFilteredList = new ArrayList<>();
       
        listProducts.stream().forEach(action->{
        	if(action.getAccountStatus().equals(AccountStatus)) {
        		statusFilteredList.add(action);
        	}
        });
        if(statusFilteredList.isEmpty()) {
        	model.put("adminUserDetails", listProducts);
        }
        else {
        	model.put("adminUserDetails", statusFilteredList);
        }
        //model.put("adminUserDetails", adminUserDetailServiceImpl.filterAdminDetails(keyword));
        //model.addAttribute("keyword", keyword);
        System.out.println(model);
        return "AdminUser";
    }
	
	@RequestMapping(value="/filterAdmin",method=RequestMethod.GET)
    public String filteredAdmin(ModelMap model, @Param("keyword") AdminUserEntity adminUserEntity) {
        //List<AdminUserEntity> listProducts = adminUserDetailServiceImpl.filterAdminDetails(keyword);
        model.put("adminUserDetails", adminUserDetailServiceImpl.filterAdminDetailsEnity(adminUserEntity));
        //model.addAttribute("keyword", keyword);
        System.out.println(model);
        return "AdminUser";
    }
	
	@RequestMapping("/AdminUserJsp")   
    public String AdminPage(){    
		  
        return "redirect:/AdminUser";    
    } 
	
	@RequestMapping("ClearData")
	public String clearData() {
		return "redirect:/AdminUser";
	}
	
	
    public String home(ModelMap map){
        map.addAttribute("var2", name);	   
        map.addAttribute("search", search);	 
        map.addAttribute("FirstUserName", FirstUserName);
        map.addAttribute("LastUserName", LastUserName);	   
        map.addAttribute("AccountStatus", AccountStatus);	 
        map.addAttribute("AccessDetails", AccessDetails);
        map.addAttribute("Delete", Delete);	 
        map.addAttribute("Edit", Edit);
        return "view";
    }
	
	
	 
}

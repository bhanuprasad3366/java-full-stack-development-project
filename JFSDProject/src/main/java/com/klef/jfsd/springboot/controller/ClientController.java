package com.klef.jfsd.springboot.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Customer;
import com.klef.jfsd.springboot.models.Producer;
import com.klef.jfsd.springboot.models.Product;
import com.klef.jfsd.springboot.services.AdminService;
import com.klef.jfsd.springboot.services.CustomerService;
import com.klef.jfsd.springboot.services.EmailService;
import com.klef.jfsd.springboot.services.ProducerService;
import com.klef.jfsd.springboot.services.ProductService;

import io.micrometer.core.ipc.http.HttpSender.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@Controller
public class ClientController
{

	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String demo()
	{
	   return "index";
	}
	
	
	@GetMapping("Register")
	public ModelAndView addpro()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addproducer");
		return mv;
	}
	
	@PostMapping("insertproducer")
	public ModelAndView addpro(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();
	    String msg = null;
	    String name = request.getParameter("name");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String address = request.getParameter("address");
	    String contact = request.getParameter("contactno");
	    String role = request.getParameter("role");

	    if (role.equalsIgnoreCase("Seller")) {
	        Producer pro = new Producer();
	        pro.setName(name);
	        pro.setGender(gender);
	        pro.setEmail(email);
	        pro.setPassword(password);
	        pro.setAddress(address);
	        pro.setContactno(contact);

	        producerService.addproducer(pro);

	        msg = "You have Registered as a Producer Successfully";
	        emailService.sendEmail(pro.getEmail(),"Demo mail","Hi you have sucessfully Registered");
	        // Render the producer home page or redirect to the producer-specific page.
	        mv.setViewName("displaymsg"); // Change "producerHomePage" to your actual view name.
	    } else if (role.equalsIgnoreCase("Buyer")) {
	        Customer customer = new Customer();
	        customer.setName(name);
	        customer.setGender(gender);
	        customer.setEmail(email);
	        customer.setPassword(password);
	        customer.setAddress(address);
	        customer.setContactno(contact);

	        customerService.addcustomer(customer);

	        msg = "You have Registered as a Customer Successfully";
	        emailService.sendEmail(customer.getEmail(),"Demo mail","Hi you have sucessfully Registered");
	        // Render the customer home page or redirect to the customer-specific page.
	        mv.setViewName("displaymsg"); // Change "customerHomePage" to your actual view name.
	    } else {
	        msg = "Invalid role selected";
	        // Handle the case where an invalid role is selected.
	        mv.setViewName("displaymsg"); // Change "errorPage" to your actual view name.
	    }

	    mv.addObject("message", msg);
	    return mv;
	}

	@GetMapping("Login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping("loginaction")
	public ModelAndView loginaction(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();

	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    Producer pro = producerService.checkProducerLogin(email, password);
	    Customer customer = customerService.checkCustomerLogin(email, password);

	    if (pro != null) {
	        // Producer login successful
	        HttpSession session = request.getSession();

	        session.setAttribute("pid", pro.getId()); // pid is a session variable
	        session.setAttribute("pname", pro.getName()); // pname is a session variable

	        mv.setViewName("prohome");
	    } else if (customer != null) {
	        // Customer login successful
	        HttpSession session = request.getSession();

	        session.setAttribute("cid", customer.getId()); // cid is a session variable
	        session.setAttribute("cname", customer.getName()); // cname is a session variable

	        mv.setViewName("customerhome");
	    } else {
	        // Login failed for both producer and customer
	        mv.setViewName("prologin");
	        mv.addObject("message", "Login Failed");
	    }

	    return mv;
	}

	
	
	
	@GetMapping("AdminLogin")
	public ModelAndView adminlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@PostMapping("adminloginaction")
	public ModelAndView adminloginaction(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		Admin admin = adminService.checkAdminLogin(name, password);
	       
	       if(admin!=null)
	       {
	    	   //session
	    	   HttpSession session=request.getSession();
	    	   //session
	    	 String  msg="welcome to admin home page";
	         mv.setViewName("adminhome");
	         mv.addObject("message", msg);
	       }
	       else
	       { 
	    	   mv.setViewName("adminlogin");
	    	   mv.addObject("message","Login Failed");
	         
	       }
	       return mv;
	
	}
	
	
	@GetMapping("ViewAllProducers")
	public ModelAndView viewemps()
	{
		List<Producer> producerslist=adminService.viewallproducers();
		
		ModelAndView mv=new ModelAndView("ViewAllProducers");
		mv.addObject("producersdata",producerslist);
		return mv;
		
	}
	
	@GetMapping("addproduct")
	public ModelAndView addproduct()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addproduct");
		return mv;
	}
	
	
	@PostMapping("upload")
	public ModelAndView uploadimage(HttpServletRequest request) {
		
		
	    ModelAndView mv = new ModelAndView("displayimage");
	   
	    
	    String msg=null;
	    try {
	        // Retrieve form fields
	    	
	    	int producerid = Integer.parseInt(request.getParameter("producerId"));
	        int productCost = Integer.parseInt(request.getParameter("productCost"));
	        String productType = request.getParameter("productType");
	        
	        int productRating =Integer.parseInt(request.getParameter("productRating"));
	        int productQuantity=Integer.parseInt(request.getParameter("productQuantity"));
	       String productDescription=request.getParameter("productDescription");
	        // Handle the uploaded image
	        Part file = request.getPart("productImage");
	        if (file != null) {
	            String imageFileName = file.getSubmittedFileName();
	            System.out.println("Selected Image: " + imageFileName);
	            
//	            String uploadPath = "B:/3-1 sem/JFSD/SpringBootDemoWORKSPACE/SpringBootImageTutorial/src/main/webapp/images/" + imageFileName;
	            String uploadPath =  "B:/3-1 sem/JFSD/SDPProjectWORKSPACE/JFSDProject/src/main/webapp/images/"+ imageFileName;
	            try (FileOutputStream fos = new FileOutputStream(uploadPath);
	                 InputStream is = file.getInputStream()) {
	                
	                byte[] data = new byte[is.available()];
	                is.read(data);
	                fos.write(data);
	                
	                // File saved successfully
	                
	                // Create a Product object with the form field values
	                Product product = new Product();
	                product.setName(imageFileName); // Use imageFileName as the product name
	                product.setCost(productCost);
	                product.setType(productType);
	                product.setRating(productRating);
	                product.setQuantity(productQuantity);
	                product.setDescription(productDescription);
	                product.setProducerid(producerid);
	                
	                // Save the product to the database using the ProductService
	                productService.addproduct(product);
	                msg="Product Successfully Added";
	            }
	        } else {
	            // Handle the case where no file was uploaded
	            // Provide an error message or redirect the user
	        	msg="Failed to Add Product";
	        }
	    } catch (Exception e) {
	        // Handle exceptions appropriately, e.g., show an error message to the user
	        e.printStackTrace();
	    }
	   
	    mv.addObject("message", msg);
	    return mv;
	   
	}
	
	
	@GetMapping("viewMyProducts")
	public ModelAndView viewMyProducts(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		
		HttpSession session = request.getSession();
		
		int id = (int) session.getAttribute("pid");
		
		List<Product> prolist=productService.getProductsByProducerId(id);
		mv.setViewName("displaymyproducts");
		mv.addObject("prodata", prolist);
		return mv;
	}

	@GetMapping("viewallproducts")
	public ModelAndView viewallproducts()
	{
		ModelAndView mv=new ModelAndView("ViewAllProducts1");
		List<Product> prolist=productService.viewallproducts();
		mv.addObject("prodata", prolist);
		return mv;
	}
	
	
	  @GetMapping("prohome")
	  public ModelAndView emphome(HttpServletRequest request)
	  {
		HttpSession session=request.getSession();
		int pid=(int)session.getAttribute("pid");
	    String pname=(String)session.getAttribute("pname");//pname is a session varible
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("prohome");
	    mv.addObject("pid", pid);	 
	    mv.addObject("pname", pname);
	    
	    return mv;
	  }
	  
	  @GetMapping("updateprofile")
	  public ModelAndView updateemp(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView();
	    
	    HttpSession session = request.getSession();
	    
	    mv.setViewName("updateprofile");
	    
	    mv.addObject("pid", session.getAttribute("pid"));
	    mv.addObject("pname", session.getAttribute("pname"));
	    
	    int id = (int) session.getAttribute("pid");
	    
	    Producer pro = producerService.viewproducerbyid(id);
	    
	    mv.addObject("pro", pro);
	    
	    return mv;
	  }
	  
	  
	  @PostMapping("update")
	  public ModelAndView updateaction(HttpServletRequest request)
	  {
	    String msg = null;
	    
	    ModelAndView mv = new ModelAndView();
	    
	      HttpSession session = request.getSession();
	    
	    mv.addObject("pid", session.getAttribute("pid"));
	    mv.addObject("pname", session.getAttribute("pname"));
	    
	    int id = (int) session.getAttribute("pid");
	    
	   try
	   {
	    
	     String name=request.getParameter("producerName");
	     String email=request.getParameter("producerEmail");
	     String address=request.getParameter("productAddress");
	     String contactno=request.getParameter("productContact");
	     
	     Producer pro=new Producer();
	    
	     pro.setName(name);
	     pro.setEmail(email);
	     pro.setAddress(address);
	     pro.setContactno(contactno);
	     
	    
	      msg=producerService.updateproducer(pro);
	      
	      mv.setViewName("emplogin");
	      mv.addObject("message",msg);
	     
	   }
	   catch(Exception e)
	   {
	     msg = e.getMessage();
	     
	     mv.setViewName("updateerror");
	      mv.addObject("message",msg);
	   }
	    
	   
	    return mv;

	  }
	 
}

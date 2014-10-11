package edu.sjsu.cmpe282.api.resources;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe282.domain.OrderView;
//import javax.servlet.http.*;
import edu.sjsu.cmpe282.domain.User;
import edu.sjsu.cmpe282.domain.UserView;
import edu.sjsu.cmpe282.dto.UserDao;

@Path("/users")
//@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	//@Context 
	//HttpServletRequest request;
	HttpSession session = null;
	private UserDao userdao = new UserDao();

	@POST
	@Path("/signup")
	public UserView signUp(User user) throws ClassNotFoundException {

		//System.out.print("user created: ");
		return userdao.addUser(user);
	}

	@POST
	@Path("/signin")
	public UserView signIn(@Context HttpServletRequest request,User user) throws ClassNotFoundException {
		return userdao.checkUser(request,user);
	}
	
	@POST
	@Path("/purchase/{param}")
	public void purchase(@PathParam("param") String userId){
		System.out.println("Inside purchase url");
		userdao.purchase(userId);
	}
	
	@GET 
	@Path("/order/{param}")
	public OrderView order(@PathParam("param") String userId){
		System.out.println("Inside Order url");
		System.out.println("User Id");
		return userdao.order(userId);
	}
}

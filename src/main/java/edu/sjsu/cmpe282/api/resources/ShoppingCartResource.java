package edu.sjsu.cmpe282.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe282.domain.CartItem;
import edu.sjsu.cmpe282.domain.ShopCartView;
import edu.sjsu.cmpe282.dto.ShoppingCartDao;
//import edu.sjsu.cmpe282.domain.Book;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShoppingCartResource {
	ShoppingCartDao shopDao = new ShoppingCartDao();
	//HttpSession session=null;
	
	@POST
	public void addToCart(CartItem cartItem) {
		
		shopDao.addToCart(cartItem);
		
		//System.out.println(session.getAttribute("prodView").toString());
	}
	
	@POST
	@Path("/updCart")
	public void updProduct(CartItem c) {
		System.out.println("Inside update Cart");
		shopDao.updProduct(c);
	}
	
	@GET
	@Path("{param}")
	public  ShopCartView getItemsInCart(@PathParam("param") String userId){
		System.out.println("Inside Get Items In cart");
		System.out.println("User ID " + userId );
		return new ShopCartView(shopDao.getItemsInCart(userId));
	}
	
	
}

package edu.sjsu.cmpe282.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe282.domain.Product;
import edu.sjsu.cmpe282.domain.ProductView;
import edu.sjsu.cmpe282.dto.ProductDao;

//import edu.sjsu.cmpe282.domain.Book;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
	ProductDao prodDao = new ProductDao();

	// HttpSession session=null;

	@GET
	@Path("{param}")
	public ProductView getAllProds(@PathParam("param") String id) {
		System.out.println("Inside getAllProducts");
		// System.out.println(cat.getCatalogName());
		// session = request.getSession();
		return prodDao.getAllProds(id);

		// System.out.println(session.getAttribute("prodView").toString());
	}

	/*
	 * @GET
	 * 
	 * @Path("/viewprods") public ProductView viewProds(@Context
	 * HttpServletRequest request) { //
	 * System.out.println("Inside viewAllProducts"); //
	 * System.out.println(cat.getCatalogName()); //session =
	 * request.getSession();
	 * //System.out.println(session.getAttribute("prodView")); return
	 * prodDao.getProductView(); }
	 */

	@POST
	@Path("/addProd")
	public void addProduct(Product prod) {
		System.out.println("Inside Add Book");
		prodDao.addProduct(prod);
	}
	
	
}

package edu.sjsu.cmpe282.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe282.domain.Catalog;
import edu.sjsu.cmpe282.domain.CatalogView;
import edu.sjsu.cmpe282.dto.CatalogDao;

@Path("/catalog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogResource {

	CatalogDao catDao = new CatalogDao();
	
	@POST
	@Path("/addCatalog")
	public void addCatalog(Catalog cat){
		catDao.addCatalog(cat);
	}
	
	@GET
	@Path("/catalogs")
	public CatalogView getallCatalogs() {
		System.out.println("Inside get All Catalogs Resource");
		CatalogView view = catDao.getAllCatalogs();
		return view;
	}
}

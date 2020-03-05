package se.rezaul.PointOfSale;


import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.JSONException;
import org.json.JSONObject;

@Path("aliens")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	ItemRepository itemRepo = new ItemRepository();
	OrderItemsRepository order = new OrderItemsRepository();
//Get all Items from database which is ItemRepository in here	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getAliens()
	{
		ResponseObject responseModel = null;
		List<Item> items  = itemRepo.getItems();
		if (items == null) {
			responseModel = new ResponseObject(100, "Something went wrong on server", null);
		}
		else {
			responseModel = new ResponseObject(200, "Success", items);
		}
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
		        .entity(responseModel).build();
	}
////Get only one alien by passing id from database which is AlienRepository in here
	@POST
	@Path("orderStatus")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getStatus(String id)
	{
		System.out.print(id);
		JSONObject jsonObject = new JSONObject(id);
		String table = jsonObject.getString("table_name");
		ResponseObject responseModel = null;
		if ( itemRepo.getOrdeSataus(table)) {
			responseModel = new ResponseObject(200, "Success", true);
		}
		else {
			responseModel = new ResponseObject(200, "Success", false);
		}
		
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
		        .entity(responseModel).build();
		
	}
//Post data from client site which is Postman in here	
	@POST
	@Path("alien")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public Response createAlien(String json) 
	{
		
		System.out.println(json);
		ResponseObject responseModel = null;
		try {
		     JSONObject jsonObject = new JSONObject(json);		    
		     boolean res = repo.create(jsonObject);
		     if (res) {
		    	 responseModel = new ResponseObject(200, "Order is placed successfully", null);
		 
		     }
		}catch (JSONException err){
		     System.out.println( err.toString());
		     responseModel = new ResponseObject(100, "Something went wrong on server", err);
		}
		return Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
        .entity(responseModel).build();
	}

	
}

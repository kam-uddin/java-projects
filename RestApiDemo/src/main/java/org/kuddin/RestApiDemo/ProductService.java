package org.kuddin.RestApiDemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/product")
public class ProductService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getProducts() {
        return "Product_ID: PD0001, Product_Desc: Nintendo Switch OLED - White";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsAsJSON() {
        return "{"
        		+ "\"Product_ID\":\"PD0001\","
        		+ "\"Product_Desc\":\"Nintendo Switch OLED - White\""
        		+ "}";
    }
    
}

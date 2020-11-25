package com.surendar.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class ShoppingCartTest     
{
  
    /**
     * Rigourous Test :-)
     */
	@Test
    public void addToCartSimpleProduct()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",1);
        assertEquals(Integer.valueOf(1), shoppingCart.addToCart(crayon, 1).get(crayon));
        
    }
	@Test
    public void addToCartSimpleProductWithNoQuantity()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",1);
        assertEquals(0, shoppingCart.addToCart(crayon, 0).size());
        
    }
	@Test
    public void addToCartSimpleProductAlreadyPresent()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",1);
        shoppingCart.addToCart(crayon, 3);        
        assertEquals(Integer.valueOf(5), shoppingCart.addToCart(crayon, 2).get(crayon));        
    }
	@Test
    public void listAllProductsSimpleCase() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",1);
        shoppingCart.addToCart(crayon, 3); 
        Product book=new Product("Book",10);
        shoppingCart.addToCart(book, 3); 
        Product table=new Product("Table",50);
        shoppingCart.addToCart(table, 1); 
        shoppingCart.listAllProductsInCart();       

    }
	@Test
    public void listAllProductsNoElement() {
        ShoppingCart shoppingCart = new ShoppingCart();
       
        shoppingCart.listAllProductsInCart();       

    }
	@Test
    public void deleteProduct() {
    	   ShoppingCart shoppingCart = new ShoppingCart();
           Product crayon=new Product("Crayon",1);
           shoppingCart.addToCart(crayon, 2); 
           assertEquals(1, shoppingCart.listAllProductsInCart().size());
           shoppingCart.deleteProduct(crayon);
           assertEquals(0, shoppingCart.listAllProductsInCart().size()); 
    	
    }
	@Test
    public void deleteProductNotExists() {
 	   ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",1);
        shoppingCart.addToCart(crayon, 2); 
        assertEquals(1, shoppingCart.listAllProductsInCart().size());
        Product book=new Product("Book",10);
        shoppingCart.deleteProduct(book);
        assertEquals(1, shoppingCart.listAllProductsInCart().size()); 
 	 }
	@Test
    public void displaySumSingleElement() {
    	
  	  ShoppingCart shoppingCart = new ShoppingCart();
        Product crayon=new Product("Crayon",2);
        shoppingCart.addToCart(crayon, 3); 
      
        shoppingCart.listAllProductsInCart(); 
        assertEquals(6.0, shoppingCart.displayTotal());
  	
  }
	@Test
    public void displaySum() {
    	
    	  ShoppingCart shoppingCart = new ShoppingCart();
          Product crayon=new Product("Crayon",1);
          shoppingCart.addToCart(crayon, 3); 
          Product book=new Product("Book",10);
          shoppingCart.addToCart(book, 3); 
          Product table=new Product("Table",50);
          shoppingCart.addToCart(table, 1); 
          shoppingCart.listAllProductsInCart(); 
          assertEquals(83.0, shoppingCart.displayTotal());
    	
    }
}

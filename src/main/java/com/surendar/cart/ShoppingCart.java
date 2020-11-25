package com.surendar.cart;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *ShoppingCart simulates the real time shopping cart where in you can manage your products before you buy them
 *
 */
public class ShoppingCart 
{
	enum Operations{
		ADD,
		LIST,
		DELETE,
		TOTAL,
		EXIT;
	};
	
	Map<Product,Integer> shoppingCart = new HashMap<Product,Integer>(); 
	
	/**
	 * Adds a product and the given quantity to the shopping cart
	 * @param product
	 * @param quantity
	 * @return
	 */
	
	Map<Product,Integer> addToCart(Product product,Integer quantity) {
		if(quantity>0) {
			if(!shoppingCart.containsKey(product))
				shoppingCart.put(product, quantity);
			else
				shoppingCart.computeIfPresent(product, (key,val)->val+quantity);
			
			System.out.println("Product added "+product.getName() );

		}else {
			System.out.println("Quantity cannot be zero");
		}
		return shoppingCart;
	}
	
	/**
	 * Lists all the products in the cart
	 * @return
	 */
	Map<Product,Integer> listAllProductsInCart() {
		if(shoppingCart.size()==0) 
				System.out.println("Empty basket");
		else
			shoppingCart.forEach((product,quantity)
				->System.out.println(" Product name: " + product.getName()
							+ " Product Price: "+product.getPrice()
							+ " Quantity: " + quantity));
		return shoppingCart;
		
	}
	
	/**
	 * Deletes the product from the cart. Note that whatever may the quantity added the product
	 * @param product
	 * @return
	 */
	
	Product deleteProduct(Product product) {
		if(shoppingCart.containsKey(product)) {
			shoppingCart.remove(product);
			System.out.println("Product deleted "+product.getName() );

		}else {
			System.out.println("Product not found "+product.getName() );
		}
		return product;		
	}
	
	/**
	 * Gives the total amount of the cart
	 * @return
	 */
	
	double displayTotal() {		
	 return	shoppingCart.entrySet().stream()
		     .mapToDouble(x-> x.getKey().getPrice() * x.getValue())
		      .sum();
		
	}
	
	/**
	 * Main entry point so that the classes can be used easily
	 * @param args
	 */
	public static void main(String args[]) {
		boolean exit=false;
		System.out.println("--Welcome to ShoppingCart");
		System.out.println("--Please note that all operations are case sensitive");
		ShoppingCart shoppingCart = new ShoppingCart();

		while(!exit) {
	        System.out.println("--Please enter a operation you want to perform");
	        System.out.println("--Allowed Operation are: ADD,LIST,DELETE,TOTAL,EXIT");
	        Scanner in = new Scanner(System.in);
	        
	        try {
				Operations operation=Operations.valueOf(in.nextLine());
				
				switch(operation) {
					case TOTAL:
						shoppingCart.listAllProductsInCart();
						System.out.println(" Total Price: "+shoppingCart.displayTotal());
						break;
					case LIST:
						shoppingCart.listAllProductsInCart();
						break;
					case EXIT:
						System.out.println("Thanks for using ShoppingCart :) ");
						exit=true;
						break;
					case ADD:												
						Product product = getUserInputProduct(in);
						System.out.println("--Enter quantity: ");
						int quantity =in.nextInt();
						shoppingCart.addToCart(product,quantity);
						break;
					case DELETE:														
						shoppingCart.deleteProduct(getUserInputProduct(in));						
						break;
					default:
						break;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("--Illegal Operation. Please enter a valid operation");			
			}catch(InputMismatchException e) {
				System.out.println("--Please enter a valid product name(String) ,its price (Double) and the quantity(Integer)");
			}	        
	       
		}	
		
	}

	private static Product getUserInputProduct(Scanner in) {
		System.out.println("--Enter Product name: ");
		String productName =in.nextLine();
		System.out.println("--Enter Product price: ");
		double productPrice =in.nextDouble();
		return new Product(productName,productPrice);
	}


}

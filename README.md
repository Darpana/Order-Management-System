# Order-Management-System

 Usually if we are following microservice architecture, it is a good practice to segraggate Inventory, Orders and User into       different services such as IMS (Inventory Management System), OMS (Order Management System) and Account Management System.
   But for the purpose of this assignment, the Inventory tables, Order tables and Account tables are included in the same          project.
   
   
 There are certain assumptions made here:
 
        a. Users are already authenticated and logged in for placing the order. Thereby no authentication is implemented.
        
        b. The parsing of the response is being done on the front end side as per the status code and body content sent.
        
        c. Inventory tables are managed manually thereby mmanually populating the items in it.
``` Here is the sample request on http://localhost:8080/order:```
        [
        	{
        		"itemId":1,
        		"accountId":1,
        		"unit":"KG",
        		"unitValue":250,
        		"quantity":2
        	},
        		{
        		"itemId":2,
        		"accountId":1,
        		"unit":"KG",
        		"unitValue":250,
        		"quantity":2
        	}
        ]




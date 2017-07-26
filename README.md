## Database Design for a Company
The program, written in SQL, Java, JDBC is used for designing of a database for a company named Future Inc. The company has three types of 
employees: technical staff, quality controller and worker. Each employee has a unique name, and address. A technical staff has an education
record indicating the degrees he/she obtained (BS, MS etc.) and technical position. For each quality controller, the company records the 
type of the product he/she will check. Each controller can check only one type of product. The company records the maximum number of 
products a worker can produce per day.

Workers are responsible for making the products. Quality controllers are responsible for testing the quality and technical staff will fix 
the problems on products. Each product is produced, checked and repaired by one worker, technical staff, and a quality controller. Each
product is assigned a unique product ID. The following information about a product should also be known:

 Date the product is produced;

 Time spent to make the product;

 The person who produced the product;

 The person who tested the product and the person who repaired the product if the product has been repaired.

There are three different types of products: product1, product2, product3. For product1, the size (small, medium, large) of the product 
and name of the major software used will be recorded. For product2, the size and color of the product will be recorded. For product3, 
the size and weight of the product will be recorded. If a product1 has any problem, only a technical staff who has graduate education 
can repair it. For the other products, any technical staff can repair it.

An account is maintained by the company to keep track of cost for each product. For each account, the database stores its unique account 
number and the date the account established, and the cost for the product. Three types of accounts are maintained:

 product1 - account to record cost for product 1,

 product2 - account to record cost for product 2,

 product3 - account to record cost for product 3.

A customer has a unique name, and an address. A customer can purchase one or more products. If a product purchased by a customer is 
defected due to an error made by a quality controller, the customer will make a formal complaint to the company with the following
information - Date of the complaint, Description of the complaint, Treatment expected (get money back or exchange for another product).
Each complaint is identified uniquely by its own id.

A product can be repaired by a technical staff either because it got a complaint or because the repair was requested by a quality 
controller. The date of repair will be recorded. When workers produce products or technical staffs repair products, there may be an 
accident. A unique accident number, accident date and number of work days lost due to the accident will be recorded for each accident.

Application Tasks file consists of all the tasks that are to be performned by the database which include various CRUD operations.
SQL Creation file consists of all the SQL commands to create the tables in a database.

Softwares Used : Oracle SQL Developer, Eclipse, ODBC-JDBC Driver.

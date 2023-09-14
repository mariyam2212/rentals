# rentals

The goal is to build a real estate management application. Users can register with the application, add their payment information and personal details, and most importantly search and book properties.
### Data Requirements 
#### 3.1 User
• For each User, we should record the name of the User, one or more addresses, and email address. Users can be either agents or perspective renters and are identified by their email address.
– For agents, we should also record their job title, real estate agency they work for, and contact information.
– For perspective renters, we should record their rental preferences such as desired move-in date, preferred location, and budget, as well as their credit card information. A perspective renter can have multiple credit cards, and for each credit card, we associate it with a payment address (one of the User’s addresses). Further- more, we record for each User their preferred location.
#### 3.2 Property information
The database should record information about Users, properties, prices, and booking.
#### Property: The main asset of the real estate agency are properties.
– A property has a unique identifier, a type (e.g., apartment, house), a location, and a description. For each property, record the city it is located in (e.g., Chicago), and the state (if applicable).

– For the project, we will consider the following types of properties:

_ **Houses**_: Houses have a location, number of rooms, and square footage.

_ **Apartments**_: Apartments have a location, number of rooms, square footage, and building type.

_ **Commercial Buildings**_: Commercial buildings have a loca- tion, square footage, and type of business.

– For each property, we need to store information such as the ad- dress, price, and availability.
#### Price: Each property has a rental price
#### Booking: 
A property booking is for a particular Renter. For each property booking we have to store which of the Renter’s credit cards was used to make the booking.

## ER Diagram
![ER](https://github.com/mariyam2212/rentals/blob/master/ERD.drawio.svg)

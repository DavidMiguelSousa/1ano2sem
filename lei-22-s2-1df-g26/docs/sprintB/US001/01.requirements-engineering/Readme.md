# US 001 -  As an unregistered user, I want to display listed properties.

## 1. Requirements Engineering


### 1.1. User Story Description


As an unregistered user, I want to display listed properties.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**


>	Unregistered users can only list properties.


>	The client can choose if he wants to select the type of business (sale or rent) type of property (house, apartment or land) and the number of rooms (in case it's a house or an apartment) in that residence.


>   The user can sort displayed properties by different criteria, ascending or descending: price, city or state of the property.



**From the client clarifications:**

> 2023/03/20
>
> **Question 1:** In the project's documentation it's mentioned that "All those who wish to use the application must be authenticated", but in the US1 it's said that an unregistered user can see a list of properties. Can users who aren't authenticated do this?
>  
> **Answer 1:** Non-authenticated users can only list properties.
>
> 
> **Question 2:** The properties can be in sale and lease at the same time?
>
> **Answer 2:** No.
> 
> 
> **Question 3:** Can an unregistered user only see sale announcements or he is able to contact the agency agents to make a purchase request?
>
> **Answer 3:** From the project description: "As an unregistered user, I want to display listed properties". For now this is the only functionality of the system that the non-registered user can use.

> 2023/03/21
>
> **Question 4:** In the project description it is stated that "the client is, then, responsible for being able to consult the properties by type, number of rooms, and sort by criteria such as price or the parish where the property is located.". Is the client able to sort properties by only these 4 criteria or is he able to sort properties by any of the properties' characteristics?
>
> **Answer 4:** The client should be able to select the type of business (renting or buying), the type of property and the number of rooms. Then, the client should be able to sort properties by price or by parish where the property is located. If the client does not select the type of business, the type of property and the number of rooms, the application should allow the client to sort all properties that are on sale or on renting.
>
>
> **Question 5:** When an unregistered user opens the application, are there already properties being listed?
>
> **Answer 5:** If the system does not contain any properties, the system should show an empty list of properties.

> 2023/03/28
> 
> **Question 6:** When an unregistered user wants to list properties, the list given by the program is sorted by default with which criteria? For example the list is shown with the properties sorted by most recently added?
> 
> **Answer 6:** By default, the list should be shown with the properties sorted by most recently added.
>
> 
> **Question 7:** Can a user filter the properties list for example by a type but choosing multiple values? For example the users wants to see only properties with 3 or 4 rooms. If this is possible, after filtering the list to show only the values chosen, he can sort by ascending/descending?
> 
> **Answer 7:** The user should select only one value for each feature of the property.
> 
>
> **Question 8:** One of the search criteria is "number of rooms". Is "Number of Bedrooms" or "Number of Bathrooms" or both?
> 
> **Answer 8:** Number of Bedrooms.

> 2023/03/30
> 
> **Question 9:** In a previous question, you said that the address doesn't include parishes ("In the USA, the addresses will not include municipalities or parishes."). That being said, how should we sort the properties by location, specifically city, and state? This doubt originates from the difference in information provided because the project requirements were explicit that properties should be sorted by parishes.
>
> **Answer 9:** The client should be able to sort properties by price, city and state.

> 2023/04/15
> 
> **Question 10:** When choosing to sort the properties list by price or by parish (alphabetically) do we also have to choose the order (ascending/descending)? If not : The order which the properties are sorted by default is an ascending (for price from lowest to highest  and for parish from A to Z) or in descending order?
> 
> **Answer 10:** The client should be able to sort (ascending or descending) properties by price, city and state, By default, the list should be shown with the properties sorted by most recently added.
>
> 
> **Question 11:** Does a rent request includes a contract duration (minimum or defined)?
> 
> **Answer 11:** The characteristics for a rental are the same as the ones for the sale of a property. The rent value is per month. Additionally, we have to define the contract duration. There is no minimum.
> 
> 
> **Question 12:** When sorting by price or location: 1) Does it mean ascending or descending? Most expensive to least expensive or vice-versa. By closest to furthest or vice-versa. 2) To filter between a range of price? 3) To filter the location of the property by city?
> 
> **Answer 12:** The client should be able to sort (ascending or descending) properties by price, city and state. I do not want the filters that you are suggesting.

> 2023/04/20
>
> **Question 13:** In a question earlier you presented the owner attributes. Does the client have different attributes?
> 
> **Answer 13:** A owner is also a client of the Real Estate USA company. The attributes are the same. This distinction between owner and client intends to make an association with the type of business. The Owner sells and provides properties for renting and the client buys and rents properties. Again, when the user (registered in US7) logins in the system, the user should have access to both owner and client functionalities.


### 1.3. Acceptance Criteria


* **AC1:** The buyer, when listing properties, can't see the agency's/agent's commission.
* **AC2:** The buyer isn't able to contact the agency or book visits through the app unless he registers.
* **AC3:** The buyer isn't able to see the exact address of the property, only its city and state.
* **AC4:** The sun exposure must be defined as existing (if so, with the correspondent direction) or unexisting.
* **AC5:** If the buyer wants to rent a house, the contract duration must be defined.


### 1.4. Found out Dependencies


* There could exist a dependency to "US002" since to display listed properties successfully it should be necessary to exist properties inserted in the system. However, since according to client clarifications, if there are no properties listed the program should show an empty list, there are no dependencies to other User Stories.


### 1.5 Input and Output Data


**Input Data:**

* Selected data:
  * Buy/Rent option
  * Type of property
  * Number of rooms
  * Prince range
  * City of the property
  * State of the property


**Output Data:**

* List of all properties
* List of a certain type of property for sale/rent, with a defined number of rooms, according to user's choices
* List of those properties sorted according to user's selected filters



### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**


![System Sequence Diagram (SSD) - US001](svg/us001-system-sequence-diagram.svg)
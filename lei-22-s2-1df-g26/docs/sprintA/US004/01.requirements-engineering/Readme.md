# US 004 - As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.

## 1. Requirements Engineering

### 1.1. User Story Description

As an owner, I intend to submit a request for listing a property sale or rent,
choosing the responsible agent.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>   The owner provides property characteristics and the requested price and sends the request to an agent.

>	The owner must provide information on the type of property, the area in m2, the location, the distance from the city centre and one or more photographs. 

>   If the property is an apartament or a house, the owner also provides: the number of bedrooms, the number of bathrooms, the number of parking spaces and the available equipment, such as central heating and/or air conditioning.

>   In the property is a house, the existence of a basement, an inhabitable loft, and sun exposure must be registered as well. 

**From the client clarifications:**

> **Question:** In case it is on an agency, must the agent be assigned automatically by the system?
>  
> **Answer:** The agent that registers the information in the system can choose to assign any agent.

> **Question:** Are there any restrictions on the choice of an Agent?
>  
> **Answer:** No.

> **Question:** In case the submission of the listing is online may the owner choose any agent?
>
> **Answer:** Yes.

> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
> 
> **Answer:** No.

> **Question:** Does an owner need to be registered in the system to submit a request for a property listing?
> 
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.

> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency,etc)?
> 
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.

> **Question:** Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
> 
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.

> **Question:** Is there a designated currency for this business, or should we use USD?
>
> **Answer:** Please use USD.

> **Question:** Also another question, when publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as a sketch to be finished later ?
>
> **Answer:** No. 

> **Question:** Is it possible to submit multiple listing for the same property and type of listing?
>
> **Answer:** No.

> **Question:** In the Project description, there are only specifications for a Sale. What are the required characteristics for a rental?
>
> **Answer:** The caracteristics for a rental are the same as the ones for the sale of a property. The rent value is per month. Additionally, we have to define the contract duration.

> **Question:**  In a previous question, you answered that, regarding US001 filtering/sorting system, the client should be able to select (from a list) the type of business, the type of property, and the number of rooms. Does this apply too to the process of an owner submitting a request? Or does the owner has to type these characteristics?
>
> **Answer:** Yes.

> **Question:** If the owner doesn't select an agent will the platform randomly assign one or the request cannot move to revision? If not, must we assume that all information slots must be filled?
>
> **Answer:** Thank you for your suggestion. When filling the property data, the owner should select one agent from the list of agents working in the selected agency. Moreover, the application should include a feature to randomly assign one agent. The address of the owner is not mandatory.

> **Question:** Do requests have any reference/code identifying them with any specific format? What about descriptions (any restrictions, like character limit)? Does that reference carry out with the advertisement?
>
> **Answer:** Please choose appropriate data formats for the request. You are a team of experts and you should choose appropriate formats. In the next sprints I will specify some data formats.

> **Question:** When renting, does the owner have any space to clarify any prohibitions or obligations with the property?
>
> **Answer:** No.

> **Question:** Does the owner have a limit of requests they can do?
>
> **Answer:** No.

> **Question:** Regarding the property’s photographs, is that considered selected data?
>
> **Answer:** The owner should input the URI of each file/photograph.

### 1.3. Acceptance Criteria

* **AC1:** Can only choose to sell or rent, not both
* **AC2:** Area must be in m2
* **AC3:** The owner should select one agent 
* **AC4:** The owner must select a type of property
* **AC5:** The currency used must be USD

### 1.4. Found out Dependencies

* There is a dependency to "US002 Publish any sale announcement" since there needs to be an agent so that I can submit a request for listing a property and choose an agent responsible for that property.
### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Property information
    * Price
    * Comission

* Selected data:
    * Sale/Rent option
	* Property category
    * Number of rooms
    * Choosing an agency
    * Choosing an agent

**Output Data:**

* Property category list
* List of number of rooms 
* List of agencies
* List of available agents
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* n/a

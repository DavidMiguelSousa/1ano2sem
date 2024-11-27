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

> 15/03/2023
 
> **Question:**  We are having a little issue defining what the sun exposure might be. We are not sure what it will be as a value. If it's a number that defines how much exposure the house has or if it is just a text saying if it has or hasn't sun exposure.
> 
> **Answer:** Sun exposure will take the following values: North, South, East, or West.

> 17/03/2023

> **Question:** In the Project description, there are only specifications for a Sale. What are the required characteristics for a rental?
>
> **Answer:** The caracteristics for a rental are the same as the ones for the sale of a property. The rent value is per month. Additionally, we have to define the contract duration.

> **Question:** In case it is on an agency, must the agent be assigned automatically by the system?
>  
> **Answer:** The agent that registers the information in the system can choose to assign any agent.

> **Question:** Are there any restrictions on the choice of an Agent?
>  
> **Answer:** No.

> **Question:** In case the submission of the listing is online may the owner choose any agent?
>
> **Answer:** Yes.

> 20/03/2023

> **Question:** Is it possible to submit multiple listing for the same property and type of listing?
>
> **Answer:** No.

> **Question:** Does that imply that a seller can choose the agency/branch/store independently of the location of the property?
>
> **Answer:** Yes.

> 21/03/2023

> **Question:** Also another question, when publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as as a sketch to be finished later ?
>
> **Answer:** No.

> **Question:** Is there a designated currency for this business, or should we use USD?
>
> **Answer:** Please use USD.

> **Question:** Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
>
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.

> **Question:** Does an owner need to be registered in the system to submit a request for a property listing?
>
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.

> 22/03/2023

> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency,etc)?
>
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.

> 23/03/2023

> **Question:** According to the Project Description, the agent when selling a property can charge a flat price comission or a percentage of the sale value, my question here is wether there is a minimum and/or a maximum to each of these types of comissions?
> 
> **Answer:** There is no maximum and the minimum is 0.

> 25/03/2023

> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
> 
> **Answer:** No.

> 27/03/2023

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

> **Question:**  In a previous question, you answered that, regarding US001 filtering/sorting system, the client should be able to select (from a list) the type of business, the type of property, and the number of rooms. Does this apply too to the process of an owner submitting a request? Or does the owner has to type these characteristics?
>
> **Answer:** Yes.

> 28/03/2023

> **Question:** When creating a request for sale/lease, after the owner has provided all necessary details, should there be a confirmation message where the owner can see all details he previously provided to check for possible mistakes?
>
> **Answer:** Please follow the best pratices on this subject.

> **Question:** If so, should it be possible to change each value/detail on its own, or would the only options be to cancel or submit the request?
>
> **Answer:** If there are any errors, the application should allow the owner to correct the errors.

> **Question:** In US004 can the owner make the request to sell or rent a property directly with the system or does the request need to be made directly to the agent?
>
> **Answer:** Please check carefully the requirements for sprints A and B.

> 29/03/2023

> **Question:** What are the attributes of an announcement? Should the announcement have a publication date, and a defined type of announcement embeded (sale or rent)?
>
> **Answer:** Please check the project description available in moodle. Please show the publication date.

### 1.3. Acceptance Criteria

* **AC1:** Can only choose to sell or rent, not both.
* **AC2:** Area must be in m2 and positive.
* **AC3:** The owner should select one agent. 
* **AC4:** The owner must select a type of property.
* **AC5:** The currency used must be USD.
* **AC6:** The owner should input the URI of each file/photograph.
* **AC7:** Sun exposure will take the following values: North, South, East, or West.
* **AC8:** All required fields must filled in.

### 1.4. Found out Dependencies

* There is a dependency to "US003 As a system administrator, I want to register a new employee" since there needs to be an agent so that the owner can submit a request for listing a property and choose an agent responsible for that property.
* There is a dependency to "US005 As a system administrator, I want to register a store" since the owner must choose an agency before chosing the responsible agent.
* There is a dependency to "US006 As a system administrator, I want to specify states, districts and cities in the system" since the owner nedds to be alble to introduce the property adress.
### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Area in m2
    * Distance from city centre
    * URI of photographs
    * Number of bedrooms
    * Number of bathrooms
    * Number of parking spaces
    * Existence of inhabitable loft
    * Existence of basement
    * Existence of air conditioning
    * Existence of central heating
    * Sun exposure
    * Price
    * Rent
    * Contract duration

* Selected data:
    * Sale/Rent option
	* Property category
    * Choosing an agency
    * Choosing an agent

**Output Data:**

* Property category list
* Announcement category list
* List of agencies
* List of available agents
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* n/a

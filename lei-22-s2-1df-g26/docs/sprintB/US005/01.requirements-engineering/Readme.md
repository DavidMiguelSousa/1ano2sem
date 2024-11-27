# US 005 - As a system administrator, I want to register a store.

## 1. Requirements Engineering

### 1.1. User Story Description

As a system administrator, I want to register a store.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>   Each store in the network has a store manager.

>	The set of stores is managed by a store network manager.

**From the client clarifications:**

> **Date:** Saturday, 18 March
> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
> 
> **Answer:** The System Administrator should be logged in the application.

> **Date:** Saturday, 18 March
> **Question:** Lastly, can there be more than one admin?
> 
> **Answer:** No.

> **Date:**  Tuesday, 21 March
> **Question:** Does a store designation have to be detailed? If so, will the system administrator have to register the name, email, phone number or anything else?
> Does the location of a store have to be detailed as well? If yes, will the system administrator have to record the address, postcode or something else?
> To register the store manager, does the system administrator only register the manager's name?
> If not, will the system administrator have to register the manager as if he were an employee (except the agent he is assigned to)?
>
> **Answer:** When registering a store, the System Administrator should introduce the following information:
> an ID, a designation/name, a location, a local manager, a phone number and an e-mail address. The ID is an integer number.
> An example of the store location is: 71 ST. NICHOLAS DRIVE, NORTH POLE, FAIRBANKS NORTH STAR, AK, 99705. An example phone number is (907) 488-6419.

> **Date:** Thursday, 23  March
> **Question:** Could you please share how will the designation of new stores be made, is there a pattern perhaps?
> 
> **Answer:** There is no pattern. The System Administrator can introduce any designation/name. The designation/name should have at most forty characters.

> **Date:** Thursday, 23  March
> **Question:** Will the System Administrator be able to choose a location from a list of available locations (defined elsewhere in the application) or will he be able to submit any location he wants?
>
> **Answer:** The System Administrator can submit any location.

> **Date:** Friday, 24 de March
> **Question:** To register an employee I need to allocate him with a branch. To register a branch I need an employee (to be local manger) but I can't create the employee because I have no branch and I can’t create the branch because I have no employee.
> 
> **Answer:** Thank you for identifying this issue. We already updated the project description. When a store is created in the system, the System Administrator should not set the Store Manager.
When registering a store, the System Administrator should introduce the following information: an ID, a designation/name, a location, a phone number and an e-mail address.

> **Date:** Monday, 27 March
> **Question:** - Do employees use a company issued e-mail or do they have to use their personal e-mail to log-in? Can an employee use his work account to sell and/or buy property? And in case he has a company e-mail can he use it for those purposes or does it have to be his personal e-mail?
> 
> **Answer:** A e-mail account is required to register an employee. This e-mail account will be used as login and will also be used as the employee business e-mail account.

> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
> 
> **Answer:** The System Administrator should be logged in the application.

> **Question:** Lastly, can there be more than one admin?
> 
> **Answer:** No.

> **Question:** There is only one manager for each store and only ONE system administrator ?
>
> **Answer:** Yes.

### 1.3. Acceptance Criteria
* **AC1:** The System Administrator should be able to register a store with the following information: an ID, a designation/name, a location, a phone number and an e-mail address
* **AC2:** The ID is an integer number
* **AC3:** The designation/name should have at most forty characters
* **AC4:** The System Administrator should be logged in the application
* **AC5:** The System Administrator should be the only one able to register a store

### 1.4. Found out Dependencies

* There is a dependency to "US003 As a system administrator, I want to register a new employee." since there needs to exist a local manager for the Store.
### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * Store ID
    * Store designation/name
    * Store location
    * Store phone number
    * Store e-mail address


**Output Data:**

* Store data:
    * Store ID
    * Store designation/name
    * Store location
    * Store local manager
    * Store phone number
    * Store e-mail address

### 1.6. System Sequence Diagram (SSD)


![](svg/us005-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* The System Administrator should only choose the Store manager after the Store is registered.

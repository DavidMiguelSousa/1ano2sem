# US 003 - As a system administrator, I want to register a new employee.

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a new employee. 

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The company's systems administrator will be responsible for registering all employees (specifying the name, the citizen's card number, the tax number, the location, the email location, the contact telephone number and the agency to which it is assigned)

>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 



**From the client clarifications:**

> **Question:** The administrator when registering a new employee will also have to specify the category/office that he will perform (for example agent, store manager, store network manager)?
>  
> **Answer:** The administrator has to specify the role of the employee.

> **Question:** What would be the attributes of the System Administrator, Agency and the Roles?
> 
> **Answer:** The System Administrator is an employee. You can get the roles from the project description. Please check the project description.
Moreover, I just answered a question to clarify what are the attributes of an agency/store.

> **Question:** Can an employee be registered to more than one agency?
> 
> **Answer:** No.

> **Question:** When registering a new employee, will the administrator set the respective employee password?
>
> **Answer:** The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.

> **Question:** Does the System Administrator have permission to create, edit, delete, or just create new employee registrations?
>
> **Answer:** For now, the System Administrator can only do what is specified in the Project Requirements.

> **Question:** Do employees use a company issued e-mail or do they have to use their personal e-mail to log-in? Can an employee use his work account to sell and/or buy property? And in case he has a company e-mail can he use it for those purposes or does it have to be his personal e-mail?
> 
> **Answer:** An e-mail account is required to register an employee. This e-mail account will be used as login and will also be used as the employee business e-mail account.

>**Question:** You've stated previously that an employee can only be registered to one agency so what happens if an employee wants/has to change agencies and needs to be registered to a new one? Should the system reject such operation or should the employee's previous registration be deleted?
> 
>**Answer:** For now I do not want such features to be included in the system. I will discuss your suggestion with the company shareholders and I will come back here if we decide to include such features in the system.

> **Question:** When registering a new employee, all the required data (name, citizen's card number, etc...) have to be filled or exists not mandatory data?
> 
> **Answer:** Required/Mandatory data that should be filled when registering an employee: name, the citizen's card number, the tax number, the email location, the contact telephone number and the agency to which it is assigned.

> **Question:** However, it was replied to a question when a new Employee is created in the system, that a 8 digit Password should be automatically generated. How many digits should we go forward for password length validation in your software? And please confirm required special characters, etc.
> 
> **Answer:** Sorry, I completely forgot that all our authentication systems require passwords with seven alphanumeric characters in length , including three capital letters and two digits. The password should be generated automatically. The password is sent to the employee by e-mail.

>**Question:** Does the system administrator select the agency to which the employee is assigned and his role from a list? Or does he just type that data?
> 
> **Answer:** The System Administrator should select.

>**Question:** Must the Tax number and Citizen's card number follow any convention? If so, which?
> 
> **Answer:** You should use the tax identification number used for tax purposes in the US.

>**Question:** The system administrator cannot add an agent that already exists, the agent has two unique numbers that identify him (Tax number and Citizen's card number) which one should be used to identify the agent?
> 
> **Answer:** The tax number.

### 1.3. Acceptance Criteria

* The authentication systems require passwords with seven alphanumeric characters in length, including three capital letters and two digits. It should be generated automatically.
* An e-mail account is required to register an employee. The e-mail will be used as login as well as the business e-mail.
* It should be used the tax identification number used for tax purposes in the US. 
* An employee is identified by their tax number.
* The employee can only work in one agency.

### 1.4. Found out Dependencies


* There is a dependency to "US 005 - As a system administrator, I want to register a store" since an employee must be registered in an already existing agency, its dependency being with US005 (As a system administrator, I want to register a store.)
* 


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a name
	* a citizen card number, 
	* a location,
	* a tax number,
	* an email,
	* a phone number
	
* Selected data:
	* Classifying employee
    * Agency

**Output Data:**

* List of existing agencies
* List of roles (Agent, Store Manager, Store Network Manager)
* Generates a password
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![us003-system-sequence-diagram.svg](svg%2Fus003-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* After password is generated, an email is sent to the employee's business e-mail with the password. They should log-in with the email and given password.
# US 006 - To create a Task 

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...      | Answer                     | Justification (with patterns)                                                                                                    |
|:---------------|:-------------------------------------------------|:---------------------------|:---------------------------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?                 | RegisterEmployeeIU         | Pure Fabrication:  Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                        | RegisterEmployeeController | Controller                                                                                                                       |
| 			  		        | 	... instantiating a new Employee?               | EmployeeRepository         | Creator (Rule 1): Stores all Employees.                                                                                          |                            |                                                                                                                                  |
|                | ... managing the list of agencies in the system? | AgencyRepository           | Creator: Stores all Agencies                                                                                                     |
| 			  		        | ... knowing the user using the system?           | UserSession                | IE: cf. A&A component documentation.                                                                                             |
| 			  		        | 							                                          | Organization               | IE: knows/has its own Employees                                                                                                  |
| 			  		        | 							                                          | Employee                   | IE: knows its own data (e.g. email)                                                                                              |
| Step 2  		     | 							                                          |                            |                                                                                                                                  |
| Step 3  		     | 	...saving the inputted data?                    | Employee                   | IE: object created in step 1 has its own data.                                                                                   |
| Step 4  		     | 	...knowing the task categories to show?         | System                     | IE: Register Employee are defined by the Administrators.                                                                         |
| Step 5  		     | 	... saving the selected category?               | Employee                       | IE: object created in step 1 is classified in one Category.                                                                      |
| Step 6  		     | 							                                          |                            |                                                                                                                                  |              
| Step 7  		     | 	... validating all data (local validation)?     | Employee                     | IE: owns its data.                                                                                                               | 
| 			  		        | 	... validating all data (global validation)?    | EmployeeRepository               | IE: knows all its employees.                                                                                                     | 
| 			  		        | 	... saving the created task?                    | EmployeeRepository               | IE: owns all its employees.                                                                                                      | 
| Step 8  		     | 	... informing operation success?                | RegisterEmployeeIU               | IE: is responsible for user interactions.                                                                                        | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * EmployeeRepository
 * Employee

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterEmployeeIU
 * CreateTaskController (Controller)
 * UserSession (IE)
 * EmployeeRepository (IE)
 * 
## 3.2. Sequence Diagram (SD)

![uss003-sequence-diagram-full.svg](svg%2Fuss003-sequence-diagram-full.svg)


## 3.3. Class Diagram (CD)

![us003-class-diagram.svg](svg%2Fus003-class-diagram.svg)
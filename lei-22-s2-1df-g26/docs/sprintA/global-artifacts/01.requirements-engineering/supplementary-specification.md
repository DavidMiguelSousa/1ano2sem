# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

- **Localization:** The application supports English language only.
- **Email:** The app has access to user's emails.
- **Help:** There will exist an instructions manual to provide help for all users.
- **Security:** The app has a password unique to one user (created by that user) to login in the app.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- **Prevention of errors entered by the user:** If the user tries to advance without filling the mandatory fields, the app doesn't let him. 
- **Adequacy of the interface for different types of users:**
- **Aesthetics and design:** Minimalist and intuitive design that’s easy for the user to walk around the app.
- **Interface consistency:** All the application pages have to be consistent in the presentation of the information.


## Reliability

_Refers to the integrity, compliance and interoperability of the software._

- **Frequency and severity of system failures:**
- **Disaster recovery possibility:**
- **Accuracy of some calculus:**


## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

- **Response time:**
- **System start-up time:**
- **System recovery time:**
- **System setup time:**
- **System shutdown time:**
- **Memory consumption:**
- **CPU usage:**
- **Load/Usage capacity:**


## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

- **Testability:**
- **Adaptability:**
- **Maintainability:**
- **Compatibility:**
- **Configurability:**
- **Installability:**
- **Scalability:**
- **Localizability:** English Language


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

- **Paradigms:** OO software analysis and design; adopt recognized coding standards and use Javadoc to generate useful documentation for Java code.


### Implementation Constraints

_Specifies or constraints the code or construction of a system such 
as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- **Formats:** Images/Figures recorded in SVG.
- **Database Integrity:** Use of object serialization.
- **Implementation Languages:** Designed using Java language, using Intellij IDEA; graphical interface must be developed in JavaFX 11; unit tests must be made using JUnit5 and JaCoCo.


### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._
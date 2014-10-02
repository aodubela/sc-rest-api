sc-rest-api
===========

Sample app to show vertical slice of REST based end to end api with backend using Spring MVC framework.  In this instance scope is minimal but the concepts are fundamental.  Structure is set up so that controllers expose CRUD operations via REST and communicate to backend via Services.  The services(a la SOA) process any user requests across horizontally across other services.  Being that ther is only one services this portion is not demonstrated in the portion but can be leverage as such.  Vertically the Controller->Services->Repository/DAO using models.

Controller
===========
GameController class is the interactive layer between app and external requests.  

Services
===========
Services layer do the heavy lifting in the app and communicate to persistence layer to get required data and transform it to what the controller requested.

Persistence
===========
GameRepository class is used to perofm all CRUD operations on the game class.

Model
===========
Game model is the actual class being modeled in DB as a POJO.




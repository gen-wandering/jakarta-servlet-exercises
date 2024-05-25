# Jakarta Servlet Exercises

* **Hello world servlet (**[`helloservlet`](src/main/java/com/jakartaservletapp/helloservlet)**)**\
  Simple HelloWorld servlet implementation.\
  _Access:_ http://localhost:8080/hello-servlet<br/><br/>

* **Using ServletContext parameters (**[`configurableservlet`](src/main/java/com/jakartaservletapp/configurableservlet)**)**\
  Demonstration of using ServletContext to access initialization parameters.\
  _Access:_ http://localhost:8080/config-servlet<br/><br/>

* **Working with request data (**[`requestdataprocessing`](src/main/java/com/jakartaservletapp/requestdataprocessing)**)**
  * _Form Data:_ using a form to receive data from a web page and further process it.\
    _Access:_ http://localhost:8080/collect-data.html<br/><br/>
  * _Headers:_ processing headers received from an AJAX request.\
    _Access:_ http://localhost:8080/ajax-header-request.html<br/><br/>
  * _Cookies:_ processing cookies received from a request.\
    _Access:_ http://localhost:8080/cookie-servlet<br/><br/>
  * _Parameters:_ using links and buttons to receive parameters and further process them.\
    _Access:_ http://localhost:8080/parameters.html<br/><br/>
  * _Path Variables:_ using links to receive path variables and further process them.\
    _Access:_ http://localhost:8080/path-variable.html<br/><br/>

* **Working with session and its attributes (**[`session`](src/main/java/com/jakartaservletapp/session)**)**\
  Invalidating the session after a certain number of requests.\
  _Access:_ http://localhost:8080/session-servlet<br/><br/>

* **Servlet collaboration (**[`collaboration`](src/main/java/com/jakartaservletapp/collaboration)**)**\
  A login application demonstrating servlet communication using the `forward()`, 
  `include()` and `sendRedirect()` methods.\
  _Access:_ http://localhost:8080/reg-servlet
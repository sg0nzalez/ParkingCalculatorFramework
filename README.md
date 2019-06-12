# ParkingCalculatorFramework

Adding 2 automated tests for web page http://adam.goucher.ca/parkcalc.

Framework was created using the following technologies:
- Java
- Maven
- Selenium WebDriver
- TestNG
- AssertJ
- PageObjectModel

I'm one of the practitiones mentioned in Martin Fowler's PageObject article (https://martinfowler.com/bliki/PageObject.html) in note #2 
with a slight difference as you may see:

2: Having page objects be responsible for creating other page objects in response to things like navigation is common advice. 
However some practitioners prefer that page objects return some generic browser context, and the tests control which page objects to 
build on top of that context based on the flow of the test (particularly conditional flows). Their preference is based on the fact 
that the test script knows what pages are expected next and this knowledge doesn't need to be duplicated in the page objects themselves. 
They increase their preference when using statically typed languages which usually reveal page navigations in type signatures.



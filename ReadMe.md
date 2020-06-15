# Enterprise FizzBuzz!
Welocme to Enterprise FizzBuzz, this project is not just a simple implementation of FizzBuzz.

## FizzBuzz but different!
Normal FizzBuzz implementations focus on doing the process as efficiently as possible, not this implementation though!

Instead of using boring old if statements or a switch expression, this project does exactly that but takes it a step
 further with a REST interface that does all the normal FizzBuzz work!
 
 This Project was built using Spring Boot as a learning project for implementing a REST interface using Spring inlcuding unit testing a REST interface.   

|EndPoint|Request Type|Notes|
|---|---|---|
|/fizz/#|GET|Returns Fizz if the number is a multiple of 3, or the number itself if it is not|
|/buzz/#|GET|Returns Buzz if the number is a multiple of 5, or the number itself if it is not|
|/#|GET|Returns FizzBuzz status of only the number in the path|
|/fizzbuzz/#|GET|Returns the full FizzBuzz sequence as a String|

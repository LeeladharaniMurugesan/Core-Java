## Funcions

- Function allows us to _group together multiple statements, take in some values, 
   perform some operations and return some value.
   
- Functions take in data known as _arguments.__

- Function may or may not _return_ a value.

- Example:

	```javascript
		Math.max(10, 12); // 12
	```
	
  The above line is a JavaScript statement.

  10 and 12 passed to the function are arguments, separated by comma.
  
  12 is returned from the function.
  
- There are many in-built JavaScript functions.
	e.g:
	
	-  `console.log('hey');` returns `undefined,` logs `hey`
	
     -   `parseFloat('2.032565') // 2.032565 (converts string to number)
     
     -  `parseInt('2.032565') // 2 (converts string to number as integer)
    
      -  Many date functions are also present.
          
             e.g. `Date.now() returns no. of milliseconds since January 1, 1970 00:00:00 UTC.  
                      https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date
  DOM functions:
      Example:
      
      ```html
           <body>
              <p>Hey How ya doin?</p>
              <script>
                const para = document.querySelector('p'); // finds p tag in page
                console.log(para); // <p>Hey How ya doin?</p>
               </script>
               </body>
               
  - Mobile only functions e.g. `navigator.vibrate()`
-  In case of doubts, always refer MDN Docs.
-  Other Examples:

```javascript
      scrollTo(0, 200); // scrolls to (x, y) position in page
      scrollTo({
      top: 500,
      left: 0,
      behavior: 'smooth'
      }); // scrolls to position top: see, Left: 8 in a smooth manner
```
The scrollTo function returns 'undefined".


## Functions - Custom
- Functions are **created/ defined** then they are **called**.
- Defining a function:

    ```javascript
        // Function definition
       function calculateBill() {
      // this is the function body
      console.log('running calculateBill');
      }
- Calling a function:

  javascript
   
		// Function call or run
		Calling a function:
		calculateBill(); // running calculateBill (returns undefined)
		
- Variables created inside a function are not available outside the function. e.g. `total` above.
  It is a **temporary variable.** After running of the function is complete, the variable is cleaned   up or
-                                                                                                    -   **Returning value from function:**

javascript

    function calculateBill() {
    const total 100 1.13;
    return total; // total is returned
    }
     calculateRill() // returns 117 09ROOGOOG
- Capturing returned value from a function into a variable:

  `const myTotal =calculateBill();`(myTotal will have value 112.9999999999)
  
## Functions - arguments and parameters

- Parameters are like _placeholders_ for data that will be passed to a function.
- Arguments are the actual values passed to a function while calling it

   ```javascript
    // here billAmount, taxRate are parameters
    function calculateBill (billAmount, taxRate) {
    console.log(billAmount++ taxRate);
    const total = billAmount + billAmount * taxRate
    return total;
} calculateBill(100, 0.13); // here 199, 8.13 are arguments
```
- ![function definition](https://res.cloudinary.com/geekysrm/image/upload/v1576699296/parameters-arguments.jpg)
- Parameters are variables local to the function; available only inside the function.
- You can also pass variables as arguments during a function call.
- We can also pass _expressions_ as arguments to a function.
```
   `myTotal3 = calculateBill (20+20+30, 0.3);`
```
- So, we can either pass direct value or variables holding value or expressions resulting in a value to a function as arguments.

**Passing functions as arguments:**

```
	
	javascript
	function doctorize(name) { 
	return Dr. ${name};
	}

//We can pass a function inside another
	`yell(doctorize("Jack")); // HEY DR. Jack`
// Above, returned value of doctorize function is passed to yell function
```
- Default values:

```javascript

	function yell (name = "Silly Goose") {
	return 'HEY ${name.toUpperCase()}`;
}
	yell("Jack"); // HEY Jack yell(); // HEY SILLY GOOSE
// Above, if we don't pass any argument to yell function,
// then it takes the default value in function definition, // here Silly Goose, else it takes whatever we pass as argument.
```
**Important gotcha:**

```javascript

	function calculateBill (billAmount, taxRate = 0.13, tipRate = 0.15) { 
	console.log("Running 	Calculate Bill!!");
	const total = billAmount + billAmount taxRate + billAmount * tipRate;
	return total;
	}
	// Suppose above, we want to pass the tipRate but not the taxRate and want taxRate to be default, 	// then the only thing we can do is:
	
	calculateBill (100, undefined, 0.66); // here the taxRate will default to 0.13 as 
	
	// we have passed undefined to it and the tipRate will be 0.66 as passed
```
## Different ways of declaring functions
- Functions are **First class citizens:**
- It means JavaScript functions are values in themselves.
- They can be stored in variables and passed into other functions, 
    just like any other piece of data  in JavaScript.
    
**With function keyword**
_Important: These are **hoisted**, meaning JavaScript 'hoists' or puts them at the top of the file. So if a function is defined with the function keyword, and if we try to run it
before it is defined (above its definition), then there's no error and the function is executed successfully.

```javascript
function doctorize(firstName) {
return Dr. ${firstName};
}
```
- **Anonymous function - function with no name**

  These are used in _callbacks_ and _IIFE: immediately invoked function expressions_.

  ```
  	javascript
  	
    function (firstName) {
     return `Dr. ${firstName}`;
    }


- **Function Expression**
_Important:_ These are **not hoisted**, meaning JavaScript doesn't put them at the top of the file. 
 so if a function is not defined with the function keyword, and if we try to run it  before it is defined ( above its definition), 
then there's an error and the function fails to execute.

  ```
  javascript
  const doctorize = function(firstName) {
    return `Dr. ${firstName}`;
  };
  ```

- **Arrow Functions**

  - Concise, shorter syntax

  - Don't have own scope in refer to 'this' keyword

  - Are anonymous functions

    ```javascript
    const inchToCM = inches => {
      return inches * 2.54;
    };

    // Implicit return: 
    const add = (a, b = 3) => a + b; 
    const inchToCM = (inches) => inches * 2.54;

    // In case of only 1 parameter, we can omit the () around it 
    const inchToCM = inches => inches * 2.54;
    ```

  - Implicitly returning an object:

    ```javascript
    const makeABaby = (first, last) => ({ name: `${first} ${last}`, age: 0 });
    ```

- **IIFE: Immediately Invoked Function Expression**

  ```javascript
  (function(age) {
    return `You are cool and age ${age}`;
  })(10);

  // Parantheses run first in JavaScript, so we have wrapped the function in ().
  // The function immediately runs.
  // The argument passed here is 10 for parameter age.
  ```

- **Methods:**

  - A function which lives inside an object.

  - For e.g `console.log('hey')` : here `log` is the function and `console` is the object.

  - **2 Ways to define methods:**

    ```javascript
    const wes = {
      name: "Westopher Bos",
      // Method! // classical function
      sayHi: function() {
        console.log(`Hey ${this.name}`);
        return "Hey Wes";
      },
      // Arrow function
      wisperHi: () => {
        console.log("hii wesss im a mouse");
      },
      // Short hand Method
      yellHi() {
        console.log("HEY WESSSSS");
      }
    };
    ```

- **Callback functions:** //Event happen

  - Function that is passed to another function used for something that will happen when something is done.

```
HTML:
  <body>
        <button class="clickMe">
          Click Me!
        </button>
   </body>
```
```
     Javascript:
        // Click Callback 
  const button = document.querySelector('.clickMe');

        function handleClick() { console.log('Great Clicking!!'); }

        button.addEventListener('click', handleClick); 
        // everytime we click the button, the handleClick function is run.

        button.addEventListener('click', function() { 
        console.log('Nice Job!!!'); }); 
        // everytime we click the button, the function inside is run. 
        //here used anonymus name there is no name for function

        // Timer Callback 
  setTimeout(() => { console.log('DONE! Time to eat!'); }, 1000); 
  // it runs the console.log after each 1 sec or 1000 milliseconds
```


ctrl +shift+I - elements and console dev tools
ctrl + L to clear

##The SCRIPT element
---

```
The ATTLIST of SCRIPT element
type %ContentType; #REQUIRED --content type of script language-
charset %Charset; #IMPLIED --char encoding of linked resource -- defer (defer) #IMPLIED UA may defer execution of script --
src %URI; #IMPLIED -- URI for an external script --
```
type = content-type [CI]
```
This attribute specifies the scripting language of the element's contents and overrides the default scripting language.
```

Try console.log('Hello') undefined Every time console.log is executed from the console itself, a line saying undefined is appended to the output log. When you run any void function (like console.log) from the console, it also prints out info about the return value, undefined in this case.
• JavaScript is designed as a dynamic language which means that the return type (string, void, boolean ...) of a function's return value is not pre-defined.
o If a function does not use a return statement or an empty return statement with no value, JavaScript automatically returns undefined.
• That means that in JavaScript every function returns something, at least undefined. So the function console.log() in Chrome console either uses non or an empty return statement, so that the return value of this function is undefined. This function return value also gets displayed in the console.
If you're running console.log() from a JS file, this undefined line will not be appended.

This undefined also appears when the following line is written in the console:
```
var name = "venkat";
```
The var statement declares a function-scoped or globally-scoped variable.
Variables declared using var are created before any code is executed in a process known as <b>hoisting.</b> Their initial value is <b>undefined.</b>
```
Running JavaScript:
```
We can run JS on the browser's console by which we will have access to the page we are on.
• Also we can run it in a script tag:
```
<script>console.log('Heyyy');</script>
```
Always try to have your script tag before the closing body tag, because we can access the HTML elements written above the script tag as they are above the JS.
Also, we can run JS in another file using script tag with src attribute:
```
<script src="relative path to js file"></script>
```
```
JS Lessons
```
Pagec.html: external js files
```
- <script> tags must not be empty elements. must have its own closing element Also, we can run JS in another file using 'script` tag with `src` attribute: <script src="./sampleb.js" ></script>
```
```
<b>Illegal: will be ignored <script src="./sampleb.js" />
- and in the following code the console.log() will be ignored <script src="./sampleb.js">
console.log('I will not be executed')
</script>
```
# Disallow Early Use (no-use-before-define)
In JavaScript, prior to ES6, variable and function declarations are hoisted to the top of a scope, so it's possible to use identifiers before their formal declarations in code. This can be confusing and some believe it is best to always declare variables and functions before using them.
In ES6, block-level bindings (let and const) introduce a "temporal dead zone" where a ReferenceError will be thrown with any attempt to access the variable before its declaration.


Some content has been disabled in this document
async defer delay the loading of the js files
url:
```
https://javascript.info/script-async-defer
https://flaviocopes.com/javascript-async-defer/
```
In modern websites, scripts are often "heavier than HTML: their download size is larger, and processing time is also longer.
When the browser loads HTML and comes across a <script>...</script> tag, it can't continue building the DOM.
It must execute the script right now.
The same happens for external scripts <script src="..."></script>:
the browser must wait for the script to download, execute the downloaded script, and only then can it process the rest of the page. 5
5
7
That leads to two important issues:
```
1. Scripts can't see DOM elements below them, so they can't add handlers etc.
2.   If there's a bulky script at the top of the page, it "blocks the page". Users can't see the page content till it downloads and runs:
```
There are some workarounds to that.
For instance, we can put all the scripts at the bottom of the page.
Then it can see elements above it, and it doesn't block the page content from showing: But this solution is far from perfect. For example, the browser notices the script (and can start downloading it) only after it downloaded the full HTML document.
For long HTML documents, there may be a noticeable delay.
Such things are invisible for people using very fast connections, but many people in the world still have slow internet speeds and use a far-from-perfect mobile internet connection.
defer
The defer attribute tells the browser not to wait for the script.
Instead, the browser will continue to process the HTML, build DOM.
The script loads "in the background", and then runs when the DOM is fully built..
In other words:
1. Scripts with defer never block the page.
2. Scripts with defer always execute when the DOM is ready (but before DOMContentLoa
In 36 Col 1
Tab Size: 1
Markdown
Prettier
For long HTML documents, there may be a noticeable delay.
Such things are invisible for people using very fast connections, but many people in the world still have slow internet speeds and use a far-from-perfect mobile internet connection.
defer:
=====
The defer attribute tells the browser not to wait for the script.
Instead, the browser will continue to process the HTML, build DOM.
The script loads "in the background", and then runs when the DOM is fully built..
```
In other words:
1. Scripts with defer never block the page.
2. Scripts with defer always execute when the DOM is ready (but before DOMContentLoa
In 36 Col 1
Tab Size: 1
Markdown
Prettier
```
In other words:
```
1. Scripts with defer attribute will never block the page.
2. Scripts with defer will always execute after the DOM is ready (but before DOMContentLoaded event).
```
```
<p>...content before scripts...</p> <script>
document.addEventListener('DOMContentLoaded', () => alert("DOM ready after defer!"));
</script>
```
```
<script defer
src="https://javascript.info/article/script-async-defer/long.js?speed=1">
</script>
<p>...content after scripts...</p>
```
1. The page content shows up immediately.
2. DOMContentLoaded event handler waits for the deferred script.
It only triggers when the script is downloaded and executed.

Deferred scripts keep their relative order, just like regular scripts.
Let's say, we have two deferred scripts: the long.js and then small.js:
```
<script defer src="https://javascript.info/article/script-async-defer/long.js"></script> <script defer src="https://javascript.info/article/script-async-defer/small.js"></script>
```
Browsers scan the page for scripts and download them in parallel, to improve performance So in the example above both scripts download in parallel. The small.js probably finishes first.
But the defer attribute, besides telling the browser "not to block", ensures that the relative order is kept.

```
<important>
So even though small.js loads first, it still waits and runs after long.js executes. </important>
That may be important for cases when we need to load a JavaScript library and then a script that depends on it.
```
```
<info>
The defer attribute is only for external scripts
The defer attribute is ignored if the /<script> tag has no src.
</info>
```

##async
The async attribute is somewhat like defer.
It also makes the script non-blocking. But it has important differences in the behavior.
The async attribute means that a script is completely independent:
The browser doesn't block on async scripts (like defer).
<b>Other scripts don't wait for async scripts, and async scripts don't wait for them.</b>
DOMContentLoaded and async scripts don't wait for each other:
DOMContentLoaded may happen both
before an async script (if an async script finishes loading after the page is complete) or after an async script (if an async script is short or was in HTTP-cache)
In other words, async scripts load in the background and run when ready.
The DOM and other scripts don't wait for async scripts, and async scripts don't wait for anything.
A fully independent script that runs when loaded. As simple, as it can get, right?.

The DOM and other scripts don't wait for async scripts, and async scripts don't wait for anything.
A fully independent script that runs when loaded. As simple, as it can get.
Here's an example similar to what we've seen with defer: two scripts long.js and small.js, but now with async instead of defer.
They don't wait for each other. Whatever loads first (probably small.js) - runs first:
```
<p>...content before scripts...</p>
<script>
document.addEventListener("DOMContentLoaded', () => alert("DOM ready!"));
</script>
<script async src="https://javascript.info/article/script-async-defer/long.js"></script> <script async src="https://javascript.info/article/script-async-defer/small.js"></script>
<p>...content after scripts...</p>
```
The page content shows up immediately: async doesn't block it. DOMContentLoaded may happen both before and after async, no guarantees here. A smaller script small.js goes second, but probably loads before long.js, so small.js runs first. Although, it might be that long.js loads first, if cached, then it runs first.

In other words, async scripts run in the "load-first" order. Async scripts are great when we integrate an independent third-party script into the page: counters, ads and so on, as they don't depend on our scripts and our script should not wait for them.
<!-- Google Analytics is usually added Like this --> cript async src="https://google-analytics.com/analytics.js"></script>


ement
Semicolons used to end a statement.
You can choose to not to write them (because there is ASI: Automatic Semicolon Insertion in Javascript).
### Declaring a variable:
**var, let, const**
**var first 'John';"**
`let first = 'John';`
`const first = 'John';`
(here value is 'John')
`let` and `const were introduced in ES6 (newer). since 2016 `var` and `let can be updated but not const`.
###Javascript
```
var x = 'hey';
X = 'hi';
let cool = true;
cool = false;
const age = 10;
age = 11; // wrong: throws error
```
- In **strict mode**, define a variable first before assigning a value to it.
***javascript***
dog = 'snickers'; // bad coding, don't do this
console.log(dog); // snickers (no error)

`'use strict';`
dog = 'snickers'; // error: dog is not defined
If we write `var dog; dog is _undefined.
**Scoping:
**var* : _function scoped_ (only available inside parent functions)
**let** and **const**: _block scoped_ (available _inside_ a block denoted by _{}_ )
**Opinion (what to use):*
- Use `const by default;
- if the value of the variable needs to change then use `let`.

**Scoping:**
**var** : _function scoped_ (only available inside parent functions)
**let** and **const**: _block scoped_ (available inside a block denoted by _{}_ )
**Opinion (what to use):'
Use const by default;
- if the value of the variable needs to change then use `let`.
**AVOID `var as far as possible**
'let' was introduced from ES6 - since 2016
- js has been around since 1995
**Variable naming conventions:**
- I Should not start with capital unless they are a class. Must start with **a-z** or **_** or **$**.
- If a variable is multi-word, you can use:
Camel-case: 
- let iLovePizza = true;`
- Upper Camel case (in case of classes): ILovePizza
- Snake case: let i_love_pizza=true;
(underscore) is used by the helper lib called 'lodash (https://lodash.com/)
**Lodash**: A modern JavaScript utility library delivering modularity, performance & extras.

Avoid naming variables as just `-` 
# Disallow Early Use (no-use-before-define)
In JavaScript, prior to ES6, variable and function declarations are hoisted to the top of a scope,
so it's possible to use identifiers before their formal declarations in code. This can be confusing and some believe it is best to always declare variables and functions before using the
In ES6, block-level bindings (let and const) introduce a "temporal dead zone" where a ReferenceError will be thrown with any attempt to access the variable before its declaration.

##Types in Java Script

**BONNUSS**
1. Boolean
2. Object
3. Number - All numbers like integers, decimals, and floats are all one type.
4. Null -
5. Undefined -
6. String
7. Symbol - (new into js) used for assigning unique id . Always gives a guaranteed uniqu
Everything in the above list are Primitive type except Object.
An Object is a special type.
Every thing other than primitive types in js are Objects.

**String**
	. used for holding text		
	. 3 ways to create strings:
1. using single quotes:
const first = 'Soumya';

2. using double quotes:

	`const middle = "Ranjan";`
 .single quotes and double quotes are the same thing.
 
3. using backticks:
```javaScript
	`const last = Mohanty;`
```
used for: "she's cool"
or escaping: 'she\\'s cool'
At the end of the day, Functions, arrays, dates are all just objects

- backticks:
`` javaScript

	const sentence she's so "cool""
	console.log(sentence); // she's so "cool"
``
- Multi-line string:
```javaScript

	const song = 'oh \\
	I like \\
	pizza':

``	
	2nd one using backticks is mostly used.
**String concatenation and interpolation**
- *+* is used for **concatenation**. It is also used for adding 2 nos.
- **Concatenation**: when 2 or more strings combined to one
- **Interpolation**: when you put a variable inside a string 
-  Example 1:

	`const name = 'Soumya";"`

	`const hello= 'Hello my name is + name + Nice to meet you.`

_(can use double or single quotes)__
- Example 2:

	` 1+1 // 2`
	` 1+1 // 11`
	`1 + '1' // 11
- Example 3:
```javascript

	const name = 'Soumya';
	const hello Hello my name is ${name}. Nice to meet you. I am ${100+1} years old. 	console.log	(hello); // Hello my name is Soumya. Nice to meet you. I am 181 years old.
	```
- Backticks also used for _tagged template literals_.

- Backticks are helpful for creating HTML:

```javascript
		const html =
		<div>
			<h2>Hey everyone! I am ${name}.</h2>
			</div>`;
     ```	

/**
 * 
 */
console.log('Hello Leela!');
//Properties defined by getters and setters are known as accessor
//properties to distinguish them from data properties
//that have a simple value.
var myobject = {
	// An ordinary data property
	x: 0,
	// An accessor property defined as a pair of functions
	get data() { return this.x; },
	set data(value) { this.x = value; },
	y: 200
};
myobject.x = 200;
console.log('Data: ' + myobject.data);//Calling to get data
console.log('x: ' + myobject.x);
myobject.data = 100;                  //Calling to set data
console.log('Data:' + myobject.data);//Calling to get data
// a comma is required after the function body (get) to separate the
// method from the next method or data property

// Note the use of the keyword this in the getters and setter above.
// JavaScript invokes these functions as methods of the object on which they are defined,
// which means that within the body of the function "this" refers to the current object.
// So the getter method for the data property can refer to the x property as this.x.
// This object generates strictly increasing serial numbers
var serialnum = {
	// This data property holds the next serial number.
	// The $ in the property name hints that it is a private property. But doesn't work like private field
	$n: 0,//it is a private variable
	// Return the current value and increment it
	get next() { return this.$n++; },
	// Set a new value of n, but only if it is larger than current
	set next(n) {
		if (n >= this.$n) this.$n = n;

		else throw new Error('serial number can only be set to a larger value');
	}
};
serialnum.$n = 100; // will assign value
console.log('$n: ' + serialnum.$n) // will return 100
console.log('next: ' + serialnum.next) // will return 100
serialnum.next = 200;
console.log('next: ' + serialnum.next)
// Class modules
class RegisterNumber {
	#number;//private field # is legal inside JS class but illegal in JS objects
	constructor() {
		this.#number = 1;
	}
	getNumber() { return this.#number; }
	#printToScreen() { return this.#number; } //private method
	callPrint() {
		const x = this.#printToScreen();//call the private method or function within a same class
		return x;
	}
}
const rn = new RegisterNumber();
console.log(`Next Number ${rn.getNumber()}`);
console.log(`Private Number ${rn.callPrint()}`);
//console.log(`Next Number ${rn.#number}`);
//console.log(`Next Number ${rn.#printToScreen()}`);//Calling it from outside the class
var p = {
	// An ordinary data property
	data_y: 0,
	// An accessor property defined as a pair of functions
	get y () { return this.data_y; },
	set y (value) { this.data_y = value; }
  };
  console.log(p);
  const child = Object.create(p);
  child.x = 200;
  child.y =500;
  console.log(child);

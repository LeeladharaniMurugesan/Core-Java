class Pizza{
    // instance property
    #slices = 10 //private field or private variable
    // constructor
    
  constructor (toppings = [], customer) {
    // computer instance property - global fields of pizza
    this.toppings = toppings;//not js object it is a class
    this.customer = customer;
  }
   // static property - Array of Strings
   static extraToppings = ['pepperoni', 'cheese'];
    // static property
  static extraToppings = ['pepperoni', 'cheese'];
  //  static method
  static sayThanyou () {
    console.log('ThankYou!!!')
    }
    //non static method(instance method)
    eat () {
        console.log(this.toppings)
        console.log(this.#slices)
      }
    
    // Getter Property
      get length () {
        return this.#slices
      }
    
      set length (value) {
        this.#slices = value
      }
}
const myPizza = new Pizza(['onions'], 'Leela');
console.log(myPizza.toppings);
console.log(myPizza.customers);
console.log(Pizza.extraToppings);
Pizza.sayThanyou();
myPizza.eat()
myPizza.toppings = ['Carrot', 'Almonds', 'Lobster']
console.log(myPizza.toppings);
console.log(myPizza.length);
console.log(myPizza.slices); //undefined slices
myPizza.length = 8;
console.log(myPizza.length)
myPizza.slices = 240 ; //adding dynamic field slices to myPizza
console.log(myPizza.length);
console.log(myPizza.slices);
/**
 * 
 */
 function Car () { // Functions are objects in JS
    let milesDriven = 0;
    let speed = 0;
    // In this case, we instead use the "this" keyword,
    // which refers to CarModule
    this.accelerate = (velocity, distance) => { //Methods
      speed += velocity;
      milesDriven += distance;
    }
    this.getMilesDriven = () => milesDriven;// Methods
    this.getSpeed = () => speed;//Methods
  }
  class Ecar { //Using class
    // #milesDriven = 0; //private variable
    // #speed = 0;
    constructor() {
      let milesDriven = 0; //private variables  when it is declared in let it can be accessed only with in the scope
      let speed = 0; //private variables
    //this. prefix makes the method public o the class.
      this.accelerate = (velocity, distance) => {
        speed += velocity;
        milesDriven += distance;
      }
  
      this.getMilesDriven = () => milesDriven;
      this.getSpeed = () => speed;
    }
    // accelerate = (velocity, distance) => { //here accelerate donotes function
    //     this.#speed += velocity;
    //     this.#milesDriven += distance;
    //   }
  
    // getMilesDriven = () => this.#milesDriven;
    // getSpeed = () => this.#speed;
  }
  class Bike {
    #milesDriven = 0; //private variable
    #speed = 0; // private variables
    accelerate = (velocity, distance) => { //here accelerate donotes function
        this.#speed += velocity;
        this.#milesDriven += distance;
      }
    getMilesDriven = () => this.#milesDriven;
    getSpeed = () => this.#speed;
}
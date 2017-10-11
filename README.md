_This is an assignment to the class [Programmieren 3](https://hsro-inf-prg3.github.io) at the [University of Applied Sciences Rosenheim](http://www.fh-rosenheim.de)._

# Assignment 3: Inheritance revisited

In this assignment we'll be looking at

* `abstract` classes
* `final` classes
* when to use `abstract` base classes

Given is a class which represents an animal with a lifecycle.
The class is borrowed from a zoo game as you see when you inspect the given methods.
In the following you can see the lifecycle of the animal modeled as [state machine](https://en.wikipedia.org/wiki/Finite-state_machine).

1. it starts in a sleeping state
2. after a certain time it awakes and is hungry
3. if you feed it in time it starts to digest otherwise it's dying
4. again after a certain time it has finished digesting and is getting in a playful mood (now you could `collect()` money)
5. once again after a certain time it's getting tired and goes back to sleep

![state machine](assets/state-machine-spec.svg)

## Setup

1. Create a fork of this repository (button in the right upper corner)
2. Clone the project (you're getting the link by clicking the green _Clone or download_ button)
3. Import the project to your IDE (remember the guide of the first assignment)

## Your work

At first you should try to understand the given implementation of the `tick()` method which is based on a `switch-case`. Your job is to replace the `switch-case` (which is very difficult to understand if you think of the relatively simple state machine) by a clever polymorphism construct.
To get you an idea how this is possible another UML diagram is given.
It models an `abstract` base class `State` which implements the `tick()` method and has an `abstract` method `successor()`.
This method is needed to get the successor state if enough time passed (e.g. the animal has completed digesting and is getting in playful mood).

_Hint: there's still one special case: when the animal was fed it's switching to the **digesting** state immediately no matter how long it was hungry before._

The test suite to ensure that the behavior is still the same is given, too.
That's a classical refactoring situation.
You want to replace an existing implementation by a _better_ one but the behavior shouldn't change.
Now you might get an idea why test cases are important beside the fact that they ensure that you're implementation is working correctly when you do it the first time.

![classes](assets/class-spec.svg)
## Large Class

### Signs and Symptoms

A class contains many fields/methods/lines of code.

### Reasons for the Problem

Classes usually start small. But over time, they get bloated as the program grows.

As is the case with long methods as well, programmers usually find it mentally less taxing to place a new feature in an existing class than to create a new class for the feature.

### Treatment

When a class is wearing too many (functional) hats, think about splitting it up:

* Extract Class helps if part of the behaviour of the large class can be spun off into a separate component.
* Extract Subclass helps if part of the behaviour of the large class can be implemented in different ways or is used in rare cases.
* Extract Interface helps if it is necessary to have a list of the operations and behaviour that the client can use.
* If a large class is responsible for the graphical interface, you may try to move some of its data and behaviour to a separate domain object. In doing so, it may be necessary to store copies of some data in two places and keep the data consistent. Duplicate Observed Data offers a way to do this.

### Payoff

* Refactoring of these classes spares developers from needing to remember a large number of attributes for a class.
* In many cases, splitting large classes into parts avoids duplication of code and functionality

# Long Methods

### Signs and Symptoms

A class contains many fields/methods/lines of code.

###Reasons for the Problem

Classes usually start small. But over time, they get bloated as the program grows.
As is the case with long methods as well, programmers usually find it mentally less taxing to place a new feature in an existing class than to create a new class for the feature.

### Treatment

When a class is wearing too many (functional) hats, think about splitting it up:

* Extract Class helps if part of the behaviour of the large class can be spun off into a separate component.
* Extract Subclass helps if part of the behaviour of the large class can be implemented in different ways or is used in rare cases.
* Extract Interface helps if it is necessary to have a list of the operations and behaviours that the client can use.
* If a large class is responsible for the graphical interface, you may try to move some of its data and behaviour to a separate domain object. In doing so, it may be necessary to store copies of some data in two places and keep the data consistent. Duplicate Observed Data offers a way to do this.

### Payoff

* Refactoring of these classes spares developers from needing to remember a large number of attributes for a class.
* In many cases, splitting large classes into parts avoids duplication of code and functionality.

# Duplicate Code

### Signs and Symptoms
Two code fragments look almost identical.


### Reasons for the Problem
Duplication usually occurs when multiple programmers are working on different parts of the same program at the same time. Since they are working on different tasks, they may be unaware their colleague has already written similar code that could be repurposed for their own needs.

There is also more subtle duplication, when specific parts of code look different but actually perform the same job. This kind of duplication can be hard to find and fix.

Sometimes duplication is purposeful. When rushing to meet deadlines and the existing code is "almost right" for the job, novice programmers may not be able to resist the temptation of copying and pasting the relevant code. And in some cases, the programmer is simply too lazy to de-clutter.

### Treatment
If the same code is found in two or more methods in the same class: use Extract Method and place calls for the new method in both places.

* If the same code is found in two subclasses of the same level:
	* Use Extract Method for both classes, followed by Pull Up Field for the fields used in the method that you are pulling up.
	* If the duplicate code is inside a constructor, use Pull Up Constructor Body.
	* If the duplicate code is similar but not completely identical, use Form Template Method.
	* If two methods do the same thing but use different algorithms, select the best algorithm and apply Substitute Algorithm.
* If duplicate code is found in two different classes:
	* If the classes are not part of a hierarchy, use Extract Superclass in order to create a single superclass for these classes that maintains all the previous functionality.
	* If it is difficult or impossible to create a superclass, use Extract Class in one class and use the new component in the other.
	* If a large number of conditional expressions are present and perform the same code (differing only in their conditions), merge these operators into a single condition using Consolidate Conditional Expression and use Extract Method to place the condition in a separate method with an easy-to-understand name.
* If the same code is performed in all branches of a conditional expression: place the identical code outside of the condition tree by using Consolidate Duplicate Conditional Fragments.

### Payoff
* Merging duplicate code simplifies the structure of your code and makes it shorter.
* Simplification + shortness = code that is easier to simplify and cheaper to support.

### When to Ignore
In very rare cases, merging two identical fragments of code can make the code less intuitive and obvious.

# Speculative Generality

### Signs and Symptoms
There is an unused class, method, field or parameter.

### Reasons for the Problem
Sometimes code is created "just in case" to support anticipated future features that never get implemented. As a result, code becomes hard to understand and support.

### Treatment
For removing unused abstract classes, try Collapse Hierarchy.
* Unnecessary delegation of functionality to another class can be eliminated via Inline Class.
* Unused methods? Use Inline Method to get rid of them.
* Methods with unused parameters should be given a look with the help of Remove Parameter.
* Unused fields can be simply deleted.
### Payoff
* Slimmer code.
* Easier support.

### When to Ignore

* If you are working on a framework, it is eminently reasonable to create functionality not used in the framework itself, as long as the functionality is needed by the frameworks's users.
* Before deleting elements, make sure that they are not used in unit tests. This happens if tests need a way to get certain internal information from a class or perform special testing-related actions.

# Comments

### Signs and Symptoms
A method is filled with explanatory comments.


### Reasons for the Problem
Comments are usually created with the best of intentions, when the author realizes that his or her code is not intuitive or obvious. In such cases, comments are like a deodorant masking the smell of fishy code that could be improved.

The best comment is a good name for a method or class.

If you feel that a code fragment cannot be understood without comments, try to change the code structure in a way that makes comments unnecessary.

### Treatment
* If a comment is intended to explain a complex expression, the expression should be split into understandable subexpressions using Extract Variable.
* If a comment explains a section of code, this section can be turned into a separate method via Extract Method. The name of the new method can be taken from the comment text itself, most likely.
* If a method has already been extracted, but comments are still necessary to explain what the method does, give the method a self-explanatory name. Use Rename Method for this.
* If you need to assert rules about a state that is necessary for the system to work, use Introduce Assertion.
### Payoff
Code becomes more intuitive and obvious.

### When to Ignore
Comments can sometimes be useful:
* When explaining why something is being implemented in a particular way.
* When explaining complex algorithms (when all other methods for simplifying the algorithm have been tried and come up short).


# Nested conditionals

### Signs and Symptoms
You have a group of nested conditionals and it is hard to determine the normal flow of code execution.

### Treatment
* Decompose Conditional
	* Problem: You have a complex conditional (if-then/else or switch).
	* Solution: Decompose the complicated parts of the conditional into separate methods: the condition, then and else.
* Consolidate Conditional Expression
	* Problem: You have multiple conditionals that lead to the same result or action.
	* Solution: Consolidate all these conditionals in a single expression.
* Consolidate Duplicate Conditional Fragments
	*	Problem: Identical code can be found in all branches of a conditional.
	* Solution: Move the code outside of the conditional.
* Remove Control Flag
	* Problem: You have a boolean variable that acts as a control flag for multiple boolean expressions.
	* Solution: Instead of the variable, use break, continue and return.
* Replace Nested Conditional with Guard Clauses
	* Problem: You have a group of nested conditionals and it is hard to determine the normal flow of code execution.
	* Solution: Isolate all special checks and edge cases into separate clauses and place them before the main checks. Ideally, you should have a "flat" list of conditionals, one after the other.
* Replace Conditional with Polymorphism
	* Problem: You have a conditional that performs various actions depending on object type or properties.
	* Solution: Create subclasses matching the branches of the conditional. In them, create a shared method and move code from the corresponding branch of the conditional to it. Then replace the conditional with the relevant method call. The result is that the proper implementation will be attained via polymorphism depending on the object class.
* Introduce Null Object
	* Problem: Since some methods return null instead of real objects, you have many checks for null in your code.
	* Solution: Instead of null, return a null object that exhibits the default behavior.
* Introduce Assertion
	* Problem: For a portion of code to work correctly, certain conditions or values must be true.
	* Solution: Replace these assumptions with specific assertion checks.
Payoff
* By extracting conditional code to clearly named methods, you make life easier for the person who will be maintaining the code later (such as you, two months from now!).
* By consolidating all operators, you can now isolate this complex expression in a new method with a name that explains the conditional's purpose.
 * Eliminates duplicate control flow code. Combining multiple conditionals that have the same "destination" helps to show that you are doing only one complicated check leading to one action.

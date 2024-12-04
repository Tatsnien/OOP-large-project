# POLYMORPHISM IN SYSTEM:
## Personnel
![Java screenshot of Personnel and subclasses]

![Java screenshot of Login interface]

This interface is used as a way for members of Personnel class login. Despite the parameter being of Personnel type, objects of classes Staff, Manager and Cashier can be passed. Staff implements Personnel, whereas Manager and Cashier classes extend from Staff/are subtypes of staff. (May have to fix later. Staff and Personnel should be class and abstract respectively?)

Within the Staff class, there is a method that calls for a report. The Report class calls for a list of items (or objects of type Item). Within the Report class there exists an attribute of itemList, which is of type List<Item>. This is an example of parametric polymorphism; in Java, they are called Generics.
(picture of Report class with placeholder)
![Java screenshot of Report class]

## Item
Classes `Toy`, `Stationery` and `Book` are made subtypes of subclass `Item`. A class not featured here, DataRepository, also have both attributes and methods that pass objects of classes `Personnel` and `Item`. As such, parametric polymorphism is present.
![UML screenshot of DataRepository]

Various constructors are written for the `Item` class. For example, someone wants to add a new `Item`, but have yet to decide on its price. Assume that only the title attribute has a value. Two solutions exist: either overload the constructor with only `String title` as a parameter (and `int ID` for internal use), or pass every other parameter within the complete constructor as `null`, which risks triggering a `NullPointerException`.

## Cart
Further examples of passing generics of class Item exist. Method overloading is also present as well, wherein you can add one or multiple of items into the cart. The method `addToCart(**TODO**)` can pass a singular Item object or an ArrayList<Item>. In a test file, where both `addToCart(Item item)` and `addToCart(ArrayList<Item>)` are called, the compiler will choose the appropriate overloaded method. Since this choice is made during compilation, it is called compile-time polymorphism.
![screenshot of Cart class]

## Make Payment
Runtime polymorphism 

## Subtyping
More examples of subtyping exist within the project, as inheritance and polymorphism are closely connected concepts in OO programming. However, the ones listed here are not significant enough to merit its own section. Classes `RecurringExpense` (building maintenance costs, utility bills), `SalaryExpense` (employee salaries) and `OtherExpense` (other expenses not factored in, i.e. property damage). The classes `AddtionFreeDiscount`, `PercentageDiscount` and `GiftDiscount` are made subtypes of class `Discount`.
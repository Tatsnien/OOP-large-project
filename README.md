# Management System for HUST Book Stores

# What's New (08.01.2025)
After all of struggles and efforts, our journey has come to an end. This post is dedicated for
listing the unfinished works:

* Director Expense screen
* Manager Expense (controller) screen
* Salary calculation
* DAO
* Report
* Class Diagram UML

# What's New (02.01.2025)
**HAPPY NEW YEAR'S MASSIVE CHANGEEEEE**

Exhaustive, massive change has been made for StoreEntity-related classes after lecturer's comment.
In short, StoreEntity class -> IStoreEntity interface and StoreChain will
be implemented at the LogInScreen. Personnel can only access those entities through Service. 
This change will solve the bottleneck of singleton (which I think is a taboo in OOP conventions),
while perfectly ensure the polymorphism.

Finished screens:
* All Home and Profile screens
* Cashier Work screen
* Director View Branches (WorkBranch) screen
* Director View Employees (WorkPersonnel) screen
* Manager View Employees (WorkPersonnel) screen
* Navigation for Cahier, Director and Manager 

Unfinished works:
* Director Item and Expense screen
* Manager Item and Expense (controller) screen
* Staff Item screen
* Salary calculation
* DAO

Removed classes:
* Customer-related classes

Renamed classes:
* "_ManagementService" -> "_Service"

New classes: \
*I hate to do this, but I think this change is unavoidable.*
* **Employee**: extends from "Personnel". Has workingBranchNumber attribute.
StoreBranchManager, Staff, Cashier are now children of this class.
* **DAO** \[Unfinished\]: include all kind of importing and exporting from txt file.
Currently have branch and personnel infomation. Located in resources folder.

Considering changes:
* Remove StoreBranchDAO: This class is a testing-unfriendly black box so I will remove it
in the future.

# What's New (18.12.2024)
Since I just realized the requirement is "Management System for HUST Book Stores", not just "Book Store".
So I made some updates to the UML:
* Rename "**interface**" package to "**system**" to avoid conflict.
* Move "**Personnel**" class and its children to "**personnel**" package.
* Change all List to ArrayList.

Removed classes:
* Remove "**Income**" class.
* Remove "**StoreInformation**" class

Renamed classes:
* Lowercase all package names to match the convention
* "Personnel" -> "Employee": Personnel is a plural noun, therefore it cannot be used to refer an individual suchs as staff or manager.
* "Interface" -> "System"
* "StoreBranchManager" -> "Manager"
* "DataRepositoryManagerService" -> "StoreBranchManagerService"
* "DataRepository" -> "StoreEntity"

New classes:
* **StoreChain**: get information of all stores.
* **StoreBranch**: get information of specific store branch.
* **StoreBranchDAO**: communicate with external files to retrieve and store branchs' information.
* **Director**: the one who manage all stores \
... \
The "system" package is now in a mess so I will update it later.

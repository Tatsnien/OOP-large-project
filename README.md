# Management System for HUST Book Stores

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

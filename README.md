# Management System for HUST Book Stores

# What's New (17.12.2024)
Some updates to the UML:
* Change all package names to lowercase to match the convention.
* Rename "**interface**" package to "**system**" to avoid conflict.
* Rename "**Interface**" class to "**System**"
* Move "**Personnel**" class and its children to "**personnel**" package.
* Modify the "**StoreInformation**" class: now it contains the store branch information since I just realized the requirement is "Management System for HUST Book Stores", not just "Book Store".
* Create "**StoreInformationService**" class.

# Future updates

* New classes: \
**Director**: who manage the whole book store chain \
**DataRepositoryDirectorService**: Data-related services for the director

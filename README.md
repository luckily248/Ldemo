# Ldemo
1. User to Role is many-to-one
1. Role to Permissions is  one-to-many
1. Permissions to WebPage is many-to-many
1. So WebPage_Permissions table is necessary 
1. IRABC is the interface for all desired functions
1. RABC is the memory layer implementation and holds all the data
1. Assign Role will build the connection between User and Role
1. Assign Permission will create new Permission with the Role and associate WebPage and Permissions.
1. Unit testings are using JUnit and the instruction provided in the attached screenshots.
1. Integrated test in MainActivity and result in attached screenshots.

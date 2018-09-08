conn = new Mongo();
db = conn.getDB("userservicedb");
db.getCollectionNames().forEach(function(c) { if (c.indexOf("system.") == -1) db[c].drop(); });
db.createCollection("Role");
db.createCollection("Users");

var roles = 
[
	{
	    "_id" : ObjectId("546f7ba5ce248eba4487eda5"),
	    "_class" : "org.mdeforge.business.model.Role",
	    "name" : "ROLE_USER"
	},
	{
	    "_id" : ObjectId("546f7ba5ce248eba4487eda6"),
	    "_class" : "org.mdeforge.business.model.Role",
	    "name" : "user"
	}
];

var users = 
[
	{
	    "_id" : ObjectId("55ae5947d4c677485a267bca"),
	    "_class" : "org.mdeforge.business.model.User",
	    "firstname" : "Francesco",
	    "lastname" : "Basciani",
	    "email" : "francesco.basciani@graduate.univaq.it ",
	    "username" : "francesco",
	    "password" : "$2a$10$vZICCUpPcecd/UYwHfDhU.3AUP90GOsbmUVsleIdkt7eOX4/tIYnW",
	    "roles" : [ 
	        {
	            "$ref" : "Role",
	            "$id" : ObjectId("546f7ba5ce248eba4487eda5")
	        }
	    ],
	    "owner" : [],
	    "enabled" : true,
	    "sharedProject" : [],
	    "sharedArtifact" : [],
	    "workspaces" : []
	},
	{
	    "_id" : ObjectId("5514b943d4c6c379396fe8b7"),
	    "_class" : "org.mdeforge.business.model.User",
	    "firstname" : "Juri",
	    "lastname" : "Di Rocco",
	    "email" : "juri.dirocco@univaq.it ",
	    "username" : "Admin",
	    "password" : "$2a$10$vZICCUpPcecd/UYwHfDhU.3AUP90GOsbmUVsleIdkt7eOX4/tIYnW",
	    "roles" : [ 
	        {
	            "$ref" : "Role",
	            "$id" : ObjectId("546f7ba5ce248eba4487eda5")
	        }
	    ],
	    "owner" : [],
	    "enabled" : true,
	    "sharedProject" : [],
	    "sharedArtifact" : [],
	    "workspaces" : []
	}
];

db.Role.insert(roles);
db.Users.insert(users);

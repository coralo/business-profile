package repositories

import models.User
import org.bson.types.ObjectId
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.dao.BasicDAO

class UserRepository(dataStore: Datastore) : BasicDAO<User, ObjectId>(dataStore)

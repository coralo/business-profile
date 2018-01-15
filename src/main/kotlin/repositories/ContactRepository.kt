package repositories

import models.Contact
import org.bson.types.ObjectId
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.dao.BasicDAO

class ContactRepository(dataStore: Datastore) : BasicDAO<Contact, ObjectId>(dataStore)

package repositories

import org.mongodb.morphia.Datastore

class Repositories(dataStore: Datastore) {
    val userRepository = UserRepository(dataStore)
    val contactRepository = ContactRepository(dataStore)
}

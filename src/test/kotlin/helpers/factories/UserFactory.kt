package helpers.factories

import models.Contact
import models.ContactType
import models.User

class UserFactory : BaseFactory() {
    fun createUser(email: String, password: String) : User {
        val user = User()
        user.firstName = faker.name().firstName()
        user.lastName = faker.name().lastName()
        user.password = password

        dataStore.save(user)
        val contact = Contact(email, type = ContactType.EMAIL, user = user)
        dataStore.save(contact)
        user.contacts = listOf(contact)
        dataStore.update(user, dataStore.createUpdateOperations(User::class.java))
        return user
    }
}

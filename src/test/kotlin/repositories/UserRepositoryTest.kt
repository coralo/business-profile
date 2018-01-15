package repositories

import com.github.javafaker.Faker
import helpers.BasePersistenceTest
import models.Contact
import models.ContactType
import models.User
import org.junit.Assert
import org.junit.Test

class UserRepositoryTest : BasePersistenceTest() {
    @Test
    fun addNewUserTest() {
        val faker = Faker()
        val userRepository = UserRepository(dataStore)
        val contactRepository = ContactRepository(dataStore)
        val user = User()
        user.firstName = faker.name().firstName()
        user.lastName = faker.name().lastName()
        user.password = "password"
        val contact = Contact(faker.internet().emailAddress(), type = ContactType.EMAIL, user = user)
        contactRepository.save(contact)
        user.contacts = listOf(contact)
        userRepository.save(user)

        val actualUser = userRepository.findOne("id", user.id)
        Assert.assertEquals(user.firstName, actualUser.firstName)
        Assert.assertEquals(user.lastName, actualUser.lastName)
        Assert.assertEquals(user.contacts.first().contact, contact.contact)
    }
}

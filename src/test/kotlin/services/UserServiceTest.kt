package services

import auth.LoginInput
import exceptions.InvalidLoginException
import org.junit.Assert
import helpers.BasePersistenceTest
import helpers.factories.UserFactory
import org.junit.Test

import repositories.ContactRepository
import repositories.UserRepository

class UserServiceTest : BasePersistenceTest() {
    private val userRepository = UserRepository(dataStore)
    private val contactRepository = ContactRepository(dataStore)
    private val userService = UserService(userRepository, contactRepository)

    @Test
    fun testLoginWithCorrectPassword() {
        val userFactory = UserFactory()
        val email = "658655@gmail.com"
        val password = "password"
        val user = userFactory.createUser(email, password)
        val loginOutput = userService.login(LoginInput(email, password))
        Assert.assertNotNull(loginOutput.token)
        Assert.assertNotNull(loginOutput.user)
        Assert.assertEquals(loginOutput.user?.id, user.id)

        try {
            userService.login(LoginInput(email, "wrong@password"))
        } catch (exception: InvalidLoginException) {}
    }

}

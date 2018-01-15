package models

import com.github.javafaker.Faker
import helpers.BasePersistenceTest
import org.junit.Assert
import org.junit.Test
import org.mindrot.jbcrypt.BCrypt

class UserTest : BasePersistenceTest() {
    @Test
    fun testUserModel() {
        val faker = Faker()
        val firstName = faker.name().firstName()
        val lastName = faker.name().lastName()
        val password = "password"

        val user = User()
        user.firstName = firstName
        user.lastName = lastName
        user.password = password

        Assert.assertEquals(user.firstName, firstName)
        Assert.assertEquals(user.lastName, lastName)
        Assert.assertNotEquals(user.password, password)
        Assert.assertTrue(BCrypt.checkpw(password, user.password))
    }
}

import models.User
import org.junit.Assert
import org.junit.Test

class UserTest : BasePersistenceTest() {
    @Test
    fun testUserModel() {
        val user = User()
        user.firstName = "Hieu"
        user.lastName = "Tran"
        user.password = "password"

        Assert.assertEquals(user.firstName, "Hieu")
        Assert.assertEquals(user.lastName, "Tran")
        Assert.assertNull(user.password)
    }
}

package models.inout

import auth.LoginInput
import org.junit.Assert
import org.junit.Test

class LoginInputTest {
    @Test
    fun testLogin() {
        val login = LoginInput("Hieu", "password")
        Assert.assertEquals(login.account, "Hieu")
        Assert.assertEquals(login.password, "password")
    }
}

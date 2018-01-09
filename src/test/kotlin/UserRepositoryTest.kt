import org.junit.Assert
import org.junit.Test
import repositories.UserRepository

class UserRepositoryTest : BasePersistenceTest() {
    @Test
    fun firstTest() {
        val userRepository = UserRepository(dataStore)
        Assert.assertEquals("no user", 0, userRepository.count())
    }
}

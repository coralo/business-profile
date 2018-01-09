import com.mongodb.MongoClient
import org.junit.Before
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia

abstract class BasePersistenceTest {
    private val morphia = Morphia()
    private val mongoClient = MongoClient()
    val dataStore: Datastore = morphia.createDatastore(mongoClient, "business_profile_test")

    @Before
    fun setUp() {
        dataStore.ensureIndexes()
    }

    fun tearDown() {
        mongoClient.close()
    }
}

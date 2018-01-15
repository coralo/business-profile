package helpers.factories

import com.github.javafaker.Faker
import com.mongodb.MongoClient
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia

abstract class BaseFactory {
    private val morphia = Morphia()
    private val mongoClient = MongoClient()
    val dataStore: Datastore = morphia.createDatastore(mongoClient, "business_profile_test")
    val faker = Faker()
}

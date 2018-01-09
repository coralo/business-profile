package models

import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.Id
import org.mongodb.morphia.annotations.Property
import org.mongodb.morphia.annotations.Version

abstract class BaseEntity {
    @Id
    @Property("id")
    var id: ObjectId? = null

    @Version
    @Property("version")
    var version: Long? = null
}

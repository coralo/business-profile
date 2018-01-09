package models

import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Reference

@Entity
class User: BaseEntity() {
    var firstName: String? = null
    var lastName: String? = null
    var password: String? = null
        get() = null
        set(value) {
            field = value + "hashed"
        }

    @Reference
    var contacts: List<Contact> = ArrayList()
}

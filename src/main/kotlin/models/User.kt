package models

import org.mindrot.jbcrypt.BCrypt
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Reference

@Entity
class User: BaseEntity() {
    var firstName: String? = null
    var lastName: String? = null
    var password: String? = null
        set(value) {
            field = BCrypt.hashpw(value, BCrypt.gensalt())
        }

    @Reference
    var contacts: List<Contact> = ArrayList()
}

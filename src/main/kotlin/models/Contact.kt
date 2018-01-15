package models

import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Reference

@Entity
data class Contact(
    var contact: String? = null,
    var type: ContactType? = null,

    @Reference
    var user: User? = null
): BaseEntity()

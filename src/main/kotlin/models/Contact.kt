package models

import org.mongodb.morphia.annotations.Entity

@Entity
class Contact: BaseEntity() {
    var contact: String? = null
    var type: ContactType? = null
}

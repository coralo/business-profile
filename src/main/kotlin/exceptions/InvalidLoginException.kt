package exceptions

class InvalidLoginException(val field: String, val error: String) : RuntimeException()

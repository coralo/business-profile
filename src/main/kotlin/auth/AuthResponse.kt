package auth

import models.User

class AuthResponse(val token: String, val user: User?)

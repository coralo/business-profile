package auth

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import models.User

class AuthMutations : GraphQLMutationResolver {
    fun login(account: String, password: String) : AuthResponse {
        val token = account + "|" + password
        return AuthResponse(token, User())
    }
}

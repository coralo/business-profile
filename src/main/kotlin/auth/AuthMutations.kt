package auth

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import common.Context
import graphql.schema.DataFetchingEnvironment

class AuthMutations : GraphQLMutationResolver {
    fun login(account: String, password: String, env: DataFetchingEnvironment) : AuthResponse {
        val context = env.getContext<Context>()
        return context.services.userService.login(LoginInput(account, password))
    }
}

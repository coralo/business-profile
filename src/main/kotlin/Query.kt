import com.coxautodev.graphql.tools.GraphQLQueryResolver

class Query : GraphQLQueryResolver {
    fun user() : User {
        return User("Hieu", "Tran Duc")
    }
}
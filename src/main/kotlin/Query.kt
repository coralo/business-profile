import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment

class Query : GraphQLQueryResolver {
    fun user(env: DataFetchingEnvironment) : User {
        val context = env.getContext<Context>()

        return context.currentUser
    }
}

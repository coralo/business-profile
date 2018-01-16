import com.coxautodev.graphql.tools.GraphQLQueryResolver
import common.Context
import graphql.schema.DataFetchingEnvironment
import models.User

class Query : GraphQLQueryResolver {
    fun user(env: DataFetchingEnvironment): User? {
        val context = env.getContext<Context>()
        return context.currentUser
    }
}

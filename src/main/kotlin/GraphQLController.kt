import auth.AuthMutations
import com.coxautodev.graphql.tools.SchemaParser
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import graphql.servlet.GraphQLContext
import graphql.servlet.SimpleGraphQLServlet
import java.util.Optional
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/graphql")
class GraphQLController: SimpleGraphQLServlet(SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(
                Query(),
                AuthMutations()
        )
        .build()
        .makeExecutableSchema()) {
    override fun createContext(request: Optional<HttpServletRequest>?, response: Optional<HttpServletResponse>?)
        : GraphQLContext {
//        val mongo: MongoDatabase = MongoClient().getDatabase("business_profile")
        val user = User("Hieu", "Tran Duc")
        return Context(user, request, response)
    }
}

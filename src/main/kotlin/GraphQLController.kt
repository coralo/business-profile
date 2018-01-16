import auth.AuthMutations
import com.coxautodev.graphql.tools.SchemaParser
import com.mongodb.MongoClient
import common.Context
import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLErrorHandler
import graphql.servlet.SimpleGraphQLServlet
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia
import repositories.Repositories
import services.Services
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
        val morphia = Morphia()
        val mongoClient = MongoClient()
        val dataStore: Datastore = morphia.createDatastore(mongoClient, "business_profile")
        val repositories = Repositories(dataStore)
        val services = Services(repositories)
        return Context(null, repositories, services, request, response)
    }
}

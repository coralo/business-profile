import com.coxautodev.graphql.tools.SchemaParser
import graphql.servlet.SimpleGraphQLServlet
import javax.servlet.annotation.WebServlet

@WebServlet("/graphql")
class GraphQLController: SimpleGraphQLServlet(SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(
                Query()
        )
        .build()
        .makeExecutableSchema())
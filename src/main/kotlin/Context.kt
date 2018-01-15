import graphql.servlet.GraphQLContext
import repositories.Repositories
import services.Services
import java.util.Optional
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Context(
    val currentUser: User?,
    val repositories: Repositories,
    services: Services,
    request: Optional<HttpServletRequest>?,
    response: Optional<HttpServletResponse>?
) : GraphQLContext(request, response)

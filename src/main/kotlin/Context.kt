import graphql.servlet.GraphQLContext
import java.util.Optional
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Context(val currentUser: User, request: Optional<HttpServletRequest>?, response: Optional<HttpServletResponse>?)
    : GraphQLContext(request, response)

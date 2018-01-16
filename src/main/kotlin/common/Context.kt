package common

import graphql.servlet.GraphQLContext
import models.User
import repositories.Repositories
import services.Services
import java.util.Optional
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Context(
    val currentUser: User?,
    val repositories: Repositories,
    val services: Services,
    request: Optional<HttpServletRequest>?,
    response: Optional<HttpServletResponse>?
) : GraphQLContext(request, response)

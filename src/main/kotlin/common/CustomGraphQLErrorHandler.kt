package common

import graphql.ExceptionWhileDataFetching
import graphql.GraphQLError
import graphql.servlet.DefaultGraphQLErrorHandler
import java.util.stream.Collectors

class CustomGraphQLErrorHandler: DefaultGraphQLErrorHandler() {
    override fun filterGraphQLErrors(errors: MutableList<GraphQLError>): MutableList<GraphQLError> {
        return errors.stream()
            .filter { e -> e is ExceptionWhileDataFetching || isClientError(e) }
            .map { e -> if (e is ExceptionWhileDataFetching) SanitizedError(e) else e }
            .collect(Collectors.toList())
    }
}

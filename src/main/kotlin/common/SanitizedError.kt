package common

import com.fasterxml.jackson.annotation.JsonIgnore
import graphql.ExceptionWhileDataFetching
import graphql.execution.ExecutionPath
import graphql.language.SourceLocation

class SanitizedError(inner: ExceptionWhileDataFetching) : ExceptionWhileDataFetching(
    ExecutionPath.fromList(inner.path), inner.exception, inner.locations[0]
) {
    @JsonIgnore
    override fun getPath(): MutableList<Any> {
        return super.getPath()
    }

    @JsonIgnore
    override fun getException(): Throwable {
        return super.getException()
    }

    @JsonIgnore
    override fun getLocations(): MutableList<SourceLocation> {
        return super.getLocations()
    }

    @JsonIgnore
    override fun getExtensions(): MutableMap<String, Any> {
        return super.getExtensions()
    }
}

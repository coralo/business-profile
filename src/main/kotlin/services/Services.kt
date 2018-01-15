package services

import repositories.Repositories


class Services(repositories: Repositories) {
    val userService = UserService(repositories)
}

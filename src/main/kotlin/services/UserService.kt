package services

import auth.AuthResponse
import auth.LoginInput
import exceptions.InvalidLoginException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.mindrot.jbcrypt.BCrypt
import repositories.ContactRepository
import repositories.UserRepository
import java.util.*

class UserService(val userRepository: UserRepository, val contactRepository: ContactRepository) {
    fun login(login: LoginInput): AuthResponse {
        val contact = contactRepository.findOne("contact", login.account)
        if (contact.user == null) {
            throw InvalidLoginException("contact", "unknown user")
        }
        if (!BCrypt.checkpw(login.password, contact.user?.password)) {
            throw InvalidLoginException("password", "wrong password")
        }
        val token = Jwts.builder()
            .setIssuedAt(Date())
            .setSubject(contact.user?.id.toString())
            .setIssuer("issuer")
            .setExpiration(Date(System.currentTimeMillis() + 10 * 24 * 60 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS256, "secretKey").compact()
        return AuthResponse(token, contact.user)
    }
}

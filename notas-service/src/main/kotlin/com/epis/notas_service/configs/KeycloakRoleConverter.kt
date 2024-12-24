package de.keycloak.backend.configs

import org.springframework.core.convert.converter.Converter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt

class KeycloakRoleConverter : Converter<Jwt, Collection<GrantedAuthority>> {
    override fun convert(jwt: Jwt): Collection<GrantedAuthority> {
        val claims = jwt.claims

        val resourceAccess = claims["resource_access"] as? Map<String, Map<String, List<String>>>
            ?: emptyMap()

        val backendRoles = resourceAccess["backend"] ?: emptyMap()

        val roles = backendRoles["roles"] ?: emptyList()

        return roles.map { role -> SimpleGrantedAuthority("ROLE_$role") }
    }
}

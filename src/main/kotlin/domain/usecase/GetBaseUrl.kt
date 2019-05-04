package fr.antoinechalifour.shrtn.domain.usecase

import fr.antoinechalifour.shrtn.AppConfig
import fr.antoinechalifour.shrtn.domain.helpers.getShortUrl
import fr.antoinechalifour.shrtn.domain.model.Link
import fr.antoinechalifour.shrtn.domain.repository.LinkRepository
import io.javalin.NotFoundResponse

class GetBaseUrl(private val linkRepository: LinkRepository, private val config: AppConfig) {
    operator fun invoke(id: String): Link {
        val shortUrl = getShortUrl(
            protocol = config.protocol,
            host = config.host,
            port = config.port,
            shortUrl = id
        )

        val link = linkRepository.findByShortUrl(shortUrl)

        return link ?: throw NotFoundResponse("Link $id was not found")
    }
}
package fr.antoinechalifour.shrtn.domain.usecase

import fr.antoinechalifour.shrtn.AppConfig
import fr.antoinechalifour.shrtn.domain.helpers.getShortUrl
import fr.antoinechalifour.shrtn.domain.model.Link
import fr.antoinechalifour.shrtn.domain.repository.LinkRepository
import java.util.*

class ShortenUrl(private val linkRepository: LinkRepository, private val config: AppConfig) {
    operator fun invoke(url: String): Link {
        val linkShortId = UUID.randomUUID().toString()
        val shortUrl = getShortUrl(
            protocol = config.protocol,
            port = config.port,
            host = config.host,
            shortUrl = linkShortId
        )
        val link = Link(url, shortUrl)

        linkRepository.persist(link)

        return link
    }
}
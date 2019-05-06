package domain.usecase

import config.AppConfig
import domain.helpers.getShortUrl
import domain.model.Link
import domain.repository.LinkRepository
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
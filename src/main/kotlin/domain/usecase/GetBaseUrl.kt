package domain.usecase

import config.AppConfig
import domain.helpers.getShortUrl
import domain.model.Link
import domain.repository.LinkRepository
import io.javalin.NotFoundResponse

class GetBaseUrl(private val linkRepository: LinkRepository, private val config: AppConfig) {
    operator fun invoke(id: String): Link {
        val shortUrl = getShortUrl(
            protocol = config.protocol,
            host = config.host,
            shortUrl = id
        )

        val link = linkRepository.findByShortUrl(shortUrl)

        return link ?: throw NotFoundResponse("Link $id was not found")
    }
}
package domain.repository

import domain.model.Link

interface LinkRepository {
    fun persist(link: Link)
    fun findByShortUrl(shortUrl: String): Link?
}
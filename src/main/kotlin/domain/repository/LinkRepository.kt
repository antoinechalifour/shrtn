package fr.antoinechalifour.shrtn.domain.repository

import fr.antoinechalifour.shrtn.domain.model.Link

interface LinkRepository {
    fun persist(link: Link)
    fun findByShortUrl(shortUrl: String): Link?
}
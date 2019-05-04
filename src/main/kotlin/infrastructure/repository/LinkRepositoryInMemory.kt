package fr.antoinechalifour.shrtn.infrastructure.repository

import fr.antoinechalifour.shrtn.domain.model.Link
import fr.antoinechalifour.shrtn.domain.repository.LinkRepository

class LinkRepositoryInMemory : LinkRepository {
    companion object {
        val database = mutableListOf<Link>()
    }

    override fun persist(link: Link) {
        database.add(link)
    }

    override fun findByShortUrl(shortUrl: String): Link? = database.find { it.shortUrl == shortUrl }
}
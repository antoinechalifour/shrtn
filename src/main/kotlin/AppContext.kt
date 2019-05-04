package fr.antoinechalifour.shrtn

import fr.antoinechalifour.shrtn.domain.repository.LinkRepository
import fr.antoinechalifour.shrtn.domain.usecase.GetBaseUrl
import fr.antoinechalifour.shrtn.domain.usecase.ShortenUrl


data class AppContextRepositories(val linkRepository: LinkRepository)

data class AppContextUseCases(
    val getBaseUrl: GetBaseUrl,
    val shortenUrl: ShortenUrl
)

data class AppConfig(
    val protocol: String,
    val host: String,
    val port: Int
)

data class AppContext(
    val repositories: AppContextRepositories,
    val useCases: AppContextUseCases,
    val config: AppConfig
)
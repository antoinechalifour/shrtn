package config

import domain.repository.LinkRepository
import domain.usecase.GetBaseUrl
import domain.usecase.ShortenUrl


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
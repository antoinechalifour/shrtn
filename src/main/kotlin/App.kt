package fr.antoinechalifour.shrtn

import fr.antoinechalifour.shrtn.domain.usecase.GetBaseUrl
import fr.antoinechalifour.shrtn.domain.usecase.ShortenUrl
import fr.antoinechalifour.shrtn.infrastructure.repository.LinkRepositoryInMemory
import fr.antoinechalifour.shrtn.server.App


val linkRepository = LinkRepositoryInMemory()
val appConfig = AppConfig(
    protocol = "http",
    host = "localhost",
    port = 8000
)

val appContext = AppContext(
    AppContextRepositories(linkRepository),
    AppContextUseCases(
        getBaseUrl = GetBaseUrl(linkRepository, appConfig),
        shortenUrl = ShortenUrl(linkRepository, appConfig)
    ),
    appConfig
)

fun main() {
    val app = App(
        port = appContext.config.port,
        appContext = appContext
    )

    app.run()
}
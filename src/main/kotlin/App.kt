import config.AppConfig
import config.AppContext
import config.AppContextRepositories
import config.AppContextUseCases
import domain.usecase.GetBaseUrl
import domain.usecase.ShortenUrl
import infrastructure.repository.LinkRepositoryInMemory
import infrastructure.server.App


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
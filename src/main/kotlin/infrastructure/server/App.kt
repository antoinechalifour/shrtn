package infrastructure.server

import config.AppContext
import infrastructure.server.routes.addSRoutes
import io.javalin.Javalin

class App(private val port: Int, private val appContext: AppContext) {
    val app = Javalin.create()

    fun run() {
        app.apply {
            enableCorsForAllOrigins()
        }

        addSRoutes(app, appContext)

        app.start(port)
    }
}
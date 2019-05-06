package infrastructure.server.routes

import config.AppContext
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*


data class PostBody(val url: String)
data class PostResponse(val short: String)

fun addSRoutes(app: Javalin, appContext: AppContext) {
    app.routes {
        path("s") {
            post { ctx ->
                val body = ctx.bodyValidator<PostBody>()
                val link = appContext.useCases.shortenUrl(body.get().url)

                ctx.json(PostResponse(link.shortUrl))
            }

            path(":id") {
                get { ctx ->
                    val id = ctx.pathParam("id")
                    val link = appContext.useCases.getBaseUrl(id)

                    ctx.redirect(link.url)
                }
            }
        }
    }
}
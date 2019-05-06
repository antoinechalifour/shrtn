package domain.helpers

fun getShortUrl(protocol: String, host: String, port: Int, shortUrl: String) = "$protocol://$host:$port/s/$shortUrl"
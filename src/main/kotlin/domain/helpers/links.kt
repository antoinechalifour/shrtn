package domain.helpers

fun getShortUrl(protocol: String, host: String, shortUrl: String) = "$protocol://$host/s/$shortUrl"
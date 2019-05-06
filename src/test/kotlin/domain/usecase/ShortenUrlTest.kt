package domain.usecase

import config.AppConfig
import domain.repository.LinkRepository
import infrastructure.repository.LinkRepositoryInMemory
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class ShortenUrlTest {
    private lateinit var linkRepository: LinkRepository
    private lateinit var config: AppConfig

    @BeforeEach
    fun init() {
        linkRepository = LinkRepositoryInMemory()
        config = AppConfig(
            protocol = "http",
            host = "localhost",
            port = 8000
        )
    }

    @Test
    fun `creates the link`() {
        // Given
        val url = "http://example.com/test"
        val shortenUrl = ShortenUrl(linkRepository, config)

        // When
        val link = shortenUrl(url)

        // Then
        val result = linkRepository.findByShortUrl(link.shortUrl)

        result!!

        assertThat(result).isNotNull()
        assertThat(result.url).isEqualTo("http://example.com/test")
        assertThat(result.shortUrl).matches("http://localhost:8000/s/(.*)")
    }
}
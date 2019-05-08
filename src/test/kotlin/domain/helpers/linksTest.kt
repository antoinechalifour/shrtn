package domain.helpers

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LinksHelpersTest {
    @Test
    fun `returns the correct URL`() {
        // Given
        val protocol = "http"
        val host = "127.0.0.1"
        val shortUrl = "short-url"

        // When
        val result = getShortUrl(
            protocol = protocol,
            host = host,
            shortUrl = shortUrl
        )

        // Then
        assertThat(result).isEqualTo("http://127.0.0.1/s/short-url")
    }
}
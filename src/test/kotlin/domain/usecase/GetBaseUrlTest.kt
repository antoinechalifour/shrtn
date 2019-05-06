package domain.usecase


import config.AppConfig
import domain.model.Link
import domain.repository.LinkRepository
import infrastructure.repository.LinkRepositoryInMemory
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetBaseUrlTest {
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
    fun `returns the link when found`() {
        // Given
        val link = Link("http://example.com/yes", "http://localhost:8000/s/short")
        linkRepository.persist(link)
        val getBaseUrl = GetBaseUrl(linkRepository, config)

        // When
        val result = getBaseUrl("short")

        // Then
        assertThat(result).isEqualTo(link)
    }

    @Test
    fun `throws an exception when the link is not found`() {
        // Given
        val getBaseUrl = GetBaseUrl(linkRepository, config)

        // When
        assertThatThrownBy { getBaseUrl("some-link") }.hasMessage("Link some-link was not found")
    }
}
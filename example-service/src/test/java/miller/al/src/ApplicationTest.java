package miller.al.src;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApplicationTest {

    @Test
    void applicationContextShouldLoad() {
        assertThat(true).isTrue();
    }
}

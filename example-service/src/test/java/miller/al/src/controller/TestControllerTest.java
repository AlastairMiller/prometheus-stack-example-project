package miller.al.src.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class TestControllerTest {

    MeterRegistry meterRegistry;
    TestController testController;

    @BeforeEach
    void setup() {
        meterRegistry = new SimpleMeterRegistry();
        testController = new TestController(meterRegistry);
    }

    @Test
    void slowRequestShouldReturnSuccess() throws InterruptedException {
        assertThat(testController.slowRequest()).isEqualTo("Success");
    }

    @Test
    void counterExampleShouldIncrementOnMethodCall() {
        assertThat(meterRegistry.counter("test_counter").count()).isEqualTo(0);
        testController.counterExample();
        assertThat(meterRegistry.counter("test_counter").count()).isEqualTo(1);
    }

}
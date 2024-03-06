package miller.al.src.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
public class TestController {

    MeterRegistry meterRegistry;

    @Autowired
    TestController(MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
    }

    @Timed(histogram = true, percentiles = 0.5)
    @GetMapping(value = "/slow")
    public String slowRequest() throws InterruptedException {

        //Simulating latency
        var random = new SecureRandom();
        Thread.sleep(10 + random.nextLong(100));
        return "Success";
    }

    @GetMapping(value = "/increment")
    public String counterExample() {
        var counter =  Counter
                .builder("test_counter")
                .description("A counter incremented by GET requests")
                .register(meterRegistry);

        counter.increment();

        return "Success";
    }

}

package com.nttdata.camunda.common.observability;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(999)
public class LogObservationHandler implements ObservationHandler<Observation.Context> {

    @Override
    public void onStart(Observation.Context context) {
        log.debug("LogObservationHandler::onStart: {}", context.getName());
    }

    @Override
    public void onStop(Observation.Context context) {
        log.debug("LogObservationHandler::onStop: {}", context.getName());
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}

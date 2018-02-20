package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StatusItemProcessor implements ItemProcessor<Status, Status> {

    private static final Logger log = LoggerFactory.getLogger(StatusItemProcessor.class);

    @Override
    public Status process(final Status status) throws Exception {

        if(status.getStatus().equals("failed")) {
            throw new Exception();
        }

        log.info("Processed (" + status + ")");

        return status;
    }

}
package com.yygnb.demo.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @Title: com.yygnb.demo.config.DemoNotifier
 * @Description: <h1></h1>
 * @Date: 2022/9/6 17:21
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/6 17:21   dscloudy    Create File.
 */
@Slf4j
@Component
public class DemoNotifier extends AbstractEventNotifier {

    protected DemoNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> log.error("Instance info: {}, {}, {}",
                instance.getRegistration().getName(), event.getInstance(),
                event.getType()));
    }
}

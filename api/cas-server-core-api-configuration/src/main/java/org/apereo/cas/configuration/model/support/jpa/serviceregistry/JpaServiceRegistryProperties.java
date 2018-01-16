package org.apereo.cas.configuration.model.support.jpa.serviceregistry;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties;
import org.apereo.cas.configuration.support.RequiresModule;

/**
 * Configuration properties class for JPA service registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-jpa-service-registry")
@Slf4j
public class JpaServiceRegistryProperties extends AbstractJpaProperties {

    private static final long serialVersionUID = 352435146313504995L;

    public JpaServiceRegistryProperties() {
        super.setUrl("jdbc:hsqldb:mem:cas-service-registry");
    }
}

package org.apereo.cas.configuration.model.support.hazelcast;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties;
import org.apereo.cas.configuration.support.RequiresModule;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Encapsulates hazelcast properties exposed by CAS via properties file property source in a type-safe manner.
 *
 * @author Dmitriy Kopylenko
 * @since 4.2.0
 */
@RequiresModule(name = "cas-server-support-hazelcast-ticket-registry")
@Slf4j
public class HazelcastTicketRegistryProperties extends BaseHazelcastProperties {
    
    private static final long serialVersionUID = -1095208036374406772L;

    /**
     * Page size is used by a special Predicate which helps to get a page-by-page result of a query.
     */
    private long pageSize = 500;
    
    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    private EncryptionRandomizedSigningJwtCryptographyProperties crypto = new EncryptionRandomizedSigningJwtCryptographyProperties();

    public HazelcastTicketRegistryProperties() {
        this.crypto.setEnabled(false);
    }
    
    public EncryptionRandomizedSigningJwtCryptographyProperties getCrypto() {
        return crypto;
    }

    public void setCrypto(final EncryptionRandomizedSigningJwtCryptographyProperties crypto) {
        this.crypto = crypto;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(final long pageSize) {
        this.pageSize = pageSize;
    }
}

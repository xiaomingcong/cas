package org.apereo.cas.configuration.model.core.audit;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties;
import org.apereo.cas.configuration.support.RequiresModule;

/**
 * This is {@link AuditJdbcProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-audit-jdbc")
@Slf4j
public class AuditJdbcProperties extends AbstractJpaProperties {
    private static final long serialVersionUID = 4227475246873515918L;

    /**
     * Execute the recording of audit records in async manner.
     * This setting must almost always be set to true.
     */
    private boolean asynchronous = true;
    
    /**
     * Indicates how long audit records should be kept in the database.
     * This is used by the clean-up criteria to clean up after stale audit records.
     */
    private int maxAgeDays = 180;

    /**
     * Defines the isolation level for transactions.
     *
     * @see org.springframework.transaction.TransactionDefinition
     */
    private String isolationLevelName = "ISOLATION_READ_COMMITTED";

    /**
     * Defines the propagation behavior for transactions.
     *
     * @see org.springframework.transaction.TransactionDefinition
     */
    private String propagationBehaviorName = "PROPAGATION_REQUIRED";

    public boolean isAsynchronous() {
        return asynchronous;
    }

    public void setAsynchronous(final boolean asynchronous) {
        this.asynchronous = asynchronous;
    }

    public int getMaxAgeDays() {
        return maxAgeDays;
    }

    public void setMaxAgeDays(final int maxAgeDays) {
        this.maxAgeDays = maxAgeDays;
    }

    public String getPropagationBehaviorName() {
        return propagationBehaviorName;
    }

    public void setPropagationBehaviorName(final String propagationBehaviorName) {
        this.propagationBehaviorName = propagationBehaviorName;
    }

    public String getIsolationLevelName() {
        return isolationLevelName;
    }

    public void setIsolationLevelName(final String isolationLevelName) {
        this.isolationLevelName = isolationLevelName;
    }
}


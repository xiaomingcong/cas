package org.apereo.cas.support.saml;

import org.apereo.cas.config.CasCoreAuthenticationConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationHandlersConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationMetadataConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationPolicyConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationPrincipalConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationServiceSelectionStrategyConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationSupportConfiguration;
import org.apereo.cas.config.CasCoreConfiguration;
import org.apereo.cas.config.CasCoreHttpConfiguration;
import org.apereo.cas.config.CasCoreServicesAuthenticationConfiguration;
import org.apereo.cas.config.CasCoreServicesConfiguration;
import org.apereo.cas.config.CasCoreTicketCatalogConfiguration;
import org.apereo.cas.config.CasCoreTicketIdGeneratorsConfiguration;
import org.apereo.cas.config.CasCoreTicketsConfiguration;
import org.apereo.cas.config.CasCoreUtilConfiguration;
import org.apereo.cas.config.CasCoreWebConfiguration;
import org.apereo.cas.config.CasDefaultServiceTicketIdGeneratorsConfiguration;
import org.apereo.cas.config.CasHibernateJpaConfiguration;
import org.apereo.cas.config.CasPersonDirectoryConfiguration;
import org.apereo.cas.config.CoreSamlConfiguration;
import org.apereo.cas.config.SamlIdPAuthenticationServiceSelectionStrategyConfiguration;
import org.apereo.cas.config.SamlIdPConfiguration;
import org.apereo.cas.config.SamlIdPEndpointsConfiguration;
import org.apereo.cas.config.SamlIdPJpaIdPMetadataConfiguration;
import org.apereo.cas.config.SamlIdPJpaRegisteredServiceMetadataConfiguration;
import org.apereo.cas.config.SamlIdPMetadataConfiguration;
import org.apereo.cas.config.support.CasWebApplicationServiceFactoryConfiguration;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.logout.config.CasCoreLogoutConfiguration;
import org.apereo.cas.support.saml.idp.metadata.generator.SamlIdPMetadataGenerator;
import org.apereo.cas.support.saml.idp.metadata.locator.SamlIdPMetadataLocator;
import org.apereo.cas.support.saml.services.idp.metadata.cache.resolver.SamlRegisteredServiceMetadataResolver;
import org.apereo.cas.validation.config.CasCoreValidationConfiguration;
import org.apereo.cas.web.config.CasCookieConfiguration;
import org.apereo.cas.web.flow.config.CasCoreWebflowConfiguration;
import org.apereo.cas.web.flow.config.CasWebflowContextConfiguration;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is {@link BaseJpaSamlMetadataTests}.
 *
 * @author Misagh Moayyed
 * @since 6.0.0
 */
@SpringBootTest(classes = BaseJpaSamlMetadataTests.SharedTestConfiguration.class)
@EnableConfigurationProperties(CasConfigurationProperties.class)
@EnableTransactionManagement(proxyTargetClass = true)
@Tag("SAML")
@TestPropertySource(properties = {
    "cas.jdbc.showSql=true",
    "cas.authn.saml-idp.metadata.location=${#systemProperties['java.io.tmpdir']}/saml"
})
public abstract class BaseJpaSamlMetadataTests {
    @Autowired
    @Qualifier("jpaSamlRegisteredServiceMetadataResolver")
    protected SamlRegisteredServiceMetadataResolver resolver;

    @Autowired
    @Qualifier("samlIdPMetadataGenerator")
    protected SamlIdPMetadataGenerator samlIdPMetadataGenerator;

    @Autowired
    @Qualifier("samlIdPMetadataLocator")
    protected SamlIdPMetadataLocator samlIdPMetadataLocator;

    @ImportAutoConfiguration({
        RefreshAutoConfiguration.class,
        MailSenderAutoConfiguration.class,
        AopAutoConfiguration.class
    })
    @SpringBootConfiguration
    @Import({
        SamlIdPJpaRegisteredServiceMetadataConfiguration.class,
        SamlIdPJpaIdPMetadataConfiguration.class,
        CasHibernateJpaConfiguration.class,
        CasDefaultServiceTicketIdGeneratorsConfiguration.class,
        CasCoreTicketIdGeneratorsConfiguration.class,
        CasWebApplicationServiceFactoryConfiguration.class,
        CasCoreAuthenticationConfiguration.class,
        CasCoreServicesAuthenticationConfiguration.class,
        CasCoreAuthenticationPolicyConfiguration.class,
        CasCoreAuthenticationPrincipalConfiguration.class,
        CasCoreAuthenticationMetadataConfiguration.class,
        CasCoreAuthenticationSupportConfiguration.class,
        CasCoreAuthenticationHandlersConfiguration.class,
        CasCoreHttpConfiguration.class,
        CasCoreServicesConfiguration.class,
        CasCoreWebConfiguration.class,
        CasCoreWebflowConfiguration.class,
        CasWebflowContextConfiguration.class,
        SamlIdPConfiguration.class,
        SamlIdPAuthenticationServiceSelectionStrategyConfiguration.class,
        SamlIdPEndpointsConfiguration.class,
        SamlIdPMetadataConfiguration.class,
        RefreshAutoConfiguration.class,
        AopAutoConfiguration.class,
        CasCoreTicketsConfiguration.class,
        CasCoreTicketCatalogConfiguration.class,
        CasCoreLogoutConfiguration.class,
        CasCookieConfiguration.class,
        CasCoreValidationConfiguration.class,
        CasCoreConfiguration.class,
        CasCoreAuthenticationServiceSelectionStrategyConfiguration.class,
        CoreSamlConfiguration.class,
        CasPersonDirectoryConfiguration.class,
        CasCoreUtilConfiguration.class
    })
    static class SharedTestConfiguration {
    }
}

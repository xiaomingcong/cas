package org.apereo.cas.configuration.model.support.hazelcast.discovery;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.support.RequiredProperty;
import org.apereo.cas.configuration.support.RequiresModule;

import java.io.Serializable;

/**
 * This is {@link HazelcastJCloudsDiscoveryProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-support-hazelcast-core")
@Slf4j
public class HazelcastJCloudsDiscoveryProperties implements Serializable {

    /**
     * JClouds provider property.
     */
    public static final String JCLOUDS_DISCOVERY_PROVIDER = "provider";
    /**
     * JClouds identity property.
     */
    public static final String JCLOUDS_DISCOVERY_IDENTITY = "identity";
    /**
     * JClouds credential property.
     */
    public static final String JCLOUDS_DISCOVERY_CREDENTIAL = "credential";
    /**
     * JClouds endpoint property.
     */
    public static final String JCLOUDS_DISCOVERY_ENDPOINT = "endpoint";
    /**
     * JClouds zones property.
     */
    public static final String JCLOUDS_DISCOVERY_ZONES = "zones";
    /**
     * JClouds regions property.
     */
    public static final String JCLOUDS_DISCOVERY_REGIONS = "regions";
    /**
     * JClouds tag-keys property.
     */
    public static final String JCLOUDS_DISCOVERY_TAG_KEYS = "tag-keys";
    /**
     * JClouds tag-values property.
     */
    public static final String JCLOUDS_DISCOVERY_TAG_VALUES = "tag-values";
    /**
     * JClouds group property.
     */
    public static final String JCLOUDS_DISCOVERY_GROUP = "group";
    /**
     * JClouds hz-port property.
     */
    public static final String JCLOUDS_DISCOVERY_HZ_PORT = "hz-port";
    /**
     * JClouds role-name property.
     */
    public static final String JCLOUDS_DISCOVERY_ROLE_NAME = "role-name";
    /**
     * JClouds credential path property.
     */
    public static final String JCLOUDS_DISCOVERY_CREDENTIAL_PATH = "credentialPath";

    private static final long serialVersionUID = -8281247687171101766L;

    /**
     * String value that is used to identify ComputeService provider. For example, "google-compute-engine" is used for Google Cloud services.
     * See <a href="https://jclouds.apache.org/reference/providers/#compute">here</a> for more info.
     */
    @RequiredProperty
    private String provider;

    /**
     * Cloud Provider identity, can be thought of as a user name for cloud services.
     */
    @RequiredProperty
    private String identity;

    /**
     * Cloud Provider credential, can be thought of as a password for cloud services.
     */
    @RequiredProperty
    private String credential;

    /**
     * Defines the endpoint for a gneric API such as OpenStack or CloudStack (optional).
     */
    private String endpoint;

    /**
     * Defines zone for a cloud service (optional). Can be used with comma separated values for multiple values.
     */
    private String zones;

    /**
     * Defines region for a cloud service (optional). Can be used with comma separated values for multiple values.
     */
    private String regions;

    /**
     * Filters cloud instances with tags (optional). Can be used with comma separated values for multiple values.
     */
    private String tagKeys;

    /**
     * Filters cloud instances with tags (optional) Can be used with comma separated values for multiple values.
     */
    private String tagValues;

    /**
     * Filters instance groups (optional). When used with AWS it maps to security group.
     */
    private String group;

    /**
     * Port which the hazelcast instance service uses on the cluster member. Default value is 5701. (optional)
     */
    private int port = -1;

    /**
     * Used for IAM role support specific to AWS (optional, but if defined, no identity or credential should be defined in the configuration).
     */
    private String roleName;

    /**
     * Used for cloud providers which require an extra JSON or P12 key file. This denotes the path of that file. Only tested with Google Compute Engine.
     * (Required if Google Compute Engine is used.)
     */
    private String credentialPath;

    public String getProvider() {
        return provider;
    }

    public void setProvider(final String provider) {
        this.provider = provider;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(final String identity) {
        this.identity = identity;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(final String credential) {
        this.credential = credential;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getZones() {
        return zones;
    }

    public void setZones(final String zones) {
        this.zones = zones;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(final String regions) {
        this.regions = regions;
    }

    public String getTagKeys() {
        return tagKeys;
    }

    public void setTagKeys(final String tagKeys) {
        this.tagKeys = tagKeys;
    }

    public String getTagValues() {
        return tagValues;
    }

    public void setTagValues(final String tagValues) {
        this.tagValues = tagValues;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public String getCredentialPath() {
        return credentialPath;
    }

    public void setCredentialPath(final String credentialPath) {
        this.credentialPath = credentialPath;
    }
}

package org.eclipse.milo.examples.server;

import org.eclipse.milo.opcua.sdk.server.OpcUaServer;

/*
 * @author s5uishida
 *
 */
public class UaConfig extends AbstractConfig {
	public static final String CONFIG_DIR_PARAM				= "config.dir";
	public static final String OPCUA_CONFIG_FILE			= "opcua.properties";
	public static final String TCP_PORT_KEY					= "tcpPort";
	public static final String TCP_PORT_ENABLE_KEY			= "tcpPortEnable";
	public static final String HTTPS_PORT_KEY				= "httpsPort";
	public static final String HTTPS_PORT_ENABLE_KEY		= "httpsPortEnable";
	public static final String KEY_STORE_TYPE_KEY			= "keyStoreType";
	public static final String KEY_STORE_ALIAS_KEY 			= "keyStoreAlias";
	public static final String KEY_STORE_PASSWORD_KEY		= "keyStorePassword";
	public static final String CERTIFICATE_KEY 				= "certificate";
	public static final String USER_NAME_KEY 				= "userName";
	public static final String USER_PASSWORD_KEY 			= "userPassword";
	public static final String ADMIN_NAME_KEY 				= "adminName";
	public static final String ADMIN_PASSWORD_KEY 			= "adminPassword";

	private static UaConfig config = null;

	private UaConfig(String dirParam, String fileName) {
		super(dirParam, fileName);
	}

	public static UaConfig getInstance() {
		if (config == null) {
			config = new UaConfig(CONFIG_DIR_PARAM, OPCUA_CONFIG_FILE);
		}
		return config;
	}

	public String getVersion() {
		return OpcUaServer.SDK_VERSION;
	}

	public String getConfigDir() {
		return CONFIG_DIR_PARAM;
	}

	public String getOpcuaConfigFile() {
		return OPCUA_CONFIG_FILE;
	}

	public int getTcpPort() {
		return getConfig(TCP_PORT_KEY, 12686);
	}

	public boolean getTcpPortEnable() {
		return getConfig(TCP_PORT_ENABLE_KEY, true);
	}

	public int getHttpsPort() {
		return getConfig(HTTPS_PORT_KEY, 8443);
	}

	public boolean getHttpsPortEnable() {
		return getConfig(HTTPS_PORT_ENABLE_KEY, false);
	}

	public String getKeyStoreType() {
		return getConfig(KEY_STORE_TYPE_KEY, "PKCS12");
	}

	public String getKeyStoreAlias() {
		return getConfig(KEY_STORE_ALIAS_KEY, "server-ai");
	}

	public String getKeyStorePassword() {
		return getConfig(KEY_STORE_PASSWORD_KEY, "password");
	}

	public String getCertificate() {
		return getConfig(CERTIFICATE_KEY, "example-certs.pfx");
	}

	public String getUserName() {
		return getConfig(USER_NAME_KEY, "user");
	}

	public String getUserPassword() {
		return getConfig(USER_PASSWORD_KEY, "password1");
	}

	public String getAdminName() {
		return getConfig(ADMIN_NAME_KEY, "admin");
	}

	public String getAdminPassword() {
		return getConfig(ADMIN_PASSWORD_KEY, "password2");
	}
}

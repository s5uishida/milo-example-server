package org.eclipse.milo.examples.server;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @author s5uishida
 *
 */
public class AbstractConfig {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractConfig.class);

	private final String dirParam;
	private final String fileName;
	private final String filePath;
	private final Properties prop;

	private String dir;

	public AbstractConfig(String dirParam, String fileName) {
		this.dirParam = Objects.requireNonNull(dirParam);
		this.fileName = Objects.requireNonNull(fileName);

		dir = System.getProperty(this.dirParam);
		dir = (dir == null || dir.isEmpty()) ? "" : dir + "/";
		filePath = dir + this.fileName;

		prop = new Properties();
		try {
			LOG.info("loading {}...", filePath);
			prop.load(new File(filePath).toURI().toURL().openStream());
			LOG.info("loaded {}.", filePath);
		} catch (MalformedURLException e) {
			LOG.warn("failed to load {}.", filePath);
			throw new IllegalStateException(e);
		} catch (IOException e) {
			LOG.warn("failed to load {}.", filePath);
			throw new IllegalStateException(e);
		}
	}

	public String getDir() {
		return dir;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getConfig(String name, String defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return value;
		}
	}

	public int getConfig(String name, int defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			try {
				return Integer.valueOf(value);
			} catch (NumberFormatException e) {
				LOG.warn("caught - {} - {} {}", e.toString(), name, value);
				return defaultValue;
			}
		}
	}

	public long getConfig(String name, long defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			try {
				return Long.valueOf(value);
			} catch (NumberFormatException e) {
				LOG.warn("caught - {} - {} {}", e.toString(), name, value);
				return defaultValue;
			}
		}
	}

	public boolean getConfig(String name, boolean defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			return Boolean.valueOf(value);
		}
	}

	public float getConfig(String name, float defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			try {
				return Float.valueOf(value);
			} catch (NumberFormatException e) {
				LOG.warn("caught - {} - {} {}", e.toString(), name, value);
				return defaultValue;
			}
		}
	}

	public double getConfig(String name, double defaultValue) {
		String value = prop.getProperty(name);
		if (value == null || value.isEmpty()) {
			return defaultValue;
		} else {
			try {
				return Double.valueOf(value);
			} catch (NumberFormatException e) {
				LOG.warn("caught - {} - {} {}", e.toString(), name, value);
				return defaultValue;
			}
		}
	}
}

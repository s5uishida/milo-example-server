package org.eclipse.milo.examples.server;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ExampleServer server = null;

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.context = context;

		server = new ExampleServer();
		server.startup().get();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;

		try {
			if (server != null) {
				server.shutdown().get();
			}
		} finally {
			server = null;
		}
	}
}

package com.apm.threshold.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;

import com.apm.threshold.application.ThresholdApplication;

public class MainServer extends Application {

	public static void main(String[] args) throws Exception {

		Component com = new Component();
		com.getServers().add(Protocol.HTTP, 12345);
		com.getDefaultHost().attach("/threshold", new ThresholdApplication());
		com.start();
	}
}

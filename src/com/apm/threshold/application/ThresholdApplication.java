package com.apm.threshold.application;

import org.restlet.Restlet;
import org.restlet.ext.wadl.WadlApplication;
import org.restlet.routing.Router;

import com.apm.threshold.resource.InfoResource;
import com.apm.threshold.resource.MetricResource;
import com.apm.threshold.resource.RegisterResource;


public class ThresholdApplication extends WadlApplication {
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext()) ;
		router.attach("/register" ,RegisterResource.class);
		router.attach("/metricRegister" ,MetricResource.class);
		router.attach("/info" ,InfoResource.class);
		return router;
	}
}

package io.alchemystudio.protocol.impl;

import io.alchemystudio.protocol.Dispatcher;
import io.alchemystudio.protocol.Id;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import io.alchemystudio.protocol.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultDispatcher implements Dispatcher {
    Map<Id, Service> services =  new ConcurrentHashMap<>();

    public void addService(Id serviceId, Service service) {
        services.put(serviceId, service);
    }

    @Override
    public void dispatch(Request request, Response response) {
        Service callingService = services.get(request.getContext().getVendorId());
        Helper.invokeServiceMethod(callingService, request, response);

    }
}

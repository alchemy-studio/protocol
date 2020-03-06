package io.alchemystudio.protocol.impl;

import io.alchemystudio.protocol.Context;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import io.alchemystudio.protocol.spi.Service;

import java.lang.reflect.Method;

public class Helper {
    public static void invokeServiceMethod(Service service, Request request, Response response) {
        try {
            Context ctx = request.getContext();
            Method m = service.getClass().getDeclaredMethod(ctx.getMethod(), Request.class, Response.class);
            m.invoke(service, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.Dispatcher;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import io.alchemystudio.protocol.Rpc;

public class MockRpc implements Rpc {

    // 这个可以用spring的autowired bean
    Dispatcher dispatcher;

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public Response call(Request req) {
        // 可以在这里针对resposne做一些准备工作。
        Response resp = new Response();

        // 把request和response传递给dispatcher去完成工作。
        dispatcher.dispatch(req, resp);

        // 返回处理好的resp。
        return resp;
    }
}

package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.Context;
import io.alchemystudio.protocol.Dispatcher;
import io.alchemystudio.protocol.Id;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import io.alchemystudio.protocol.impl.DefaultDispatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultDispatcherTest {
    @Test
    public void testHello() {
        // 这些配置工作在生产环境里用spring的beans来配置生成。
        DefaultDispatcher dispatcher = new DefaultDispatcher();
        MockService service = new MockService();
        MockRpc rpc = new MockRpc();


        Id vendorId = Id.generate();
        Context ctx = new Context();
        // 对应service，下面会设置service
        ctx.setVendorId(vendorId);
        // 注意这里method一定要设置为要调用的方法名
        ctx.setMethod("hello2");

        // service根据对应的vendorId放在dispatcher里面，后续会调用
        dispatcher.addService(vendorId, service);

        // rpc接口是唯一暴露的网络接口，这里测试的MockRpc不走网络。
        rpc.setDispatcher(dispatcher);

        // 设置完成，模拟一次用户请求
        Request req = new Request();

        // context是request里面必须要封装的信息，dispatcher要靠context来定位所需服务和所需call的方法。
        // 我们dispatcher和request使用同一个context，自然是可以对应上的。
        req.setContext(ctx);

        // dispatcher应该会根据request当中的vendorId和method信息进行正确的分发
        // 把请求发给所需的service的method上面去
        Response resp = rpc.call(req);
        Assertions.assertEquals("Hello, Martian!", resp.getResult());
    }
}

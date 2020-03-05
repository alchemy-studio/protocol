package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.Context;
import io.alchemystudio.protocol.Id;
import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MockServiceTest {
    @Test
    public void testHello() {
        // 这些配置工作在生产环境里用spring的beans来配置生成。
        MockDispatcher dispatcher = new MockDispatcher();
        MockService service = new MockService();
        MockRpc rpc = new MockRpc();

        dispatcher.setMockService(service);
        rpc.setDispatcher(dispatcher);

        // 设置完成，模拟一次用户请求
        Request req = new Request();
        Context ctx = new Context();

        // 一个dispatcher可能会处理多个业务的请求，每一个业务可以理解为一个不同的vendor。
        // 举例：因为在云服务的架构体系下，我们一个rest接口可能给多个不同的小程序提供服务，每一个小程序是一个vendor。
        Id vendorId = Id.generate();

        ctx.setVendorId(vendorId);
        ctx.setMethod("hello");
        // context是request里面必须要封装的信息，dispatcher要靠context来定位所需服务和所需call的方法。
        req.setContext(ctx);
        // dispatcher这一个层面会根据context来判断如何分发请求。
        // 这个测试假设我们仅靠vendorId和method信息来分发，
        dispatcher.setVendorIdForTest(vendorId);

        // dispatcher应该会根据request当中的vendorId和method信息进行正确的分发
        // 把请求发给所需的service的method上面去
        Response resp = rpc.call(req);
        Assertions.assertEquals("Hello, world!", resp.getResult());
    }
}

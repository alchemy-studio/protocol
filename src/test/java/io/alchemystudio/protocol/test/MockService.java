package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;
import io.alchemystudio.protocol.Service;

// 假设这是我们的一个service，这个service不暴露在网络接口上，作为内部的功能单元。
public class MockService implements Service {
    // 为了让DefaultDispatcher工作，所有的service方法必须是严格只有两个参数：
    // request和response。
    public void hello(Request request, Response response) {
        response.setResult("Hello, world!");
    }

    public void hello2(Request request, Response response) {
        response.setResult("Hello, Martian!");
    }
}

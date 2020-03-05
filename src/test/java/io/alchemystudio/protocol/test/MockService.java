package io.alchemystudio.protocol.test;

import io.alchemystudio.protocol.Request;
import io.alchemystudio.protocol.Response;

// 假设这是我们的一个service，这个service不暴露在网络接口上，作为内部的功能单元。
public class MockService {
    public void hello(Request request, Response response) {
        response.setResult("Hello, world!");
    }
}

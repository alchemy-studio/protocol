## 炼金工房数据交换协议

协议模块是为了统一的REST接口：

```java
package io.alchemystudio.protocol;

public interface Api {
    Response call(Request req);
}
```

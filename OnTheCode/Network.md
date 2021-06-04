AP: the devices can through AP (accessible point) to connect one whole Ethernet managed by .



### Router

1. Route mode
   1. **DHCP mode**: can automatically provide IP addressed to the devices low in the layer. From the higher layer router's perspective, the whole inner network is a device. Therefore, if there has a bandwidth limitation, the total bandwidth through this router is one device bandwidth.  
   2. **Bridage mode**: just a bridge to connect the higher layer routers to the lower devices. The functions of the router is provide wireless and there is **NO** IP distribution. It is like a glue to connect all part devices to the higher router, like a *switch*. 

2. Gateway: the top layer router the device can reach.





### The socket listen Ip addr and port

The ip addr of socket listen is like:

```go
// specific bind ip addr
net.Listen("tcp", "127.0.0.1:9000")

// general bind ip addr
net.Listen("tcp", ":9000")
// as same as empty, a catch all address.
net.Listen("tcp", "0.0.0.0:9000")
```

If the specific IP is binded, you can *only receive data sent to this specific IP* address. 

As far as i know, if this addr is a Ethernet ip addr for example is `192.168.0.10`, the other Ethernet devices cannot reach this ip. Therefore it is no effect.
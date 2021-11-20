# Raspberry Pi network config

在几天前，配置好了树莓派开机自启动wifi，说实话很好用，再也不用用屏幕去看她的IP addr了，方便了很多很多。

但是现在需要用jetson nano和树莓派通信，现在是已经把所有的串口都用完了，所以就只能用网口了。

在树莓派开启自己的wifi的情况下，在用LAN和jetson nano连接，是会有问题的，因为树莓派自己的wifi网段和jetson nano的LAN网段冲突了，就会crash（两个网都或多或少有点问题），所以一个比较简单直接的方法就是：修改树莓派自己的在不同网段下的IPV4地址。 



是要使用DHCP来配置的，

```bash
sudo vim /etc/dhcpcd.conf
```

里面添加进去：

> where a network cable is used for the internet connection:

```bash
interface eth0
static ip_address=192.168.0.4/24
static routers=192.168.0.1
static domain_name_servers=192.168.0.1
```

这个就是`eth0`这个*interface*的配置，是指有线连接的网络接口，网络接口大家都称之为*interface*，下面两行在单机的环境下是不需要的了。

之后需要连接的设备都是在静态的IP，虽然不静态可能也可以。



reference:

[1] https://www.ionos.com/digitalguide/server/configuration/provide-raspberry-pi-with-a-static-ip-address/
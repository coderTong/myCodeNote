# Exception in thread "main" java.io.InvalidClassException:
序列化是字节码版本号问题


![00-javaError-01](image/00-javaError-01.png)

```
private static final long serialVersionUID = 1L;

```

# 端口地址,地址被占用


![00-javaError-02](image/00-javaError-02.png)

```

Exception in thread "main" java.net.BindException: Address already in use (Bind failed)
	at java.net.PlainDatagramSocketImpl.bind0(Native Method)
	at java.net.AbstractPlainDatagramSocketImpl.bind(AbstractPlainDatagramSocketImpl.java:93)
	at java.net.DatagramSocket.bind(DatagramSocket.java:392)
	at java.net.DatagramSocket.<init>(DatagramSocket.java:242)
	at java.net.DatagramSocket.<init>(DatagramSocket.java:299)
	at java.net.DatagramSocket.<init>(DatagramSocket.java:271)
	at NetDemo.NetDemo_Ip.UDPDemoSend.main(UDPDemoSend.java:15)


```
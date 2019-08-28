# milo-example-server
milo-example-server is [Eclipse Milo OPC-UA sample server](https://github.com/eclipse/milo/tree/master/milo-examples/server-examples)
that runs on [Apache Felix](https://felix.apache.org/) (OSGi).
The Milo version is [0.3.3](https://github.com/eclipse/milo/tree/v0.3.3).
Some properties can be specified in the file. That is the only difference from the original.
The purpose is to verify the OPC-UA client function of rainy.
I releases this in the form of the Eclipse plug-in project. You need Java 8 or higher.

## Configuration - conf/opcua.properties
Edit the default values for the following properties by uncommenting them as necessary.
```
#-------------------------------------------------
# URI: opc.tcp://hostPort/milo
#
# for example) opc.tcp://192.168.1.1:12686/milo
#-------------------------------------------------
#tcpPortEnable=true
#tcpPort=12686
#
#httpsPortEnable=false
#httpsPort=8443
#
# PKCS12 or JKS or JCEKS
#keyStoreType=PKCS12
#
#keyStoreAlias=server-ai
#
#keyStorePassword=password
#
#certificate=example-certs.pfx
#
#userName=user
#userPassword=password1
#
#adminName=admin
#adminPassword=password2
```
## Run milo-example-server
- start  
  Start milo-example-server as follows.
```
# cd /path/to/milo-example-server-felix/bin
# sh server-start.sh 
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.felix.framework.ext.ClassPathExtenderFactory$DefaultClassLoaderExtender (file:/path/to/milo-example-server-felix/bin/felix.jar) to method java.net.URLClassLoader.addURL(java.net.URL)
WARNING: Please consider reporting this to the maintainers of org.apache.felix.framework.ext.ClassPathExtenderFactory$DefaultClassLoaderExtender
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
-> ps
START LEVEL 1
   ID   State         Level  Name
[   0] [Active     ] [    0] System Bundle (6.0.3)
[   1] [Active     ] [    1] bcpkix (1.62)
[   2] [Active     ] [    1] bcprov (1.62)
[   3] [Active     ] [    1] bsd-parser-core (0.3.3)
[   4] [Active     ] [    1] bsd-parser-gson (0.3.3)
[   5] [Active     ] [    1] Gson (2.8.5)
[   6] [Active     ] [    1] Guava: Google Core Libraries for Java (26.0.0.jre)
[   7] [Active     ] [    1] JavaBeans Activation Framework (1.2.0)
[   8] [Active     ] [    1] jaxb-api (2.4.0.b1808300359)
[   9] [Active     ] [    1] file:/home/pi/milo-example-server-felix/bundle/jaxb-runtime-2.4.0-b180830.0438.jar
[  10] [Active     ] [    1] milo-example-server (0.3.3)
[  11] [Active     ] [    1] Netty/Buffer (4.1.38.Final)
[  12] [Active     ] [    1] netty-channel-fsm-osgi (0.3.0)
[  13] [Active     ] [    1] Netty/Codec (4.1.38.Final)
[  14] [Active     ] [    1] Netty/Codec/HTTP (4.1.38.Final)
[  15] [Active     ] [    1] Netty/Common (4.1.38.Final)
[  16] [Active     ] [    1] Netty/Handler (4.1.38.Final)
[  17] [Active     ] [    1] Netty/Resolver (4.1.38.Final)
[  18] [Active     ] [    1] Netty/Transport (4.1.38.Final)
[  19] [Active     ] [    1] Apache Felix Shell Service (1.4.3)
[  20] [Active     ] [    1] Apache Felix Shell TUI (1.4.1)
[  21] [Active     ] [    1] Apache ServiceMix :: Bundles :: jsr305 (3.0.2.1)
[  22] [Active     ] [    1] OSGi LogService implemented over SLF4J (1.7.26)
[  23] [Active     ] [    1] sdk-core (0.3.3)
[  24] [Active     ] [    1] sdk-server (0.3.3)
[  25] [Active     ] [    1] slf4j-api (1.7.26)
[  26] [Resolved   ] [    1] slf4j-jdk14 (1.7.26)
[  27] [Active     ] [    1] stack-core (0.3.3)
[  28] [Active     ] [    1] stack-server (0.3.3)
[  29] [Active     ] [    1] strict-machine-osgi (0.1.0)
->
```
- stop  
  Stop milo-example-server as follows.
```
-> stop 0
```
## Use this with the following bundles
The license file for Eclipse Milo is located below.  
- [milo-example-server/META-INF/LICENSE.md](https://github.com/s5uishida/milo-example-server/blob/master/META-INF/LICENSE.md)

Please check each license for the following bundles used.
- [SLF4J 1.7.26](https://www.slf4j.org/)
- [JSR 305 3.0.2](https://mvnrepository.com/artifact/org.apache.servicemix.bundles/org.apache.servicemix.bundles.jsr305/3.0.2_1)
- [Guava: Google Core Libraries for Java 26.0](https://repo1.maven.org/maven2/com/google/guava/guava/26.0-jre/guava-26.0-jre.jar)
- [Netty 4.1.38](https://netty.io/index.html) netty-buffer-4.1.38.Final.jar, netty-codec-4.1.38.Final.jar, netty-codec-http-4.1.38.Final.jar, netty-common-4.1.38.Final.jar, netty-handler-4.1.38.Final.jar, netty-resolver-4.1.38.Final.jar, netty-transport-4.1.38.Final.jar
- [JAXB API 2.4.0](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.4.0-b180830.0359)
- [JAXB Runtime 2.4.0](https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime/2.4.0-b180830.0438)
- [JavaBeans Activation Framework (JAF) 1.2.0](https://mvnrepository.com/artifact/com.sun.activation/javax.activation/1.2.0)
- [strict-machine-osgi 0.1](https://github.com/s5uishida/strict-machine-osgi)
- [netty-channel-fsm-osgi 0.3](https://github.com/s5uishida/netty-channel-fsm-osgi)
- [bsd-parser-core 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/bsd-parser-core/0.3.3)
- [bsd-parser-gson 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/bsd-parser-gson/0.3.3)
- [stack-core 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/stack-core/0.3.3)
- [stack-server 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/stack-server/0.3.3)
- [sdk-core 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/sdk-core/0.3.3)
- [sdk-server 0.3.3](https://mvnrepository.com/artifact/org.eclipse.milo/sdk-server/0.3.3)
- [Gson 2.8.5](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5)
- [Bouncy Castle PKIX, CMS, EAC, TSP, PKCS, OCSP, CMP, and CRMF APIs 1.62](https://www.bouncycastle.org/download/bcpkix-jdk15on-162.jar)
- [Bouncy Castle Provider 1.62](https://www.bouncycastle.org/download/bcprov-jdk15on-162.jar)
- [Apache Felix 6.0.3](https://felix.apache.org/)
- [Apache Felix Shell 1.4.3](https://felix.apache.org/documentation/subprojects/apache-felix-shell.html)
- [Apache Felix Shell TUI 1.4.1](https://felix.apache.org/documentation/subprojects/apache-felix-shell-tui.html)

I would like to thank the authors of these very useful codes, and all the contributors.

## How to use
See [milo-example-server-felix.zip](https://github.com/s5uishida/milo-example-server/releases) for how to use milo-example-server.

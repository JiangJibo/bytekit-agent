package com.shulie.jjb.bytekit.agent;


import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.jar.JarFile;

public class ByteKitAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("==============premain1 执行===================");
        System.out.println("agentArgs : " + agentArgs);
        try {
            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/IdeaProjects/bytekit-instrumentation/target/bytekit-instrumentation-1.0-SNAPSHOT.jar"));
//            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/.m2/repository/com/alibaba/bytekit-core/0.0.7/bytekit-core-0.0.7.jar"));
//            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/.m2/repository/com/alibaba/bytekit-instrument-api/0.0.7/bytekit-instrument-api-0.0.7.jar"));
//            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/.m2/repository/com/alibaba/repackage-asm/0.0.9/repackage-asm-0.0.9.jar"));
//            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/.m2/repository/net/bytebuddy/byte-buddy-agent/1.11.6/byte-buddy-agent-1.11.6.jar"));
//            inst.appendToBootstrapClassLoaderSearch(new JarFile("/Users/jiangjibo/.m2/repository/org/benf/cfr/0.151/cfr-0.151.jar"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 添加Transformer
        inst.addTransformer(new ByteKitTransformer());
    }

}

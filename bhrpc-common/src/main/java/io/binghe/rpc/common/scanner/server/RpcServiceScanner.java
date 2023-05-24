package io.binghe.rpc.common.scanner.server;

import io.binghe.rpc.annotation.RpcService;
import io.binghe.rpc.common.scanner.ClassScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RpcServiceScanner extends ClassScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServiceScanner.class);

    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage) throws Exception {
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage);
        if (classNameList.isEmpty()) {
            return handlerMap;
        }
        classNameList.stream().forEach((className) -> {
            try {
                Class<?> clazz = Class.forName(className);
                RpcService rpcService = clazz.getAnnotation(RpcService.class);
                if (rpcService != null) {
                    String serviceName = getServiceName(rpcService);
                    String key = serviceName.concat(rpcService.version()).concat(rpcService.group());
                    handlerMap.put(key, clazz.newInstance());
                }
            } catch (Exception e) {
                LOGGER.error("scan classes throws exception: {}", e);
            }
        });
        return handlerMap;
    }

    private static String getServiceName(RpcService rpcService) {
        //TODO
        Class<?> clazz = rpcService.interfaceClass();
        if (clazz == void.class) {
            return rpcService.interfaceClassName();
        }
        return clazz.getName();
    }
}

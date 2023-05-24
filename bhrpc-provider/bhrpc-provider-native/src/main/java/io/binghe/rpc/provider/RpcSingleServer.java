package io.binghe.rpc.provider;

import io.binghe.rpc.common.scanner.server.RpcServiceScanner;
import io.binghe.rpc.provider.common.server.base.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcSingleServer extends BaseServer {

    private final Logger logger = LoggerFactory.getLogger(RpcSingleServer.class);


    public RpcSingleServer(String serverAddress, String scanPackage) {
        super(serverAddress);

        try {
            this.handlerMap = RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService(scanPackage);
        } catch (Exception e) {
            logger.error("RPC Server init error", e);
        }

    }

}

package com.dev.devinspringboot.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

@Slf4j
public class ZkTest implements Watcher {

    public static final Integer timeout = 5000;

    public static final String zkServerPath = "127.0.0.1:2181";

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}

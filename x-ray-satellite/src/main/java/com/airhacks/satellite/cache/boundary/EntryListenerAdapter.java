/*
 */
package com.airhacks.satellite.cache.boundary;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;

/**
 *
 * @author adam-bien.com
 */
public class EntryListenerAdapter implements EntryListener<String, Long> {

    @Override
    public void entryAdded(EntryEvent<String, Long> ee) {
        System.out.println("entryAdded: " + ee);
    }

    @Override
    public void entryRemoved(EntryEvent<String, Long> ee) {
        System.out.println("entryRemoved: " + ee);
    }

    @Override
    public void entryUpdated(EntryEvent<String, Long> ee) {
        System.out.println("entryUpdated: " + ee);

    }

    @Override
    public void entryEvicted(EntryEvent<String, Long> ee) {
        System.out.println("entryEvicted: " + ee);
    }

}
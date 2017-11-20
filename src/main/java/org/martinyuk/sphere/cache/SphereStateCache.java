package org.martinyuk.sphere.cache;

import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.entity.SphereState;
import org.martinyuk.sphere.observer.OperationObserver;
import org.martinyuk.sphere.observer.impl.SphereStateObserverImpl;

import java.util.HashMap;
import java.util.Map;

public class SphereStateCache {

    private Map<Long, SphereState> states;

    private SphereStateCache(){
        states = new HashMap<>();
    }

    public SphereState getSphereState(long sphereId){
        return states.get(sphereId);
    }

    public boolean addSphereState(Sphere sphere){
        if(!states.containsKey(sphere.getId())){
            SphereState state = new SphereState();
            OperationObserver observer = new SphereStateObserverImpl(state);
            sphere.addObserver(observer);
            states.put(sphere.getId(), state);
            return true;
        }
        return false;
    }

    public static SphereStateCache getInstance() {
        return SphereStateCache.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final SphereStateCache INSTANCE;

        static {
            INSTANCE = new SphereStateCache();
        }
    }

}

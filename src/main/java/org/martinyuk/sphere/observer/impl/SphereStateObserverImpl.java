package org.martinyuk.sphere.observer.impl;

import org.martinyuk.sphere.action.SphereCalculateAction;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.entity.SphereState;
import org.martinyuk.sphere.observer.OperationObserver;

import java.util.EventObject;

public class SphereStateObserverImpl implements OperationObserver {

    private SphereState sphereState;

    public SphereStateObserverImpl(SphereState state){
        sphereState = state;
    }

    public void valueChanged(EventObject observed) {
        if(observed.getSource() != null){
            sphereState.setSquare(SphereCalculateAction.getInstance().calculateSurfaceArea((Sphere)observed.getSource()));
            sphereState.setVolume(SphereCalculateAction.getInstance().calculateVolume((Sphere)observed.getSource()));
        }
    }
}

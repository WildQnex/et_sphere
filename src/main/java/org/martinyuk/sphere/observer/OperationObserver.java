package org.martinyuk.sphere.observer;

import java.util.EventObject;

public interface OperationObserver {
    void valueChanged(EventObject observed);
}

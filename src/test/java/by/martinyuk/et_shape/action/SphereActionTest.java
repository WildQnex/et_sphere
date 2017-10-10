package by.martinyuk.et_shape.action;

import by.martinyuk.sphere.action.SphereAction;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class SphereActionTest {

    private final double RADIUS1 = 3;

    private double value1;

    @BeforeClass
    public void setup(){
        value1 = 113.09733552923255;
    }

    @Test
    public void calculateVolumeTest(){
        assertEquals(SphereAction.getInstance().calculateVolume(RADIUS1), value1, 0.0001);
    }
}

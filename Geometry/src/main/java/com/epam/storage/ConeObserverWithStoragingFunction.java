package com.epam.storage;

import java.util.HashMap;
import java.util.Map;
import com.epam.calculator.Calculator;
import com.epam.entities.ConeObservable;
import com.epam.observation.Observer;

public class ConeObserverWithStoragingFunction implements Observer<ConeObservable>{

    private static ConeObserverWithStoragingFunction INSTANCE;
	/* Is it a good way to make all fields in Calculator class static to avoid
	 * creating instances in situation where we can avoid it? 
	 * 
	 * private final Calculator calculator = new Calculator() -- lesson 4 example;
	 */
    private final Map<Integer, ConeParametersForStoraging> parameters = new HashMap<>();

    private ConeObserverWithStoragingFunction() {
    	
    }
    
    /*Used static methods instead of object creation*/
    public void update (ConeObservable cone) {
    	double volume = Calculator.coneVolumeCalculation(cone);
    	double surfaceArea = Calculator.coneSurfaceAreaCalculation(cone);
    	parameters.put(cone.getId(), new ConeParametersForStoraging(volume, surfaceArea));
    }

    public ConeParametersForStoraging getDataById (Object key) {
        return parameters.get(key);
    }

    public static ConeObserverWithStoragingFunction getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConeObserverWithStoragingFunction();
        }
        return INSTANCE;
    }
}

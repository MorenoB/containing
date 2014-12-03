package org.nhl.containing.areas;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Spatial;
import org.nhl.containing.cranes.DockingCrane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeroen
 */
public class BoatArea extends Area {

    public List<DockingCrane> dockingCranes = new ArrayList();
    private AssetManager assetManager;
    private int craneZAxis = 0;
    private int craneRailsZAxis = -30;
    private int cranes;
    private int rails;

    public BoatArea(AssetManager assetmanager, int cranes, int rails) {
        this.assetManager = assetmanager;
        this.cranes = cranes;
        this.rails = rails;
        initBoatArea();
    }

    /**
     * Initialize a boat area.
     */
    private void initBoatArea() {

        // Add docking cranes to the list and scene.
        for (int i = 0; i < cranes; i++) {
            dockingCranes.add(new DockingCrane(assetManager));
            dockingCranes.get(i).setLocalTranslation(0, 0, craneZAxis);
            this.attachChild(dockingCranes.get(i));
            craneZAxis += 18;
        }

        // Add crane rails.
        Spatial craneRails = assetManager.loadModel("Models/rails/craneRails.j3o");
        for (int i = 0; i < rails; i++) {
            Spatial nextRail = craneRails.clone();
            nextRail.setLocalTranslation(42f, 0, craneRailsZAxis);
            nextRail.setLocalScale(0.89f, 1, 1);
            this.attachChild(nextRail);
            craneRailsZAxis += 11;
        }
    }
    
    public List<DockingCrane> getStorageCranes(){
        return dockingCranes;
    }
}

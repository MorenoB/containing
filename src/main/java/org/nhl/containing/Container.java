package org.nhl.containing;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Jeroen
 */
public class Container extends Node {

    private AssetManager assetManager;

    public Container(AssetManager assetManager) {
        this.assetManager = assetManager;
        initContainer();
    }

    /**
     * Initialize a container.
     */
    public void initContainer() {

        // Load a model.
        Spatial container = assetManager.loadModel("Models/medium/container/container.j3o");
        this.attachChild(container);
    }
}
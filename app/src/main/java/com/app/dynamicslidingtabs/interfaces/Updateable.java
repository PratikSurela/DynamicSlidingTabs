package com.app.dynamicslidingtabs.interfaces;

import com.app.dynamicslidingtabs.model.WorldpopulationItem;

import java.util.ArrayList;

/**
 * Created by Pratik Surela on 14/6/17.
 */

public interface Updateable {
    public void update(ArrayList<WorldpopulationItem> worldpopulationItems, int position);
}

package com.vish.vishal;

import java.util.List;

/**
 * Created by vishal on 4/8/2017.
 */

interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);

}

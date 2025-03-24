package strategy;

import base.Coordinates;
import base.FireStation;

import java.util.*;

interface IStrategy {

    List<FireStation> selectStations(List<FireStation> stations, Coordinates location, int vehiclesNeeded);
}

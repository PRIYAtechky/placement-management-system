package placementproject;


import java.util.List;

public interface PlacementService {
    Placement addPlacement(Placement placement);
    Placement updatePlacement(Integer id, Placement placement);
    void deletePlacement(Integer id);
    Placement getPlacementById(Integer id);
    List<Placement> getAllPlacements();
}

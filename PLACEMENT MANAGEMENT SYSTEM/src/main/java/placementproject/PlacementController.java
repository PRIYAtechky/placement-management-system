package placementproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping
    public Placement addPlacement(@RequestBody Placement placement) {
        return placementService.addPlacement(placement);
    }

    @PutMapping("/{id}")
    public Placement updatePlacement(@PathVariable Integer id, @RequestBody Placement placement) {
        return placementService.updatePlacement(id, placement);
    }

    @DeleteMapping("/{id}")
    public String deletePlacement(@PathVariable Integer id) {
        placementService.deletePlacement(id);
        return "Placement deleted successfully!";
    }

    @GetMapping("/{id}")
    public Placement getPlacementById(@PathVariable Integer id) {
        return placementService.getPlacementById(id);
    }

    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }
}

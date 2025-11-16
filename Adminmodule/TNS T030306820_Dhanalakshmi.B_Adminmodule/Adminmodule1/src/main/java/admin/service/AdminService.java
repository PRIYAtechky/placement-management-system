package admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Create a new admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get admin by ID
    public Admin getAdminById(Long id) throws AdminNotFoundException {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            throw new AdminNotFoundException("Admin not found with id: " + id);
        }
    }

    // Update admin details
    public Admin updateAdmin(Long id, Admin updatedAdmin) throws AdminNotFoundException {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(updatedAdmin.getName());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setPhoneNumber(updatedAdmin.getPhoneNumber());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + id));
    }

    // Delete admin by ID
    public void deleteAdmin(Long id) throws AdminNotFoundException {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            throw new AdminNotFoundException("Admin not found with id: " + id);
        }
    }
}

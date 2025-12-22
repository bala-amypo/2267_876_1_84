import com.example.demo.model.ServicePart;
import java.util.List;

public interface ServicePartService {

    ServicePart createPart(Long serviceEntryId, ServicePart part);

    // ✅ REQUIRED FOR TESTS
    ServicePart createPart(ServicePart part);

    ServicePart getPartById(Long id);

    List<ServicePart> getPartsByEntry(Long serviceEntryId);
}

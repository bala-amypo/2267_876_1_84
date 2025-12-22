public interface ServicePartService {

    ServicePart createPart(Long serviceEntryId, ServicePart part);

    ServicePart getPartById(Long id);

    List<ServicePart> getPartsByEntry(Long serviceEntryId);
}

package pvs.admin.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessRequestService {

	@Autowired
	AccessRequestRepo accessreqrepo;
	
	public AccessRequestEntity requestAccess(AccessRequestEntity req) {
		req.setStatus("PENDING");
		return accessreqrepo.save(req);
	}
	
	public void approveReq(Long id) {
		Optional<AccessRequestEntity> optional = accessreqrepo.findById(id);
		if(optional.isPresent()) {
			AccessRequestEntity request = optional.get();
			request.setStatus("APPROVED");
			accessreqrepo.save(request);
		}
		else {
			throw new RuntimeException("Request Not Found");
		}
	}
	
	public void rejectReq(Long id) {
		Optional<AccessRequestEntity> optional = accessreqrepo.findById(id);
		if(optional.isPresent()) {
			AccessRequestEntity request = optional.get();
			request.setStatus("REJECTED");
			accessreqrepo.save(request);
			
		}
		else {
			throw new RuntimeException("Request Not Found");
		}
	}
	
	public List<AccessRequestEntity> getAllRequests(){
		return accessreqrepo.findAll();
	}

	public List<AccessRequestEntity> showPendingReq(String status) {
		
		return accessreqrepo.findByStatus(status);
	}
}

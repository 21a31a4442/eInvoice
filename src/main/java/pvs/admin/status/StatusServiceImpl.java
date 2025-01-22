package pvs.admin.status;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements IStatusService {

	@Autowired
	StatusRepo statusrepo;

	@Override
	public List<StatusEntity> getAllColumns() {
		List<StatusEntity> list = statusrepo.findAll();
		return list;
	}

	@Override
	public StatusEntity addStatus(StatusEntity s) {
		StatusEntity status = statusrepo.save(s);
		return status;
	}

	@Override
	public StatusEntity getStatusbyId(Integer id) {
		Optional<StatusEntity> optional = statusrepo.findById(id);
		if(optional.isPresent()) {
			StatusEntity status = optional.get();
			return status;
		}
		return null;
	}

	@Override
	public void deleteStatus(Integer id) {
		statusrepo.deleteById(id);
		
	}

	@Override
	public boolean checkStatusName(String statusName) {
		boolean b = statusrepo.existsByAllIgnoreCaseStatusName(statusName);
		return b;
	}
	
	@Override
	public boolean checkStatusCode(String statusCode) {
		boolean b = statusrepo.existsByAllIgnoreCaseStatusCode(statusCode);
		return b;
	}
	
	
	@Override
	public boolean checkStatusCodeAndId(long id,String statuscode) {
		long l = statusrepo.updateDuplicateCode(id, statuscode);
		if(l>0) {
			return true;
		}
		return false;
	
	}
	
	@Override
	public boolean checkStatusNameAndId(long id,String statusname) {
		long l = statusrepo.updateDuplicateName(id, statusname);
		if(l>0) {
			return true;
		}
		return false;
	}
	
}

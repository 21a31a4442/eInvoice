package pvs.admin.designation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImpl implements IDesignationService {

	@Autowired
	DesignationRepo desnrepo;
	
	@Override
	public List<DesignationEntity> getAllColumns() {
		List<DesignationEntity> list = desnrepo.findAll();
		return list;
	}

	@Override
	public DesignationEntity addDesn(DesignationEntity d) {
		DesignationEntity designation = desnrepo.save(d);
		return designation;
	}

	@Override
	public DesignationEntity getDesnById(Integer id) {
		Optional<DesignationEntity> optional = desnrepo.findById(id);
		if(optional.isPresent()) {
			DesignationEntity d = optional.get();
			return d;
		}
		return null;
	}

	@Override
	public void deleteDesn(Integer id) {
		desnrepo.deleteById(id);
	}

	@Override
	public boolean checkDesnName(String desn_name) {
		boolean b = desnrepo.existsByAllIgnoreCasedesnName(desn_name);
		return b;
	}

	@Override
	public boolean checkDesnCode(String desn_code) {
		boolean b = desnrepo.existsByAllIgnoreCasedesnCode(desn_code);
		return b;
	}

	@Override
	public boolean checkDesnNameAndId(long id, String desnName) {
		long l = desnrepo.updateIdAndDesnName(id, desnName);
		if(l>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkDesnCodeAndId(long id, String desnCode) {
		long l = desnrepo.updateIdAndDesnCode(id, desnCode);
		if(l>0) {
			return true;
		}
		return false;
	}

}

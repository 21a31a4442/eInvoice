package pvs.admin.contactType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pvs.admin.ccType.CcTypeRepo;

@Service
public class ContactTypeServiceImpl implements IContactTypeService {

	@Autowired
	ContactTypeRepo contactrepo;
	
	@Override
	public List<ContactTypeEntity> getAllColumns() {
		List<ContactTypeEntity> list = contactrepo.findAll();
		return list;
	}

	@Override
	public ContactTypeEntity addCType(ContactTypeEntity c) {
		ContactTypeEntity ctype = contactrepo.save(c);
		return ctype;
	}

	@Override
	public ContactTypeEntity getCTypeById(Integer id) {
		Optional<ContactTypeEntity> optional = contactrepo.findById(id);
		if(optional.isPresent()) {
			ContactTypeEntity ctype = optional.get();
			return ctype;
		}
		return null;
	}

	@Override
	public void deleteCType(Integer id) {
		contactrepo.deleteById(id);
		
	}

	@Override
	public boolean checkCTypeName(String name) {
		boolean b = contactrepo.existsByAllIgnoreCaseName(name);
		return b;
	}
	
	@Override
	public boolean checkCtypeNameAndId(long id, String name) {
		long l = contactrepo.updateDuplicateName(id, name);
		if(l>0) {
			return true;
		}
		return false;
	}

}

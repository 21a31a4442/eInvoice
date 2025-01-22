package pvs.admin.contactType;

import java.util.List;

public interface IContactTypeService {

	List<ContactTypeEntity> getAllColumns();

	ContactTypeEntity addCType(ContactTypeEntity c);

	ContactTypeEntity getCTypeById(Integer id);

	void deleteCType(Integer id);

	boolean checkCTypeName(String name);

	boolean checkCtypeNameAndId(long id, String name);
	
}

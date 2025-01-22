package pvs.admin.ccType;

import java.util.List;

public interface ICcTypeService {

	List<CostCenterTypeEntity> getAllColumns();

	CostCenterTypeEntity addCcType(CostCenterTypeEntity c);

	CostCenterTypeEntity getCcTypeById(Integer id);

	void deleteCcType(Integer id);

	boolean checkCcTypeName(String name);

	boolean checkIdAndCctypeName(long id, String name);
}

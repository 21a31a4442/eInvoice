package pvs.admin.status;

import java.util.List;

public interface IStatusService {

	List<StatusEntity> getAllColumns();
	
	StatusEntity addStatus(StatusEntity s);
	
	StatusEntity getStatusbyId(Integer id);
	
	void deleteStatus(Integer id); //
	
	boolean checkStatusName(String status);
	
	boolean checkStatusCode(String code);
	
//	boolean checkStatusModule(String module);
	
	boolean checkStatusNameAndId(long id,String statusname);
	
	boolean checkStatusCodeAndId(long id,String statuscode);
	
//	boolean checkStatusModuleAndId(long id,String statusmodule);
	

	
}

package pvs.admin.state;

import java.util.List;

public interface IStateService {


	List<StateEntity> getAllColumns();
	
	StateEntity addState(StateEntity s);
	
	StateEntity getStateById(Integer id);
	
	void deleteState(Integer id);
	
	boolean checkStateName(String name);

	boolean checkStateNameAndId(Integer id, String state);
	
	
}

package pvs.admin.state;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements IStateService {

	@Autowired
	StateRepo staterepo;

	@Override
	public List<StateEntity> getAllColumns() {
		List<StateEntity> list = staterepo.findAll();
		return list;
	}

	@Override
	public StateEntity addState(StateEntity s) {
		StateEntity state = staterepo.save(s);
		return state;
	}

	@Override
	public StateEntity getStateById(Integer id) {
		Optional<StateEntity> optional = staterepo.findById(id);
		if(optional.isPresent()) {
			StateEntity state = optional.get();
			return state;
		}
		return null;
	}

	@Override
	public void deleteState(Integer id) {
		staterepo.deleteById(id);
		
	}

	@Override
	public boolean checkStateName(String name) {
		boolean b = staterepo.existsByAllIgnoreCaseStateName(name);
		return b;
	}

	@Override
	public boolean checkStateNameAndId(Integer id, String state) {
		long l = staterepo.updateIdAndState(id, state);
		if(l>0) {
			return true;
		}
		return false;
	}
	
}

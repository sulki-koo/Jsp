package jspmvc.service.impl;

import jspmvc.dao.impl.MVCInsertDAO;
import jspmvc.model.MVCDTO;
import jspmvc.service.MVCAbstractService;

public class MVCInsertService extends MVCAbstractService {

	@Override
	public int insert(MVCDTO dto) {
		return new MVCInsertDAO().insert(dto);
	}

}

package net.apptao.highway.server.dispatch;

import net.apptao.highway.shared.dispatch.HwyPut;
import net.apptao.highway.shared.dispatch.HwyPutResult;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

public class HwyPutHandler implements HwyHandler<HwyPut, HwyPutResult>{

	@Override
	public HwyPutResult execute(HwyPut action, ExecutionContext context)
			throws ActionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<HwyPut> getActionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rollback(HwyPut action, HwyPutResult result,
			ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub
		
	}

}

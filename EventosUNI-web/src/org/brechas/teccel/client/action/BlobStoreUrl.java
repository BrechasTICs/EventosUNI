package org.brechas.teccel.client.action;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.ActionImpl;
import org.brechas.teccel.client.action.BlobStoreUrlResult;

public class BlobStoreUrl extends ActionImpl<BlobStoreUrlResult> {

	@Inject
	public BlobStoreUrl() {
	}
	
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
}

package org.brechas.teccel.server.handler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import org.brechas.teccel.client.action.BlobStoreUrl;
import org.brechas.teccel.client.action.BlobStoreUrlResult;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class BlobStoreUrlActionHandler implements
		ActionHandler<BlobStoreUrl, BlobStoreUrlResult> {

	@Inject
	public BlobStoreUrlActionHandler() {
	}

	@Override
	public BlobStoreUrlResult execute(BlobStoreUrl action,
			ExecutionContext context) throws ActionException {
		BlobstoreService blobstoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		return new BlobStoreUrlResult(
				blobstoreService.createUploadUrl("/upload"));
	}

	@Override
	public void undo(BlobStoreUrl action, BlobStoreUrlResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<BlobStoreUrl> getActionType() {
		return BlobStoreUrl.class;
	}
}

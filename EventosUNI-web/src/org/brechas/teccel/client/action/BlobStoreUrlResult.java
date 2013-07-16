package org.brechas.teccel.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class BlobStoreUrlResult implements Result {

	private String uploadUrl;

	@SuppressWarnings("unused")
	private BlobStoreUrlResult() {
		// For serialization only
	}

	public BlobStoreUrlResult(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}
}

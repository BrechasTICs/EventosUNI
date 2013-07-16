package org.brechas.teccel.server.guice;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brechas.teccel.server.entity.Organizador;

import static org.brechas.teccel.server.objectify.OfyService.ofy;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(UploadServlet.class
			.getName());

	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
		BlobKey blobKey = blobs.get("image");

		if (blobKey == null) {

		} else {

			ImagesService imagesService = ImagesServiceFactory
					.getImagesService();
			String imageUrl = imagesService.getServingUrl(blobKey);

			UserService userService = UserServiceFactory.getUserService();
			// TODO: Add a better check for whether the user is logged in or not
			// Don't even let the user upload or get here
			User user = userService.getCurrentUser();
			Organizador org = ofy().load().type(Organizador.class)
					.filter("nombre", (String) req.getParameter("name"))
					.first().now();
			org.setLogoBlobKey(blobKey.getKeyString());
			org.setLogoUrl(imageUrl);
			org.set_updatedBy(user.getEmail());
			org.set_updatedAt(new Date());
			ofy().save().entity(org);
			String keyString = org.getId();
			res.sendRedirect("/upload?uploadedImageKey=" + keyString);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String uploadedImageKey = req.getParameter("uploadedImageKey");
		resp.setHeader("Content-Type", "text/html");

		// This is a bit hacky, but it'll work. We'll use this key in an Async
		// service to
		// fetch the image and image information
		resp.getWriter().println(uploadedImageKey);

	}
}

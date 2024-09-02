package sample.application;

/**
 * @author Amal2
 */
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;


@Component(
		property = {
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
		},
		service = Application.class)
public class SampleApplication extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@Reference
	private FileDataHandler fileDataHandler;

	@GET
	@Path("/{filename}")
	@Produces("application/xml; charset=UTF-8")
	public Response getFileData(@PathParam("filename") String filename) {
		try {
			String xmlData = fileDataHandler.readFileDataAsJson(filename); // إذا كنت تستخدم XML، يمكنك تغيير هذا الأسلوب ليعكس XML بدلاً من JSON
			return Response.ok(xmlData, MediaType.APPLICATION_XML)
					.header("Content-Type", "application/xml; charset=UTF-8")
					.build();
		} catch (IOException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("<error>File not found: " + filename + "</error>")
					.header("Content-Type", "application/xml; charset=UTF-8")
					.build();
		}
	}

	@GET
	@Path("/test")
	@Produces("text/plain")
	public Response testAPI() {
		return Response.ok("API is working").build();
	}

}

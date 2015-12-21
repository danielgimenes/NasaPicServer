package br.com.dgimenes.nasapicserver.control

import br.com.dgimenes.nasapicserver.model.SpacePic
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
class FeedResource(val persistenceUnit: String?) {

    @Path("/list")
    @GET
    fun userFeedMessages(@QueryParam("device-id") deviceId : String?) : List<SpacePic>? {
        // TODO register that the user with device-id requested for the feed
        return FeedRepository(persistenceUnit).getFeedForUser(deviceId)
    }
}
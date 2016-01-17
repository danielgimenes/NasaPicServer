package br.com.dgimenes.nasapicserver.control

import br.com.dgimenes.nasapicserver.model.SpacePicDTO
import com.fasterxml.jackson.annotation.JsonProperty
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.*

const val RESOURCE_PATH = "/feed"
const val FEED_PATH = "/list"

@Path(RESOURCE_PATH)
@Produces(MediaType.APPLICATION_JSON)
class FeedResource(val persistenceUnit: String?) {

    @Context
    lateinit var uriInfo : UriInfo

    // TODO register that the user with device-id requested for the feed?

    @Path(FEED_PATH)
    @GET
    fun userFeedMessages(@QueryParam("device-id") deviceId: String?, @QueryParam("page") page: Int?)
            : Response {
        val lastPage = 30
        val firstPage = 1
        val currPage = if (page ?: firstPage > lastPage) lastPage else if (page ?: firstPage < firstPage) firstPage
            else page ?: firstPage
        val nextPage = if (currPage == lastPage) null else currPage+1
        val feedResult = FeedDTO(FeedRepository(persistenceUnit).getFeedForUser(deviceId, currPage)!!)
        feedResult.paging = PagingData(getFeedUrl(currPage), if (nextPage != null) getFeedUrl(nextPage) else null)

        val cc = CacheControl()
        val MAX_CACHE_IN_HOURS = 12
        cc.maxAge = 60 * 60 * MAX_CACHE_IN_HOURS
        cc.isPrivate = true
        return Response.ok(feedResult).cacheControl(cc).build()
    }

    private fun getFeedUrl(page: Int) =
            "${uriInfo.baseUri.toString().removeSuffix("/")}$RESOURCE_PATH$FEED_PATH?page=$page"
}

data class FeedDTO(val data: List<SpacePicDTO>) {
    var paging: PagingData? = null
}

class PagingData(currPageUrl: String, nextPageUrl: String?) {

    var currPageUrl: String = currPageUrl
        @JsonProperty("current-page") get

    var nextPageUrl: String? = nextPageUrl
        @JsonProperty("next-page") get

}
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
        return FeedRepository(persistenceUnit).getFeedForUser(deviceId)
    }

    @Path("/teste")
    @GET
    fun teste() : String {
        return """[
        {
            "id": "1",
            "content-type": "html",
            "published-at": "2015-12-10T00:00:00.000-0300",
            "message": "Fundamentos do pensamento sociológico<br>&nbsp;&nbsp;Sociologia<hr>Radioatividade epartículas radioativas<br>&nbsp;&nbsp;Química"
        },
        {
            "id": "2",
            "content-type": "html",
            "published-at" : "2015-12-08T00:00:00.000-0300",
            "message": "Estado e relações de poder<br>&nbsp;&nbsp;Sociologia<hr>Funcionalidade das variantes linguísticas<br>&nbsp;&nbsp;Portugês<hr>Nomenclatura biológica e organização dos seres em reinos<br>&nbsp;&nbsp;Biologia<hr>Pré-História<br>&nbsp;&nbsp;História<hr>Radioatividade epartículas radioativas<br>&nbsp;&nbsp;Química"

        },
        {
            "id": "1",
            "content-type": "html",
            "published-at": "2015-12-06T00:00:00.000-0300",
            "message": "Inequação do 1º grau<br>&nbsp;&nbsp;Matemática"
        }
        ]"""
    }
}
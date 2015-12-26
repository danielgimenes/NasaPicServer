package br.com.dgimenes.nasapicserver.control

import br.com.dgimenes.nasapicserver.model.SpacePic
import br.com.dgimenes.nasapicserver.model.SpacePicDTO
import br.com.dgimenes.nasapicserver.model.SpacePicStatus
import javax.persistence.EntityManager
import javax.persistence.Persistence

class FeedRepository {
    var em : EntityManager? = null

    constructor(persistenceUnit: String?) {
        val factory = Persistence.createEntityManagerFactory(persistenceUnit);
        em = factory.createEntityManager();
    }

    fun getFeedForUser(deviceId: String?) : List<SpacePicDTO>? {
        val query = em!!.createQuery("from SpacePic where status = :status order by originallyPublishedAt desc");
        query.setMaxResults(10)
        query.setParameter("status", SpacePicStatus.PUBLISHED)
        val spacePics = query.resultList as List<SpacePic>?
        return spacePics!!.map { SpacePicDTO(it) }
    }
}
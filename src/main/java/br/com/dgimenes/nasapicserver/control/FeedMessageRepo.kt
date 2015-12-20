package br.com.dgimenes.nasapicserver.control

import br.com.dgimenes.nasapicserver.model.SpacePic
import javax.persistence.EntityManager
import javax.persistence.Persistence

class FeedRepository {
    var em : EntityManager? = null

    constructor(persistenceUnit: String?) {
        val factory = Persistence.createEntityManagerFactory(persistenceUnit);
        em = factory.createEntityManager();
    }

    fun getFeedForUser(deviceId: String?) : List<SpacePic>? {
//        val query = em!!.createQuery("from FeedMessage where membership = :membershipId");
//        query.setParameter("membershipId", membershipId)
//        val feedMessages = query.resultList as List<FeedMessage>
//        return feedMessages
        return null
    }
}
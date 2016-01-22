package br.com.dgimenes.nasapicserver.control

import br.com.dgimenes.nasapicserver.model.SpacePic
import br.com.dgimenes.nasapicserver.model.SpacePicDTO
import br.com.dgimenes.nasapicserver.model.SpacePicStatus
import org.joda.time.DateTime
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class SpacePicRepository {
    val factory : EntityManagerFactory
    var em : EntityManager

    constructor(persistenceUnit: String?) {
        factory = Persistence.createEntityManagerFactory(persistenceUnit)
        em = factory.createEntityManager();
    }

    fun getFeedForUser(deviceId: String?, page: Int) : List<SpacePicDTO>? {
        val query = em.createQuery("""
            FROM SpacePic
            WHERE status = :status
            ORDER BY originallyPublishedAt DESC
            """)
        val pageSize = 5
        query.setFirstResult((page - 1) * pageSize)
        query.setMaxResults(pageSize)
        query.setParameter("status", SpacePicStatus.PUBLISHED)
        val spacePics = query.resultList as List<SpacePic>?
        return spacePics!!.map { SpacePicDTO(it) }
    }

    fun getBestPictures(page: Int) : List<SpacePicDTO>? {
        val query = em.createQuery("""
            FROM SpacePic
            WHERE status = :status
            AND best = True
            ORDER BY originallyPublishedAt DESC
            """)
        val pageSize = 5
        query.setFirstResult((page - 1) * pageSize)
        query.setMaxResults(pageSize)
        query.setParameter("status", SpacePicStatus.PUBLISHED)
        val spacePics = query.resultList as List<SpacePic>?
        return spacePics!!.map { SpacePicDTO(it) }
    }

    fun destroy() {
        em.close()
        factory.close()
    }
}
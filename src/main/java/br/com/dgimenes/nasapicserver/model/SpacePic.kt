package br.com.dgimenes.nasapicserver.model

import java.util.*
import javax.persistence.*


@Table(name = "space_pic"
        // TODO create index in an automated way
        //, indexes = { @Index(name = "my_index_name2", columnList = "name", unique = false) }
)
@Entity(name = "SpacePic")
class SpacePic {

    @Id
    @SequenceGenerator(name = "space_pic_id_seq", sequenceName = "space_pic_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "space_pic_id_seq")
    @Column(updatable = false)
    var id: Int? = null
        get

    @Column(nullable = true, length = 768)
    var hdImageUrl: String? = null
        get

    @Column(nullable = true, length = 768)
    var previewImageUrl: String? = null
        get

    @Column(nullable = false, length = 768)
    var originalApiUrl: String? = null
        get

    @Column(nullable = false, length = 768)
    var originalApiImageUrl: String? = null
        get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    var originallyPublishedAt: Date? = null
        get

    @Column(nullable = false, length = 256)
    var title: String? = null
        get

    @Column(nullable = true, length = 2560)
    var description: String? = null
        get

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date? = null
        get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    var publishedAt: Date? = null
        get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = null
        get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    var deletedAt: Date? = null
        get

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    var status: SpacePicStatus? = null
        get

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    var source: SpacePicSource? = null
        get
}

enum class SpacePicSource {
    NASA_APOD,
    NASA_IOTD
}

enum class SpacePicStatus {
    CREATED,
    PUBLISHED,
    DELETED
}

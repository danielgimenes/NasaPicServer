package br.com.dgimenes.nasapicserver.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*


@Table(name = "space_pic"
        // TODO create index in an automated way
        //, indexes = { @Index(name = "my_index_name2", columnList = "name", unique = false) }
)
@Entity(name = "SpacePic")
class SpacePic {

    // TODO split class in entity and dto

    @Id
    @SequenceGenerator(name = "space_pic_id_seq", sequenceName = "space_pic_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "space_pic_id_seq")
    @Column(updatable = false)
    var id: Int? = null
        @JsonProperty get

    @Column(nullable = true, length = 768)
    var hdImageUrl: String? = null
        @JsonProperty get

    @Column(nullable = true, length = 768)
    var previewImageUrl: String? = null
        @JsonProperty get

    @Column(nullable = false, length = 768)
    var originalApiUrl: String? = null
        @JsonProperty get

    @Column(nullable = false, length = 768)
    var originalApiImageUrl: String? = null
        @JsonProperty get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var originallyPublishedAt: Date? = null
        @JsonProperty get

    @Column(nullable = false, length = 256)
    var title: String? = null
        @JsonProperty get

    @Column(nullable = true, length = 2560)
    var description: String? = null
        @JsonProperty get

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var createdAt: Date? = null
        @JsonProperty("created-at") get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var publishedAt: Date? = null
        @JsonProperty("published-at") get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var updatedAt: Date? = null
        @JsonProperty("updated-at") get

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var deletedAt: Date? = null
        @JsonProperty("deleted-at") get

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    var status: SpacePicStatus? = null
        @JsonProperty get

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    var source: SpacePicSource? = null
        @JsonProperty get
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

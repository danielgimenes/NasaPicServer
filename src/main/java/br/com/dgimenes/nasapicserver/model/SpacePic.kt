package br.com.dgimenes.nasapicserver.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*


@Table(name = "space_pic"
        //, indexes = { @Index(name = "my_index_name2", columnList = "name", unique = false) }
)
@Entity(name = "SpacePic")
class SpacePic() {

    @Id
    @SequenceGenerator(name = "space_pic_id_seq",
            sequenceName = "space_pic_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "space_pic_id_seq")
    @Column(updatable = false)
    var id: Int? = null
        @JsonProperty get

    @Column(nullable = false, length = 1000)
    var message: String? = null
        @JsonProperty get

    @Column(nullable = false)
    var contentType: String? = null
        @JsonProperty("content-type") get

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var publishedAt: Date? = null
        @JsonProperty("published-at") get

    @Column(nullable = true)
    var membership: String? = null
        @JsonProperty get
}
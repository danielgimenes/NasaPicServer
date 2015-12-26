package br.com.dgimenes.nasapicserver.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*

class SpacePicDTO {

    constructor(spacePic: SpacePic) {
        this.id = spacePic.id
        this.hdImageUrl = spacePic.hdImageUrl
        this.previewImageUrl = spacePic.previewImageUrl
        this.originallyPublishedAt = spacePic.originallyPublishedAt
        this.title = spacePic.title
        this.description = spacePic.description
        this.publishedAt = spacePic.publishedAt
        this.source = spacePic.source
    }

    var id: Int? = null
        @JsonProperty get

    var hdImageUrl: String? = null
        @JsonProperty("hd-image-url") get

    var previewImageUrl: String? = null
        @JsonProperty("preview-image-url") get

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var originallyPublishedAt: Date? = null
        @JsonProperty("originally-published-at") get

    var title: String? = null
        @JsonProperty get

    var description: String? = null
        @JsonProperty get

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    var publishedAt: Date? = null
        @JsonProperty("published-at") get

    var source: SpacePicSource? = null
        @JsonProperty get
}

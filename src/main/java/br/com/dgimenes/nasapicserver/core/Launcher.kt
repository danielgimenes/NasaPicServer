package br.com.dgimenes.nasapicserver.core

import br.com.dgimenes.nasapicserver.control.FeedResource
import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.hibernate.validator.constraints.NotEmpty

fun main(args: Array<String>) {
    NasaPicServerApplication().run(*args)
}

class NasaPicServerApplication : Application<NasaPicServerConfig>() {
    override fun getName(): String {
        return "nasapicserver"
    }

    override fun initialize(bootstrap: Bootstrap<NasaPicServerConfig>) {

    }

    override fun run(configuration: NasaPicServerConfig, environment: Environment) {
        val resource = FeedResource(configuration.persistenceUnit)
        environment.jersey().register(resource);
    }
}

class NasaPicServerConfig : Configuration() {
    @NotEmpty
    var persistenceUnit: String? = null
        @JsonProperty get
        @JsonProperty set
}
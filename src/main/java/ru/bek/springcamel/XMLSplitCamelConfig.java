package ru.bek.springcamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XMLSplitCamelConfig extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:changesfile")
                .split(xpath("/osm/changeset"))
                .setBody(xpath("//@id").stringResult())
                .log("${body}")
                .end();
    }
}

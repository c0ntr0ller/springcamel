package ru.bek.springcamel;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class XMLSplitRunner implements CommandLineRunner {
    @Value("${xmlfilename}")
    private String inFileName;

    @Autowired
    CamelContext camelContext;

    @Override
    public void run(String... args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(inFileName);

        camelContext.createProducerTemplate()
                .sendBody("direct:changesfile",fileInputStream);
    }
}

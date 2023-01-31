package org.acme.controller;

import org.acme.dto.StaticticsResult;
import org.acme.repository.GeneratedRandomNumbersRepository;
import org.acme.services.DbRandomNumber;
import org.acme.services.ReportService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/api")
public class RandomNumbersController {
    @Inject
    private ReportService reportService;

    @Inject
    private GeneratedRandomNumbersRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getResults() throws IOException, URISyntaxException, InterruptedException {
        StaticticsResult staticticsResult = reportService.getResults();
        System.out.println( "Max:"+staticticsResult.getMax()+
                            " Min:"+staticticsResult.getMin()+
                            " Sum:"+staticticsResult.getSum()+
                            " Avarage:" + staticticsResult.getAverage());
        return staticticsResult.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getById(@PathParam("id") Long id){

        return repository.findByIdOptional(id)
                .map(generatedRandomNumbers -> Response.ok(generatedRandomNumbers).build())
                .orElse(Response.status(NOT_FOUND).build());
    }


}
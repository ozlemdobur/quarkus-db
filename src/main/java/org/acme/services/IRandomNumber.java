package org.acme.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IRandomNumber {
    Integer[] getNumber() throws IOException, URISyntaxException, InterruptedException;
}

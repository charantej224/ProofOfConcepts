
package com.esbutility.application.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endpoint",
    "expectedParameters",
    "requestTemplate",
    "generatedParams",
    "requestGeneratedParams",
    "esbResponseQueries",
    "responseMustacheTemplate"
})
public class ApiConfiguration {

    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("expectedParameters")
    private List<ExpectedParameter> expectedParameters = null;
    @JsonProperty("requestTemplate")
    private String requestTemplate;
    @JsonProperty("generatedParams")
    private List<GeneratedParam> generatedParams = null;
    @JsonProperty("requestGeneratedParams")
    private List<RequestGeneratedParam> requestGeneratedParams = null;
    @JsonProperty("esbResponseQueries")
    private List<EsbResponseQuery> esbResponseQueries = null;
    @JsonProperty("responseMustacheTemplate")
    private String responseMustacheTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ApiConfiguration() {
    }

    /**
     * 
     * @param generatedParams
     * @param esbResponseQueries
     * @param requestTemplate
     * @param requestGeneratedParams
     * @param responseMustacheTemplate
     * @param expectedParameters
     * @param endpoint
     */
    public ApiConfiguration(String endpoint, List<ExpectedParameter> expectedParameters, String requestTemplate, List<GeneratedParam> generatedParams, List<RequestGeneratedParam> requestGeneratedParams, List<EsbResponseQuery> esbResponseQueries, String responseMustacheTemplate) {
        super();
        this.endpoint = endpoint;
        this.expectedParameters = expectedParameters;
        this.requestTemplate = requestTemplate;
        this.generatedParams = generatedParams;
        this.requestGeneratedParams = requestGeneratedParams;
        this.esbResponseQueries = esbResponseQueries;
        this.responseMustacheTemplate = responseMustacheTemplate;
    }

    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @JsonProperty("expectedParameters")
    public List<ExpectedParameter> getExpectedParameters() {
        return expectedParameters;
    }

    @JsonProperty("expectedParameters")
    public void setExpectedParameters(List<ExpectedParameter> expectedParameters) {
        this.expectedParameters = expectedParameters;
    }

    @JsonProperty("requestTemplate")
    public String getRequestTemplate() {
        return requestTemplate;
    }

    @JsonProperty("requestTemplate")
    public void setRequestTemplate(String requestTemplate) {
        this.requestTemplate = requestTemplate;
    }

    @JsonProperty("generatedParams")
    public List<GeneratedParam> getGeneratedParams() {
        return generatedParams;
    }

    @JsonProperty("generatedParams")
    public void setGeneratedParams(List<GeneratedParam> generatedParams) {
        this.generatedParams = generatedParams;
    }

    @JsonProperty("requestGeneratedParams")
    public List<RequestGeneratedParam> getRequestGeneratedParams() {
        return requestGeneratedParams;
    }

    @JsonProperty("requestGeneratedParams")
    public void setRequestGeneratedParams(List<RequestGeneratedParam> requestGeneratedParams) {
        this.requestGeneratedParams = requestGeneratedParams;
    }

    @JsonProperty("esbResponseQueries")
    public List<EsbResponseQuery> getEsbResponseQueries() {
        return esbResponseQueries;
    }

    @JsonProperty("esbResponseQueries")
    public void setEsbResponseQueries(List<EsbResponseQuery> esbResponseQueries) {
        this.esbResponseQueries = esbResponseQueries;
    }

    @JsonProperty("responseMustacheTemplate")
    public String getResponseMustacheTemplate() {
        return responseMustacheTemplate;
    }

    @JsonProperty("responseMustacheTemplate")
    public void setResponseMustacheTemplate(String responseMustacheTemplate) {
        this.responseMustacheTemplate = responseMustacheTemplate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

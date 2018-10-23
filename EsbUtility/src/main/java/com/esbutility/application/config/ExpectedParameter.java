
package com.esbutility.application.config;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "type",
    "jsonpathPattern"
})
public class ExpectedParameter {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("jsonpathPattern")
    private String jsonpathPattern;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExpectedParameter() {
    }

    /**
     * 
     * @param jsonpathPattern
     * @param name
     * @param type
     */
    public ExpectedParameter(String name, String type, String jsonpathPattern) {
        super();
        this.name = name;
        this.type = type;
        this.jsonpathPattern = jsonpathPattern;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("jsonpathPattern")
    public String getJsonpathPattern() {
        return jsonpathPattern;
    }

    @JsonProperty("jsonpathPattern")
    public void setJsonpathPattern(String jsonpathPattern) {
        this.jsonpathPattern = jsonpathPattern;
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


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
    "jsonPath",
    "type"
})
public class EsbResponseQuery {

    @JsonProperty("name")
    private String name;
    @JsonProperty("jsonPath")
    private String jsonPath;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EsbResponseQuery() {
    }

    /**
     * 
     * @param name
     * @param type
     * @param jsonPath
     */
    public EsbResponseQuery(String name, String jsonPath, String type) {
        super();
        this.name = name;
        this.jsonPath = jsonPath;
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("jsonPath")
    public String getJsonPath() {
        return jsonPath;
    }

    @JsonProperty("jsonPath")
    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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

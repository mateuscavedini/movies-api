package io.github.mateuscavedini.moviesapi.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientSearchResponseDto {
    @JsonProperty("Search")
    private Set<ClientMovieResponseDto> searchResults = new HashSet<>();
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("Response")
    private String responseStatus;

    public ClientSearchResponseDto() {}

    public ClientSearchResponseDto(Set<ClientMovieResponseDto> searchResults, String totalResults, String responseStatus) {
        this.searchResults = searchResults;
        this.totalResults = totalResults;
        this.responseStatus = responseStatus;
    }

    public Set<ClientMovieResponseDto> getSearchResults() {
        return searchResults;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponseStatus() {
        return responseStatus;
    }
}

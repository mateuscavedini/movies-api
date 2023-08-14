package io.github.mateuscavedini.moviesapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.mateuscavedini.moviesapi.model.dto.ClientMovieResponseDto;
import io.github.mateuscavedini.moviesapi.model.dto.ClientSearchResponseDto;

@FeignClient(name = "omdbClient", url = "${client.omdb.base-url}")
public interface OmdbClient {
    @GetMapping
    public ClientMovieResponseDto getMovieByImdbId(@RequestParam(name = "i") String imdbId);

    @GetMapping
    public ClientMovieResponseDto getMovieByTitle(@RequestParam(name = "t") String title);

    @GetMapping
    public ClientSearchResponseDto searchMoviesByTitle(@RequestParam(name = "s") String title);
}

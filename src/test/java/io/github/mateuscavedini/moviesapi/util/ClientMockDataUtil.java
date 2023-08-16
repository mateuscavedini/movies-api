package io.github.mateuscavedini.moviesapi.util;

import io.github.mateuscavedini.moviesapi.model.dto.ClientMovieResponseDto;

public final class ClientMockDataUtil {
    private ClientMockDataUtil() {}

    public static ClientMovieResponseDto mockClientMovieResponseDtoA() {
        return new ClientMovieResponseDto("aa0000000", "Mocked ClientMovieResponseDto A", "2022", "This is a mock.", "www.mock-a-poster-url.com");
    }
}

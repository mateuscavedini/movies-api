package io.github.mateuscavedini.moviesapi.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateListDto {
    @NotNull(message = "ListTypeId must not be null.")
    @Positive(message = "ListTypeId must be a positive number.")
    private Long listTypeId;
    
    @NotNull(message = "UserId must not be null.")
    @Positive(message = "UserId must be a positive number.")
    private Long userId;

    public CreateListDto() {}

    public CreateListDto(Long listTypeId, Long userId) {
        this.listTypeId = listTypeId;
        this.userId = userId;
    }

    public Long getListTypeId() {
        return listTypeId;
    }

    public Long getUserId() {
        return userId;
    }
}

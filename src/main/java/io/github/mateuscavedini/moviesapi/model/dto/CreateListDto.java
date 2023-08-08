package io.github.mateuscavedini.moviesapi.model.dto;

public class CreateListDto {
    private Long listTypeId;
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

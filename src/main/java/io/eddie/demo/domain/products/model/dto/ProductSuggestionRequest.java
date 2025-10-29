package io.eddie.demo.domain.products.model.dto;

public record ProductSuggestionRequest(
        String prefix,
        Integer limit
) {
}

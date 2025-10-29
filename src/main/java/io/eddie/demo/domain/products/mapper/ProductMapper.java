package io.eddie.demo.domain.products.mapper;

import io.eddie.demo.domain.products.model.dto.ProductDescription;
import io.eddie.demo.domain.products.model.entity.Product;
import io.eddie.demo.domain.products.model.entity.ProductDocumentEntity;

public class ProductMapper {

    public static ProductDescription toDescription(Product product) {
        return new ProductDescription(
                product.getCode(),
                product.getAccountCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreatedAt()
        );
    }

    public static ProductDescription toDescription(ProductDocumentEntity document) {
        return new ProductDescription(
                null,
                document.getAccountCode(),
                document.getName(),
                document.getDescription(),
                document.getPrice(),
                document.getCreatedAt()
        );
    }

    public static ProductDocumentEntity toDocument(Product product){
        return new ProductDocumentEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAccountCode(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}

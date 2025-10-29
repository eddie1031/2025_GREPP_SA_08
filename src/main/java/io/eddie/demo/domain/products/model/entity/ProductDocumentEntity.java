package io.eddie.demo.domain.products.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "exp-products")
public class ProductDocumentEntity {

    @Id
    private Long id;

    @MultiField(
            mainField = @Field(type = FieldType.Text, analyzer = "nori_analyzer", searchAnalyzer = "nori_synonym_analyzer"),
            otherFields = {
                    @InnerField(suffix = "completion", type = FieldType.Search_As_You_Type),
                    @InnerField(suffix = "keyword", type = FieldType.Keyword, normalizer = "lowercase_normalizer"),
                    @InnerField(suffix = "ngram", type = FieldType.Text, analyzer = "edge_ngram_analyzer", searchAnalyzer = "nori_synonym_analyzer")
            }
    )
    private String name;

    private String description;

    @Field(type = FieldType.Long)
    private Long price;

    @Field(type = FieldType.Keyword)
    private String accountCode;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime createdAt;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime updatedAt;


}

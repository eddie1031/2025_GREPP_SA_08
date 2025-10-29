package io.eddie.demo.domain.products.repository;

import io.eddie.demo.domain.products.model.entity.ProductDocumentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductElasticRepository extends ElasticsearchRepository<ProductDocumentEntity, Long> {


    @Query("""
    {
        "multi_match": {
            "query": "#{#searchTerm}",
            "type": "bool_prefix",
            "fields": [
                "name.suggest",
                "name.ngram"
            ]
        }
    }
    """)
    SearchHits<ProductDocumentEntity> autoComplete(String searchTerm);


    @Query("""
    {
        "multi_match": {
            "query": "#{#query}",
            "fields": [
                "name^3",
                "name.ngram^2"
            ],
            "type": "best_fields",
            "fuzziness": "2"
        }
    }
    """)
    SearchPage<ProductDocumentEntity> search(String query, Pageable pageable);

}

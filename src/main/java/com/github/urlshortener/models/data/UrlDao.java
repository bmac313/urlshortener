package com.github.urlshortener.models.data;

import com.github.urlshortener.models.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UrlDao extends CrudRepository<Url, Integer> {
}

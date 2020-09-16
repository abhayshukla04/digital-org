package com.engg.digitalorg.repository;

import com.engg.digitalorg.model.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * The interface Url repository.
 */
@Transactional
public interface UrlRepository extends JpaRepository<Url, Integer> {

    /**
     * Update url.
     *
     * @param long_url     the long url
     * @param short_url    the short url
     * @param expires_date the expires date
     * @param id           the id
     */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Url u SET u.long_url = :long_url, u.short_url = :short_url, u.expires_date = :expires_date WHERE u.id = :id")
    void updateUrl(@Param("long_url") String long_url, @Param("short_url") String short_url, @Param("expires_date") Date expires_date, @Param("id") int id);

}

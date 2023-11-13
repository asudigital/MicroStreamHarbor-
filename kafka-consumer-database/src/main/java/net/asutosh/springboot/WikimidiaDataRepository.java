package net.asutosh.springboot;

import net.asutosh.springboot.entity.WikimidiaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimidiaDataRepository  extends JpaRepository<WikimidiaData , Long> {
}

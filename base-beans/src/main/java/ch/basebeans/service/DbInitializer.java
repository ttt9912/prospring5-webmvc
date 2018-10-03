package ch.basebeans.service;

import ch.basebeans.entity.Singer;
import ch.basebeans.repository.SingerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Slf4j
@Service
public class DbInitializer {

    @Autowired
    private SingerRepository singerRepository;

    @PostConstruct
    public void initDB() {
        log.info("Starting database initialization...");
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(LocalDate.of(1977, 9, 16));
        singerRepository.save(singer);

        singer = new Singer();
        singer.setFirstName("Eric");
        singer.setLastName("Clapton");
        singer.setBirthDate(LocalDate.of(1945, 2, 13));
        singerRepository.save(singer);

        singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Butler");
        singer.setBirthDate(LocalDate.of(1975, 3, 1));

        singerRepository.save(singer);
        log.info("Database initialization finished.");
    }
}

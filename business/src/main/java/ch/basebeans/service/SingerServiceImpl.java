package ch.basebeans.service;

import ch.basebeans.entity.Singer;
import ch.basebeans.repository.SingerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService{

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    public List<Singer> findByFirstName(final String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    public Singer findById(final Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(final Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void delete(final Singer singer) {
        singerRepository.delete(singer);
    }
}
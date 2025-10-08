package hu.unideb.inf.jatekertekelo.service.impl;

import hu.unideb.inf.jatekertekelo.data.entity.JatekEntity;
import hu.unideb.inf.jatekertekelo.data.repository.JatekRepository;
import hu.unideb.inf.jatekertekelo.service.JatekService;
import hu.unideb.inf.jatekertekelo.service.dto.JatekCardDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class JatekServiceImpl implements JatekService {

    final ModelMapper modelMapper;
    final JatekRepository repo;

    public JatekServiceImpl(JatekRepository repo,
                            ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public JatekCardDto getById(Long id) {
        JatekEntity jatekEntity = repo.getReferenceById(id);
        JatekCardDto jatekCardDto = modelMapper
                .map(jatekEntity, JatekCardDto.class);
        return jatekCardDto;
    }

    @Override
    public JatekCardDto getByCim(String cim) {
        //JatekEntity e = repo.getByCim(cim);
        //return modelMapper.map(e, JatekCardDto.class);

        List<JatekEntity> jateks = repo.findAll();
        for (JatekEntity jatekEntity : jateks) {
            if (jatekEntity.getCim().equals(cim)) {
                return modelMapper.map(jatekEntity, JatekCardDto.class);
            }
        }
        return null;
    }

    @Override
    public List<JatekCardDto> getAll() {
        List<JatekEntity> jatekEntities = repo.findAll();

        Type listType =
                new TypeToken<List<JatekCardDto>>(){}.getType();
        List<JatekCardDto> jatekCardDtos = modelMapper
                .map(jatekEntities, listType);
        return jatekCardDtos;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public JatekCardDto save(JatekCardDto jatekCardDto) {
        JatekEntity entity = modelMapper
                .map(jatekCardDto, JatekEntity.class);

        entity = repo.save(entity);
        jatekCardDto = modelMapper
                .map(entity, JatekCardDto.class);
        return jatekCardDto;
    }
}

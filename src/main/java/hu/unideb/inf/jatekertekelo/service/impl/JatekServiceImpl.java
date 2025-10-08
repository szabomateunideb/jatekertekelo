package hu.unideb.inf.jatekertekelo.service.impl;

import hu.unideb.inf.jatekertekelo.data.entity.JatekEntity;
import hu.unideb.inf.jatekertekelo.data.repository.JatekRepository;
import hu.unideb.inf.jatekertekelo.service.JatekService;
import hu.unideb.inf.jatekertekelo.service.dto.JatekCardDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<JatekCardDto> getAll() {
        return List.of();
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

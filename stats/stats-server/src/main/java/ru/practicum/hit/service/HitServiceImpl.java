package ru.practicum.hit.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.hit.mapper.HitMapper;
import ru.practicum.hit.mapper.ViewStatsMapper;
import ru.practicum.hit.repository.StatsRepository;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.ViewStatsDto;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class HitServiceImpl implements HitService {
    private final ViewStatsMapper viewStatsMapper;
    private final StatsRepository statsRepository;
    private final HitMapper hitMapper;

    @Override
    @Transactional
    public void saveHit(HitDto hitDto) {
        statsRepository.save(hitMapper.toEntity(hitDto));
    }

    @Override
    public List<ViewStatsDto> getHits(LocalDateTime start,
                                      LocalDateTime end,
                                      List<String> uris,
                                      boolean unique) {
        return statsRepository.getStats(start, end, uris, unique)
                .stream()
                .map(viewStatsMapper::toDto)
                .collect(toList());
    }
}

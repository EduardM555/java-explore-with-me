package ru.practicum.hit.mapper;

import org.mapstruct.Mapper;
import ru.practicum.hit.entity.ViewStats;
import ru.practicum.stats.dto.ViewStatsDto;

@Mapper(componentModel = "spring")
public interface ViewStatsMapper {
    ViewStatsDto toDto(ViewStats viewStats);
}

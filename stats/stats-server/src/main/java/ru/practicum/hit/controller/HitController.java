package ru.practicum.hit.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.hit.service.HitService;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.ViewStatsDto;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@AllArgsConstructor
public class HitController {
    private final HitService hitService;

    @PostMapping("/hit")
    @ResponseStatus(CREATED)
    public void saveHit(@RequestBody @Valid HitDto hitDto) {
        hitService.saveHit(hitDto);
    }

    @GetMapping("/stats")
    public List<ViewStatsDto> getStats(@RequestParam LocalDateTime start,
                                       @RequestParam LocalDateTime end,
                                       @RequestParam(defaultValue = "false") boolean unique,
                                       @RequestParam(required = false) List<String> uris) {
        return hitService.getHits(start, end, uris, unique);
    }
}

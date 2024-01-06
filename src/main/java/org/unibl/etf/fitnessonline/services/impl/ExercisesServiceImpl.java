package org.unibl.etf.fitnessonline.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.unibl.etf.fitnessonline.models.dtos.ExerciseDTO;
import org.unibl.etf.fitnessonline.services.ExercisesService;

import java.util.List;

@Service
public class ExercisesServiceImpl implements ExercisesService {
    @Value("${exercises.url}")
    private String exercisesUrl;
    @Value("${api.key}")
    private String apiKey;
    @Override
    public List<ExerciseDTO> getExercisesByMuscle(String muscle) {
        String apiUrl = exercisesUrl + muscle;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExerciseDTO[]> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                ExerciseDTO[].class
        );

        ExerciseDTO[] exercisesArray = responseEntity.getBody();

        if (exercisesArray != null) {
            return List.of(exercisesArray);
        } else {
            return List.of();
        }
    }
}
